package HappyBird.Controller;

import HappyBird.Object.Constante;
import HappyBird.Object.Obstacle;
import HappyBird.Object.Oiseau;
import HappyBird.model.PlateauModel;
import HappyBird.view.HappyView;

public class CollisionControler {

	private PlateauModel plateauModel;
	private HappyView happyView = null;

	public CollisionControler(PlateauModel plateauModel) {
		this.plateauModel = plateauModel;
	}

	public boolean Collision() {
		for (int i = 0; i < plateauModel.getListeDObstacles().size(); i++) {
			if (controlCollision(plateauModel.getOiseau(), plateauModel.getObstacle(i))) {
				plateauModel.setObstaclesColor(Constante.OBSTACLE_TOUCHED_COLOR, i);
				plateauModel.setOiseauColor(Constante.BIRD_BREAK_COLOR);
				plateauModel.setWaiting(2000);
				return true;
			}
			else {
				plateauModel.setObstaclesColor(Constante.OBSTACLE_NOT_TOUCHED_COLOR, i);
				plateauModel.setOiseauColor(Constante.BIRD_BODY_COLOR);
			}
		}
		if (controlCollision(plateauModel.getOiseau())) {
			plateauModel.setWaiting(1000);
			return true;
		}
		return false;
	}

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
	
	private boolean controlCollision(Oiseau oiseau){
		boolean ok = false;
		if (happyView != null) {
			if (oiseau.getPositionX() + Constante.BIRD_BODY_RADIUS /2 >= Constante.X_FRAME ||
					oiseau.getPositionY() + Constante.BIRD_BODY_RADIUS /2 >= Constante.Y_FRAME) {
				ok = true;
			}
		}
		return ok;
	}

	public void addView(HappyView happyView) {
		this.happyView = happyView;
	}
}
