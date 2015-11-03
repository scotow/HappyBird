package HappyBird.Controller;

import java.util.Random;

import HappyBird.Object.Constante;
import HappyBird.Object.Coordonnee;
import HappyBird.Object.Obstacle;
import HappyBird.model.PlateauModel;
import HappyBird.view.HappyView;

public class PositionControler {

	private PlateauModel plateauModel;
	private HappyView happyView = null;

	public PositionControler(PlateauModel plateauModel) {
		this.plateauModel = plateauModel;
	}

	public void fixePointBezier(double x, double y, boolean random) {
		if (random) {
			Random rand = new Random();
			plateauModel.addPoint(new Coordonnee(plateauModel.getOiseauPostion().getX(), plateauModel.getOiseauPostion().getY())); // Premier
			plateauModel.addPoint(new Coordonnee(rand.nextInt(50) + Constante.X_FRAME / 5,
					rand.nextInt(100) + Constante.Y_FRAME / 4)); // Deuxieme
			plateauModel.addPoint(new Coordonnee(rand.nextInt(50) + Constante.X_FRAME - 150,
					rand.nextInt(100) + Constante.Y_FRAME / 5)); // Troisieme
			plateauModel.addPoint(new Coordonnee(Constante.X_FRAME, rand.nextInt(100) + Constante.Y_FRAME / 4)); // Quatrieme
		} else {
			if (controlPoint(x, y)) {
				plateauModel.addPoint(new Coordonnee(x, y));
			}
		}
	}

	public void fixeObstacles(double x, double y, boolean random) {
		if (random) {
			for (int i = 0; i < Constante.OBSTACLES_LIST_CAPACITY; i++) {
				Random rand = new Random();
				Obstacle tmp = new Obstacle(rand.nextInt(Constante.X_FRAME / 3) + Constante.X_FRAME / 3 * 2 - 20,
						rand.nextInt(Constante.Y_FRAME / 2));
				boolean valuable = true;
				for (Obstacle j : plateauModel.getListeDObstacles()) {
					if (Math.abs(tmp.getPositionX() - j.getPositionX()) <= Constante.OBSTACLE_RADIUS * 2
							&& Math.abs(tmp.getPositionY() - j.getPositionY()) <= Constante.OBSTACLE_RADIUS * 2) {
						i--;
						valuable = false;
						break;
					}
				}
				if (valuable){
					plateauModel.addObstacles(tmp); 
					//System.out.println("Obstacle placer à ("+tmp.getPositionX()+";"+tmp.getPositionY()+").");
				}
			}
		} else {
			if (controlObstacle(x, y)) {
				plateauModel.addObstacles(new Obstacle(x, y));
				//System.out.println("Obstacle placer à ("+x+";"+y+").");
			}
		}
	}
	
	public void fixeOiseau(){
		Coordonnee tmp = plateauModel.getCourbe().calculerPoint(plateauModel.getListeDePoint(), plateauModel.getT());
		//System.out.println("Obstacle placer à "+ tmp.toString() +".");
		plateauModel.setOiseauPosition(tmp.getX(), tmp.getY() + Constante.BIRD_BODY_RADIUS/2-3);
	}

	private boolean controlPoint(double x, double y) {
		boolean ok = false;
		if (happyView != null) {
			if (plateauModel.getListeDePoint().size() < Constante.POINT_LIST_CAPACITY) {
				if ((x < Constante.X_FRAME && x > 0) && (y < Constante.Y_FRAME && y > 0)) {
					ok = true;
				}
			}
		}
		return ok;
	}

	private boolean controlObstacle(double x, double y) {
		boolean ok = false;
		if (happyView != null) {
			if (plateauModel.getListeDObstacles().size() < Constante.OBSTACLES_LIST_CAPACITY) {
				if ((x < Constante.X_FRAME && x > 0) && (y < Constante.Y_FRAME && y > 0)) {
					ok = true;
				}
			}
		}
		return ok;
	}

	public void addView(HappyView happyView) {
		this.happyView = happyView;
	}
}
