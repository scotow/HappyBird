package HappyBird;



public class Obstacle extends Coordonnee{

	/**
	 * 
	 * @author garbey
	 * Il s'agit des obstacles qui apparaissent sur l'ecran
	 * 
	 */



	public static final int RADIUS = 15;
	
	/**
	 * Cree un obstacle
	 * @param x : la position de x
	 * @param y : la position de y
	 */
	public Obstacle (int x, int y) {
            super(x, y);
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
}
