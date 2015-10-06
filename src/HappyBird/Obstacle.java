package HappyBird;

import javax.swing.JPanel;



public class Obstacle extends JPanel{

	/**
	 * 
	 * @author garbey
	 * Il s'agit des obstacles qui apparaissent sur l'ecran
	 * 
	 */
	private Coordonnee c;
	private int rayon;

	
	/**
	 * Cree un obstacle
	 * @param x : la position de x
	 * @param y : la position de y
	 * @param rayon : le rayon du cercle
	 */
	public Obstacle (int x, int y, int rayon) {
		this.c = new Coordonnee (x,y);
		this.rayon = rayon;
	}
	
	public Obstacle (Coordonnee c) {
		this.c = c;
		
	}

	/**
	 * Retourne vrai s'il y a collision avec deux obstacles
	 * @param Obstacle o a analyser
	 * @return true s'il y a collision
	 */
	public boolean collision (Obstacle o) {
		if (this.getCoord().equals(o.getCoord())) {
			return true;
		}
		return false;
	}
	

	/*-------------------Les getter-----------------------------*/
	
	/**
	 * Retourne les coordonnees de l'obstacle
	 * @return c : les coordonnees de l'obstacle
	 */
	public Coordonnee getCoord () {
		return this.c;
	}
	
	/**
	 * Retourne le rayon
	 * @return rayon : le rayon
	 */
	
	public int getRayon() {
		return this.rayon;
	}
}
