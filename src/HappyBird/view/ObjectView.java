package HappyBird.view;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import HappyBird.Controller.CollisionController;
import HappyBird.Controller.PositionControler;
import HappyBird.Object.Constante;
import HappyBird.Object.Coordonnee;
import HappyBird.Object.TimerBouger;
import HappyBird.model.PlateauModel;

public class ObjectView extends JPanel implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected PlateauModel model;
	protected CollisionController collisionController;
	protected PositionControler positionControler;
	protected TimerBouger bouger;
	protected boolean random = false;

	public ObjectView(PlateauModel plateauModel, CollisionController collisionController,
			PositionControler positionControler) {
		this.model = plateauModel;
		this.collisionController = collisionController;
		this.positionControler = positionControler;
		this.bouger = new TimerBouger(ObjectView.this, plateauModel, collisionController, positionControler);
		plateauModel.addObserver(ObjectView.this);
	}

	@Override
	public void update(Observable o, Object arg) {
		this.repaint();
	}

	public void bouger() {
		bouger.bouger();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(new ImageIcon(getClass().getResource("/HappyBird/view/images/background.png")).getImage(), 0, 0,
				null);
		g.setColor(Constante.POINT_BEZIER);
		for (int i = 0; i < model().getRectangles().size(); i++) {
			if (i%50 == 0) {
				g.fillRect(model().getRectangleByIndex(i).x, model().getRectangleByIndex(i).y,
						model().getRectangleByIndex(i).width, model().getRectangleByIndex(i).height);
			}
		}
	}

	public void resetPosition() {
		model.setCompteur(0);
		model.setOiseauPostion(Constante.BIRD_BODY_RADIUS * 2, Constante.Y_FRAME - (Constante.BIRD_BODY_RADIUS * 3));
		model.setT(0);
		if (model.getFlyTimer() != null)
			if (model.getFlyTimer().isRunning())
				model.stopFly();
	}

	public void resetPlateau() {
		resetPosition();
		model.clearPoint();
		model.clearRectangles();
		positionControler.fixePointBezier((random) ? 0 : clickPut().getX(), (random) ? 0 : clickPut().getY(), random);
		bouger();
	}

	public void simulationDeVol() {
		Timer waitingTimer = new Timer();
		waitingTimer.schedule(new TimerTask() {
			@Override
			public void run() {
				resetPlateau();
			}
		}, model.getWaiting());
		model.setSimulation(model.getSimulation() - 1);
		;
		if (model.getSimulation() == 0)
			System.exit(0);
	}

	public Coordonnee clickPut() {
		final Coordonnee point = new Coordonnee(0, 0);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					point.setX(e.getLocationOnScreen().getX());
					point.setY(e.getLocationOnScreen().getY());
				}
			}
		});
		return point;
	}

	public PlateauModel model() {
		return model;
	}

}