package HappyBird;


public class Obstacle extends Bounds{

	/**
	 * 
	 * @author garbey
	 * Il s'agit des obstacles qui apparaissent sur l'ecran
	 * 
	 */

	private boolean touched = false;
	
	/**
	 * Cree un obstacle
	 * @param x : la position de x
	 * @param y : la position de y
	 */
	public Obstacle (double x, double y) {
            super(x, y, (int)(Constante.OBSTACLE_RADIUS),(int)(Constante.OBSTACLE_RADIUS));
	}

	/**
	 * Retourne vrai s'il y a collision avec deux obstacles
	 * @param Obstacle o a analyser
	 * @return true s'il y a collision
	 */

	public boolean isTouched(){
		return touched;
	}

	public void touched(){
		touched = true;
	}


}
