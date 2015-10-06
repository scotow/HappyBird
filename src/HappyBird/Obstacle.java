package HappyBird;

import javax.swing.JPanel;



public class Obstacle extends JPanel{

	/**
	 * 
	 * @author garbey
	 * Il s'agit des obstacles qui apparaissent sur l'ecran
	 * 
	 */
	private int x, y, rayon;

	
	/**
	 * Cree un obstacle
	 * @param x : la position de x
	 * @param y : la position de y
	 * @param rayon : le rayon du cercle
	 */
	public Obstacle (int x, int y, int rayon) {
		this.x = x;
		this.y = y;
		this.rayon = rayon;
	}

	/**
	 * Retourne vrai s'il y a collision avec deux obstacles
	 * @param Obstacle o a analyser
	 * @return true s'il y a collision
	 */
	public boolean collision (Obstacle o) {
		if (this.getX() == o.getX() && this.getY() == o.getY()) {
			return true;
		}
		return false;
	}
	

	/*-------------------Les getter-----------------------------*/
	
	/**
	 * Retourne la position x
	 * @return x : la position x de l'obstacle
	 */
	public int getX() {
		return this.x;
	}
	
	/**
	 * Retourne la position y
	 * @return y : la position y de l'obstacle
	 */
	public int getY() {
		return this.y;
	}
	
	/**
	 * Retourne le rayon
	 * @return rayon : le rayon
	 */
	
	public int getRayon() {
		return this.rayon;
	}
}
