package HappyBird;

import java.awt.Color;

public class Obstacle extends Bounds{

	/**
	 * 
	 * @author garbey
	 * Il s'agit des obstacles qui apparaissent sur l'ecran
	 * 
	 */



	public static final int RADIUS = 15;
    public static final Color OBSTACLES_BODY_COLOR = Color.ORANGE;
    public static final Color OBSTRACLES_BEAK_COLOR = Color.GRAY;
	public int collision = 0;
	
	/**
	 * Cree un obstacle
	 * @param x : la position de x
	 * @param y : la position de y
	 */
	public Obstacle (int x, int y) {
            super((double)x, (double)y, RADIUS);
	}
	
	public int getCollision() {
		return collision;
	}

	/**
	 * Retourne vrai s'il y a collision avec deux obstacles
	 * @param Obstacle o a analyser
	 * @return true s'il y a collision
	 */
	public boolean collision(Oiseau oiseau) {
		return super.equalsCercle(oiseau);
	}
}
