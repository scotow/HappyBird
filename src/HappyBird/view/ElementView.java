package HappyBird.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.util.Observable;

import HappyBird.Controller.CollisionControler;
import HappyBird.Controller.PositionControler;
import HappyBird.Object.Bounds.RectangleBounds;
import HappyBird.Object.Config.Constante;
import HappyBird.model.PlateauModel;
import HappyBird.view.Move.Mouvement;

public class ElementView extends ObjectView {

	/**
	 * Concerne l'affichage des elements, herite de la vue objet
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Cree la vue element et place des point de bezier puis fixe les obstacles
	 * et d�ｿｽmarre l'animation
	 * 
	 * @param plateauModel
	 *            : le plateau de jeu
	 * @param collisionControler
	 *            : le controleur de collision
	 * @param positionControler
	 *            : le controler de position
	 */
	public ElementView(PlateauModel plateauModel, CollisionControler collisionControler,
			PositionControler positionControler) {
		super(plateauModel, collisionControler, positionControler);
		random = true;
		//positionControler.fixeCourbe();
		//positionControler.fixeOiseau();
		positionControler.fixeObstacles((random) ? 0 : clickPut().getX(), (random) ? 0 : clickPut().getY(), random);
		this.resetPlateau();
		
		//bouger();
		
	}

	@Override
	public void update(Observable o, Object arg) {
		ElementView.this.repaint();
	}

	/**
	 * Affiche les differents objets
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < model().getListeDObstacles().size(); i++) {
			g.setColor(model().getObstaclesColor(i));
			if (model().getObstacle(i).getBounds() instanceof RectangleBounds) {
				g.fillRect((int) model().getObstaclePostion(i).getX() - model().getObstacleTaille(i)[0] / 2,
						(int) model().getObstaclePostion(i).getY() - model().getObstacleTaille(i)[1] / 2,
						model().getObstacleTaille(i)[0], model().getObstacleTaille(i)[1]);
			}
			else{
			g.fillOval((int) model().getObstaclePostion(i).getX() - model().getObstacleTaille(i)[0] / 2,
					(int) model().getObstaclePostion(i).getY() - model().getObstacleTaille(i)[1] / 2,
					model().getObstacleTaille(i)[0], model().getObstacleTaille(i)[1]);
			}
		}
		g.setColor(Constante.POINT_BEZIER);

		/*
		 * for (int i = 0; i < model().getListeDePoint().size(); i++) {
		 * g.fillOval((int) model().getPoint(i).getX(), (int)
		 * model().getPoint(i).getY(), 15, 15); if (i >= 1) { g.drawLine((int)
		 * model().getPoint(i - 1).getX() + 15 / 2, (int) model().getPoint(i -
		 * 1) .getY() + 15 / 2, (int) model().getPoint(i).getX() + 15 / 2, (int)
		 * model().getPoint(i) .getY() + 15 / 2); } }
		 */

		for (int i = 0; i < model().getRectangles().size(); i++) {
			if (i % 150 == 0) {
				g.fillRect(model().getRectangleByIndex(i).x, model().getRectangleByIndex(i).y,
						model().getRectangleByIndex(i).width, model().getRectangleByIndex(i).height);
			}
		}
		g.setColor(model().getBecOiseauColor());
		model().setBecOiseau();
			Graphics2D graphics2d = (Graphics2D) g.create();
		AffineTransform old = graphics2d.getTransform();
	
		/********************Ancien calcul de l'orientation*****************************/
		//double n = Math
		//double n = model().getCourbe().calculerOrientation(model());
		//System.out.println("La tangente a modifier : "+n);
		//System.out.println("Coordonnees X/Y:"+model().getBecOiseauPosition());
		//System.out.println(model.getT());
		
		
		//System.out.println(model.getOiseauPostion().getX()+"//"+model.getOiseauPostion().getY());
		
		/**************************Autre calcul de l'orientation***************************/
		List<Point> temp = model.getOiseau().getListePointBec();
		Point a = temp.get(0);
		Point b = temp.get(1);
		Point c = temp.get(2);
		
		int angleX = v.angleXOiseau(1);
		int angleY = v.angleYOiseau(1);
		a = model.getCourbe().rotatePoint (a,new Point ((int)model.getOiseauPostion().getX(),(int) model.getOiseauPostion().getY()),angleX );
		b = model.getCourbe().rotatePoint (b,new Point ((int)model.getOiseauPostion().getX(),(int) model.getOiseauPostion().getY()),angleX );
		c = model.getCourbe().rotatePoint (c,new Point ((int)model.getOiseauPostion().getX(),(int) model.getOiseauPostion().getY()),angleX );
		
		temp = new ArrayList<Point>();
		temp.add(a);
		temp.add(b);
		temp.add(c);
		model.getOiseau().setListePointBec(temp);
		/*------------------------------------------------------------------------------------*/
		
		graphics2d.fillPolygon(model().getBecOiseauPolygon());
		graphics2d.setTransform(old);
		
		/*g.setColor(model().getBecOiseauColor());
		model().setBecOiseau();
			Graphics2D graphics2d = (Graphics2D) g.create();
		AffineTransform old = graphics2d.getTransform();
		graphics2d.rotate(180);
		graphics2d.fillPolygon(model().getBecOiseauPolygon());
		graphics2d.setTransform(old);*/
		
		g.setColor(model().getOiseauColor());
		g.fillOval((int) model().getOiseauPostion().getX() - model().getOiseauTaille()[0] / 2,
				(int) model().getOiseauPostion().getY() - model().getOiseauTaille()[1] / 2,
				model().getOiseauTaille()[0], model().getOiseauTaille()[1]);
	}

}
