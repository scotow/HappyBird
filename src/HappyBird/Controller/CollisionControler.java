package HappyBird.Controller;

import HappyBird.Object.Constante;
import HappyBird.Object.Obstacle;
import HappyBird.Object.Oiseau;
import HappyBird.model.PlateauModel;
import HappyBird.view.HappyView;

public class CollisionControler {

	/**
	 * Concerne tous les controles de collisions
	 */
	
	
	private PlateauModel plateauModel;
	private HappyView happyView = null;

	public CollisionControler(PlateauModel plateauModel) {
		this.plateauModel = plateauModel;
	}

	/**
	 * Test la collision, et effectue un changement de couleur et un temps d'attente s'il y a collision
	 * @return vrai s'il la collision a ete effectuee(avec les changements), faux s'il n'y a pas de collisions
	 */
	public boolean collision() {
		for (int i = 0; i < plateauModel.getListeDObstacles().size(); i++) {
			if (controlCollision(plateauModel.getOiseau(), plateauModel.getObstacle(i))) {
				plateauModel.setObstaclesColor(Constante.OBSTACLE_TOUCHED_COLOR, i);
				plateauModel.setOiseauColor(Constante.BIRD_BREAK_COLOR);
				plateauModel.setWaiting(2000);
				plateauModel.stopFly();
				return true;
			}
			else {
				plateauModel.setObstaclesColor(Constante.OBSTACLE_NOT_TOUCHED_COLOR, i);
				plateauModel.setOiseauColor(Constante.BIRD_BODY_COLOR);
			}
		}
		if (controlCollision(plateauModel.getOiseau())) {
			plateauModel.setWaiting(1000);
			plateauModel.stopFly();
			return true;
		}
		return false;
	}

	/**
	 * Verifie la collision entre l'oiseau et un obstacle
	 * @param oiseau : l'oiseau concerne
	 * @param obstacles : l'obstacle concerne
	 * @return : vrai s'il y a collision, faux s'il n'y en a pas
	 */
	private boolean controlCollision(Oiseau oiseau, Obstacle obstacles) {
		boolean ok = false;
		if (happyView != null) {
			if (Math.abs(obstacles.getPositionX() - oiseau.getPositionX()) <= Constante.OBSTACLE_RADIUS / 2
					+ Constante.BIRD_BODY_RADIUS / 2
					&& Math.abs(obstacles.getPositionY() - oiseau.getPositionY()) <= Constante.OBSTACLE_RADIUS / 2
							+ Constante.BIRD_BODY_RADIUS / 2) {
				ok = true;
			}
		}
		return ok;
	}
	
	/**
	 * Verifie la collision entre l'oiseau et le reste du plateau
	 * @param oiseau : l'oiseau concerne
	 * @return vrai s'il y a collision, faux s'il n'y en a pas
	 */
	private boolean controlCollision(Oiseau oiseau){
		boolean ok = false;
		if (happyView != null) {
			if (oiseau.getPositionX() + Constante.BIRD_BODY_RADIUS /2 >= Constante.X_FRAME ||
					oiseau.getPositionY() + Constante.BIRD_BODY_RADIUS /2 >= Constante.Y_FRAME-10
					|| oiseau.getPositionX() + Constante.BIRD_BODY_RADIUS /2 <= 0) {
				ok = true;
			}
		}
		return ok;
	}
	
	/**
	 * Ajoute la vue du jeu dans le controleur
	 * @param happyView : la vue du jeu
	 */
	public void addView(HappyView happyView) {
		this.happyView = happyView;
	}
}
