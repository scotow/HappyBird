package HappyBird.view;

import java.awt.Graphics;
import java.util.Observable;

import javax.swing.JOptionPane;

import HappyBird.Controller.CollisionController;
import HappyBird.Controller.PositionControler;
import HappyBird.Object.Constante;
import HappyBird.model.PlateauModel;

public class ElementView extends ObjectView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ElementView(PlateauModel plateauModel, CollisionController collisionController,
			PositionControler positionControler) {
		super(plateauModel, collisionController, positionControler);
		int choix = JOptionPane.showConfirmDialog(null, "Random ?");
		if (choix == JOptionPane.OK_OPTION) {
			random = true;
		} else {
			random = false;
		}
		positionControler.fixePointBezier((random) ? 0 : clickPut().getX(), (random) ? 0 : clickPut().getY(), random);
		positionControler.fixeObstacles((random) ? 0 : clickPut().getX(), (random) ? 0 : clickPut().getY(), random);
		bouger();
	}

	@Override
	public void update(Observable o, Object arg) {
		ElementView.this.repaint();
	}


	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < model().getListeDObstacles().size(); i++) {
			g.setColor(model().getObstaclesColor(i));
			g.fillOval((int) model().getObstaclePostion(i).getX() - Constante.OBSTACLE_RADIUS / 2,
					(int) model().getObstaclePostion(i).getY() - Constante.OBSTACLE_RADIUS / 2,
					Constante.OBSTACLE_RADIUS, Constante.OBSTACLE_RADIUS);
		}
		/*for (int i = 0; i < model().getListeDePoint().size(); i++) {
			g.setColor(Constante.POINT_BEZIER);
			g.fillOval((int) model().getPoint(i).getX(), (int) model().getPoint(i).getY(), 15, 15);
		}*/
		g.setColor(model().getOiseauColor());
		g.fillOval((int) model().getOiseauPostion().getX() - Constante.BIRD_BODY_RADIUS / 2,
				(int) model().getOiseauPostion().getY() - Constante.BIRD_BODY_RADIUS / 2, Constante.BIRD_BODY_RADIUS,
				Constante.BIRD_BODY_RADIUS);
	}

}