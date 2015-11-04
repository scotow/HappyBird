package HappyBird.Object;

import java.awt.Color;


public class Obstacle extends Bounds{

	/**
	 * 
	 * @author garbey
	 * Il s'agit des obstacles qui apparaissent sur l'ecran
	 * 
	 */
	private double positionX;
	private double positionY;
	
	private Color color = Constante.OBSTACLE_NOT_TOUCHED_COLOR;
	/**
	 * Cree un obstacle
	 * @param x : la position de x
	 * @param y : la position de y
	 */
	public Obstacle (double x, double y) {
		super(x, y, Constante.OBSTACLE_RADIUS, Constante.OBSTACLE_RADIUS);
		this.positionX = x;
		this.positionY = y;
	}
	
	/**
	 * Modifie la position des obstacles
	 * @param positionX : la nouvelle position x
	 * @param positionY : la nouvelle position y
	 */
	public void setPosition(double positionX, double positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
	}
	
	/**
	 * Retourne les coordonnees de la position de l'obstacle
	 * @return la position de l'obstacle en type coordonnee
	 */
	public Coordonnee getPostionCoordonnee(){
		return new Coordonnee(positionX, positionY);
	}
	
	/**
	 * Retourne la position X de l'obstacle
	 * @return la position x de l'obstacle
	 */
    public double getPositionX() {
		return positionX;
	}
    
    /**
     * Retourne la position X de l'obstacle
     * @return la position Y de l'obstacle
     */
    public double getPositionY() {
		return positionY;
	}
    
    @Override
    public int getWidth() {
    	return super.getWidth();
    }
    
    @Override
    public int getHeight() {
    	return super.getHeight();
    }
    
    /**
     * Modifie la couleur de l'obstacle
     * @param color : la nouvelle couleur de l'obstacle
     */
    public void setObstacleColor(Color color) {
		this.color = color;
	}
    
    /**
     * Retourne la couleur de l'obstacle 
     * @return la couleur de l'obstacle
     */
    public Color getObstacleColor() {
		return color;
	}


}