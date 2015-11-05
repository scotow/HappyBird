package HappyBird.Object;


/**
 * Les differentes constantes utilisees dans le projet
 * 
 */

import java.awt.Color;

public abstract class Constante {

  public static final Color BIRD_BODY_COLOR = Color.RED;
  public static final Color BIRD_BREAK_COLOR = Color.BLACK;

  public static final int BIRD_BODY_RADIUS = 25;
  
  public static final double CONSTANTE_GRAVITATIONNELLE = 9.81;
  public static final double PI = Math.PI;
  
  public static final double VITESSE_X = 2;
  public static final double VITESSE_GRAVITAIONNELLE = 0.10;
  public static final double VITESSE_LANCER = -4;
  
  public static final int OBSTACLE_RADIUS = 15;
  public static final int OBSTACLES_LIST_CAPACITY = 10;
  public static final int POINT_LIST_CAPACITY = 4;

  public static final Color OBSTACLE_NOT_TOUCHED_COLOR = Color.ORANGE;
  public static final Color OBSTACLE_TOUCHED_COLOR = Color.MAGENTA;
  
  public static final int X_FRAME = 900;
  public static final int Y_FRAME = 470;
  
  public static final Color POINT_BEZIER = Color.BLUE;
}
