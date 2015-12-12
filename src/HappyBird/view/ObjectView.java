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

import HappyBird.Controller.CollisionControler;
import HappyBird.Controller.PositionControler;
import HappyBird.Object.Config.Coordonnee;
import HappyBird.model.PlateauModel;
import HappyBird.view.Move.Mouvement;
import HappyBird.view.Move.TimerBouger;

public class ObjectView extends JPanel implements Observer {

	/**
	 * Concerne les principales(et grosses) methodes de jeu, implement observeur
	 */
	private static final long serialVersionUID = 1L;
	protected PlateauModel model;
	protected CollisionControler collisionControler;
	protected PositionControler positionControler;
	protected TimerBouger bouger;
	protected boolean random = false;
	protected Mouvement v;

	/**
	 * Cree la vue objectif
	 * 
	 * @param plateauModel
	 *            : le plateau de jeu
	 * @param collisionControler
	 *            : le controleur de collision
	 * @param positionControler
	 *            : le controleur de position
	 */
	public ObjectView(PlateauModel plateauModel, CollisionControler collisionControler,
			PositionControler positionControler) {
		this.model = plateauModel;
		this.v = new Mouvement ((int)(plateauModel.getOiseauPostion().getX()), (int)(plateauModel.getOiseauPostion().getY()),
	    		25,50);
		this.collisionControler = collisionControler;
		this.positionControler = positionControler;
		this.bouger = new TimerBouger(ObjectView.this, plateauModel, collisionControler, positionControler);
		plateauModel.addObserver(ObjectView.this);
	}

	@Override
	public void update(Observable o, Object arg) {
		this.repaint();
	}

	/**
	 * Permet le deplacement
	 */
	public void bouger() {
		
		bouger.bouger();
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(new ImageIcon(getClass().getResource("/HappyBird/view/images/background.png")).getImage(), 0, 0, null);
	}

	/**
	 * Reset tout les elements.
	 */
	public void resetPlateau() {
		
		model.clearPoint();
		model.setCompteurListe(model.getCompteurListe() + 1);
		if (model.getCompteurListe() > 10)
			System.exit(0);
		model.clearRectangles();
		
		
		
	
		
		
		//model.setOiseauPosition(model.getPoint(0).getX(), model.getPoint(0).getY());
		
		model.setTemps(0);	
		model.setT(0);
		
		model.setOiseauPosition(50.0, 350.0);
		
		
		if (model.getFlyTimer() != null)
			if (model.getFlyTimer().isRunning())
				model.stopFly();
		
		
		//bouger();
	}

	/**
	 * Boucle de jeu, tant que la simulation != 0 le jeu continue
	 */
	public void simulationDeVol() {
		
		Timer waitingTimer = new Timer();
		waitingTimer.schedule(new TimerTask() {
			@Override
			public void run() {
				resetPlateau();
			}
		}, model.getWaiting());
		model.setSimulation(model.getSimulation() - 1);
		if (model.getSimulation() == 0)
			System.exit(0);
	}

	/**
	 * Sert pour le reset de coordonnees initiales
	 * 
	 * @return les coordonnees initiales d'un point
	 */
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

	/**
	 * Retourne le plateau de jeu
	 * 
	 * @return le plateau de jeu
	 */
	public PlateauModel model() {
		return model;
	}
	
	public Mouvement getMouvement() {
		return v;
	}
	
	public PositionControler getPC() {
		return this.positionControler;
	}

}
