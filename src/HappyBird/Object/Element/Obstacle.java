package HappyBird.Object.Element;

import java.awt.Color;

import HappyBird.Exception.BoundsException;
import HappyBird.Object.Bounds.Bounds;
import HappyBird.Object.Bounds.BoundsFactory;
import HappyBird.Object.Config.Constante;
import HappyBird.Object.Config.Coordonnee;


public class Obstacle{

  /**
   * 
   * @author garbey Il s'agit des obstacles qui apparaissent sur l'ecran
   * 
   */
  private double positionX;
  private double positionY;

  private Color color = Constante.OBSTACLE_NOT_TOUCHED_COLOR;
  
  private Bounds bounds;

  /**
   * Cree un obstacle
   * 
   * @param x : la position de x
   * @param y : la position de y
   */
  public Obstacle(double x, double y, int width, int height, String type) {
    this.positionX = x;
    this.positionY = y;
    try {
		bounds = BoundsFactory.boundsFactory(type, x, y, width, height);
	} catch (BoundsException e) {
		e.boundsMessageError();
	}
  }

  /**
   * Modifie la position des obstacles
   * 
   * @param positionX : la nouvelle position x
   * @param positionY : la nouvelle position y
   */
  public void setPosition(double positionX, double positionY) {
    this.positionX = positionX;
    this.positionY = positionY;
  }

  /**
   * Retourne les coordonnees de la position de l'obstacle
   * 
   * @return la position de l'obstacle en type coordonnee
   */
  public Coordonnee getPostionCoordonnee() {
    return new Coordonnee(positionX, positionY);
  }

  /**
   * Retourne la position X de l'obstacle
   * 
   * @return la position x de l'obstacle
   */
  public double getPositionX() {
    return positionX;
  }

  /**
   * Retourne la position X de l'obstacle
   * 
   * @return la position Y de l'obstacle
   */
  public double getPositionY() {
    return positionY;
  }


  /**
   * Modifie la couleur de l'obstacle
   * 
   * @param color : la nouvelle couleur de l'obstacle
   */
  public void setObstacleColor(Color color) {
    this.color = color;
  }

  /**
   * Retourne la couleur de l'obstacle
   * 
   * @return la couleur de l'obstacle
   */
  public Color getObstacleColor() {
    return color;
  }
  
  public int getWidth(){
	  return this.bounds.getWidth();
  }
  
  public int getHeight(){
	  return this.bounds.getHeight();
  }
  
  public void setWidth(int width){
	  this.bounds.setWidth(width);
  }
  
  public void setHeight(int height){
	  this.bounds.setHeight(height);
  }
  
  public Bounds getBounds() {
	return bounds;
  }


}
