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
		
		if (!model.getOiseau().estLance()) {
			
		
			List<Point> temp = model.getOiseau().getListePointBec();
			Point a = temp.get(0);
			Point b = temp.get(1);
			Point c = temp.get(2);
			/*System.out.println("Point a : "+a.x+"@@"+a.y);
			System.out.println("Point b : "+b.x+"@@"+b.y);
			System.out.println("Point c : "+c.x+"@@"+c.y);
			System.out.println("Oiseau : "+model.getOiseauPostion().getX()+"@@"+model.getOiseauPostion().getY());
			System.out.println("Bec : "+model.getBecOiseauPosition().getX()+"@@"+model.getBecOiseauPosition().getY());*/
			
			double angle = model.getCourbe().donnerAngle((int)model.getOiseauPostion().getX(), (int)model.getOiseauPostion().getY(),
					50,350);
			//System.out.println("************************************************");
			//System.out.println(angle);
			a = model.getCourbe().rotatePoint (a,new Point ((int)model.getOiseauPostion().getX(),(int) model.getOiseauPostion().getY()),0);
			b = model.getCourbe().rotatePoint (b,new Point ((int)model.getOiseauPostion().getX(),(int) model.getOiseauPostion().getY()),0 );
			c = model.getCourbe().rotatePoint (c,new Point ((int)model.getOiseauPostion().getX(),(int) model.getOiseauPostion().getY()),0 );
			
			
			/*System.out.println("New Point a : "+a.x+"@@"+a.y);
			System.out.println("New Point b : "+b.x+"@@"+b.y);
			System.out.println("New Point c : "+c.x+"@@"+c.y);
			System.out.println("************************************************");*/
			temp = new ArrayList();
			temp.add(a);
			temp.add(b);
			temp.add(c);
			model.getOiseau().setListePointBec(temp);
			//model.getOiseau().neBougePlus();
			
			/** Suite à une volonté estétique et un défaut de temps, le bec ne sera pas visible lors du drag n drop
			 * g.fillPolygon(model.getBecOiseauPolygon());
			 */
		} else {
			
			
			List<Point> temp = model.getOiseau().getListePointBec();
			Point a = temp.get(0);
			Point b = temp.get(1);
			Point c = temp.get(2);
			double angle = model.getCourbe().donnerAngle((int)model.getOiseauPostion().getX(), (int)model.getOiseauPostion().getY(),
					50,350);
			if (a.x-68 <0 )
				angle+=180;
			//System.out.println(angle);
			//a = model.getCourbe().rotatePoint (a,new Point ((int)model.getOiseauPostion().getX(),(int) model.getOiseauPostion().getY()),360-angle);
			//b = model.getCourbe().rotatePoint (b,new Point ((int)model.getOiseauPostion().getX(),(int) model.getOiseauPostion().getY()),360-angle );
			//c = model.getCourbe().rotatePoint (c,new Point ((int)model.getOiseauPostion().getX(),(int) model.getOiseauPostion().getY()),360-angle );
			
			
			a = model.getCourbe().rotatePoint (a,new Point ((int)model.getOiseauPostion().getX(),(int) model.getOiseauPostion().getY()),angle);
			b = model.getCourbe().rotatePoint (b,new Point ((int)model.getOiseauPostion().getX(),(int) model.getOiseauPostion().getY()),angle );
			c = model.getCourbe().rotatePoint (c,new Point ((int)model.getOiseauPostion().getX(),(int) model.getOiseauPostion().getY()),angle );
			
			temp = new ArrayList();
			temp.add(a);
			temp.add(b);
			temp.add(c);
			model.getOiseau().setListePointBec(temp);
			
			g.fillPolygon(model.getBecOiseauPolygon());	
		}
		//si loiseau est lance go afficher droitebuiczb
	
			
			
		

		
		/**************************Autre calcul de l'orientation***************************/
		/*List<Point> temp = model.getOiseau().getListePointBec();
		Point a = temp.remove(0);
		Point b = temp.remove(0);
		Point c = temp.remove(0);
		
		
		int angleX = v.angleXOiseau(1);
		int angleY = v.angleYOiseau(1);
		System.out.println("Avant");
		a = model.getCourbe().rotatePoint (a,new Point ((int)model.getOiseauPostion().getX(),(int) model.getOiseauPostion().getY()),0 );
		b = model.getCourbe().rotatePoint (b,new Point ((int)model.getOiseauPostion().getX(),(int) model.getOiseauPostion().getY()),0 );
		c = model.getCourbe().rotatePoint (c,new Point ((int)model.getOiseauPostion().getX(),(int) model.getOiseauPostion().getY()),0 );
		
		
		g.fillPolygon(model.getBecOiseauPolygon());*/
		/*------------------------------------------------------------------------------------*/
		
		//graphics2d.fillPolygon(model().getBecOiseauPolygon());
		//graphics2d.setTransform(old);
		
		
		/*g.setColor(model().getBecOiseauColor());
		model().setBecOiseau();
			Graphics2D graphics2d = (Graphics2D) g.create();
		AffineTransform old = graphics2d.getTransform();
		graphics2d.rotate(n);
		graphics2d.fillPolygon(model().getBecOiseauPolygon());
		graphics2d.setTransform(old);*/
		
		g.setColor(model().getOiseauColor());
		g.fillOval((int) model().getOiseauPostion().getX() - model().getOiseauTaille()[0] / 2,
				(int) model().getOiseauPostion().getY() - model().getOiseauTaille()[1] / 2,
				model().getOiseauTaille()[0], model().getOiseauTaille()[1]);
	}
	
	

}
