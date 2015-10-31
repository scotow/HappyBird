package HappyBird.Object;

import java.awt.Color;


public class Obstacle{

	/**
	 * 
	 * @author garbey
	 * Il s'agit des obstacles qui apparaissent sur l'ecran
	 * 
	 */

	private boolean touched = false;
	private double positionX;
	private double positionY;
	
	private Color color = Constante.OBSTACLE_NOT_TOUCHED_COLOR;
	/**
	 * Cree un obstacle
	 * @param x : la position de x
	 * @param y : la position de y
	 */
	public Obstacle (double x, double y) {
		this.positionX = x;
		this.positionY = y;
            //super(x, y, (int)(Constante.OBSTACLE_RADIUS),(int)(Constante.OBSTACLE_RADIUS));
	}
	
	public void setPosition(double positionX, double positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
	}
	
	public Coordonnee getPostionCoordonnee(){
		return new Coordonnee(positionX, positionY);
	}
	
    public double getPositionX() {
		return positionX;
	}
    
    public double getPositionY() {
		return positionY;
	}
    
    public void setObstacleColor(Color color) {
		this.color = color;
	}
    
    public Color getObstacleColor() {
		return color;
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
