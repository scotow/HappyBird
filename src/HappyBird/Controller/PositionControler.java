package HappyBird.Controller;

import java.util.Random;

import HappyBird.Object.Constante;
import HappyBird.Object.Coordonnee;
import HappyBird.Object.Obstacle;
import HappyBird.model.PlateauModel;
import HappyBird.view.HappyView;

public class PositionControler {

	/**
	 * Concerne tous les controles de positionnement (notamment pour le lancement du processus)
	 */
	
	private PlateauModel plateauModel;
	private HappyView happyView = null;

	
	/**
	 * Cree un Controleur de position
	 * @param plateauModel le plateau de jeu
	 */
	public PositionControler(PlateauModel plateauModel) {
		this.plateauModel = plateauModel;
	}

	/**
	 * Permet de placer des coordonnees pour la trajectoire de l'oiseau, de façon aleatoire ou non
	 * @param x : le positionnement en x s'il n'est pas aleatoire
	 * @param y : le positionnement en y s'il n'est pas aleatoire
	 * @param random : decide si le point est aleatoire ou non
	 */
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

	/**
	 * Permet de placer les obstacles, de façon aleatoire ou non 
	 * @param x : le positionnement en x s'il n'est pas aleatoire
	 * @param y : le positionnement en y s'il n'est pas aleatoire
	 * @param random : decide si l'obstacle est aleatoire ou non
	 */
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
					//System.out.println("Obstacle placer a ("+tmp.getPositionX()+";"+tmp.getPositionY()+").");
				}
			}
		} else {
			if (controlObstacle(x, y)) {
				plateauModel.addObstacles(new Obstacle(x, y));
				//System.out.println("Obstacle placer a ("+x+";"+y+").");
			}
		}
	}
	
	/**
	 * Permet de placer l'oiseau dans la partie droite du plateau de jeu
	 */
	public void fixeOiseau(){
		Coordonnee tmp = plateauModel.getCourbe().calculerPoint(plateauModel.getListeDePoint(), plateauModel.getT());
		//System.out.println("Obstacle placer  "+ tmp.toString() +".");
		plateauModel.setOiseauPosition(tmp.getX(), tmp.getY() + Constante.BIRD_BODY_RADIUS/2-3);
	}
	
	/**
	 * Teste si la liste et les coordonnees du point sont correctes
	 * @param x : la position x du point de bezier
	 * @param y : la position y du point de bezier
	 * @return vrai si correctes, faux si incorrectes
	 */
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

	/**
	 * Teste si la liste et les coordonnees de l'obstacle sont correctes
	 * @param x : la position x de l'obstacle
	 * @param y : la position y de l'obstacle
	 * @return vrai si correctes, faux si incorrectes
	 */
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

	/**
	 * Ajoute la vue du jeu dans le controleur
	 * @param happyView : la vue du jeu
	 */
	public void addView(HappyView happyView) {
		this.happyView = happyView;
	}
}
