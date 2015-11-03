package HappyBird.view;

import java.awt.Graphics;
import java.util.Observable;


import HappyBird.Controller.CollisionControler;
import HappyBird.Controller.PositionControler;
import HappyBird.Object.Constante;
import HappyBird.model.PlateauModel;

public class ElementView extends ObjectView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ElementView(PlateauModel plateauModel, CollisionControler collisionControler,
			PositionControler positionControler) {
		super(plateauModel, collisionControler, positionControler);
		random = true;
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
		g.setColor(Constante.POINT_BEZIER);
		for (int i = 0; i < model().getListeDePoint().size(); i++) {
			g.fillOval((int) model().getPoint(i).getX(), (int) model().getPoint(i).getY(), 15, 15);
			if (i >= 1) {
				g.drawLine((int)model().getPoint(i-1).getX() + 15/2, (int)model().getPoint(i-1).getY() + 15/2,
						(int)model().getPoint(i).getX() + 15/2, (int)model().getPoint(i).getY() + 15/2);
			}
		}
		for (int i = 0; i < model().getRectangles().size(); i++) {
			if (i % 80 == 0) {
				g.fillRect(model().getRectangleByIndex(i).x, model().getRectangleByIndex(i).y,
						model().getRectangleByIndex(i).width, model().getRectangleByIndex(i).height);
			}
		}
		g.setColor(model().getOiseauColor());
		g.fillOval((int) model().getOiseauPostion().getX() - Constante.BIRD_BODY_RADIUS / 2,
				(int) model().getOiseauPostion().getY() - Constante.BIRD_BODY_RADIUS / 2, Constante.BIRD_BODY_RADIUS,
				Constante.BIRD_BODY_RADIUS);
	}

}