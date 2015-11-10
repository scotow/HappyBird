package HappyBird.Object.Config;


/**
 * Les differentes constantes utilisees dans le projet
 * 
 */

import java.awt.Color;

import HappyBird.Object.Bounds.CercleBounds;
import HappyBird.Object.Bounds.RectangleBounds;

public abstract class Constante {

  public static final Color BIRD_BODY_COLOR = Color.RED;
  public static final Color BIRD_BREAK_COLOR = Color.BLACK;

  public static final Color BEC_COLOR = Color.black;
  public static final Color BEC_BREAK_COLOR = Color.RED;

  public static final int BIRD_BODY_RADIUS = 35;

  public static final double CONSTANTE_GRAVITATIONNELLE = 9.81;

  public static final double VITESSE_X = 2;
  public static final double VITESSE_GRAVITAIONNELLE = 0.10;
  public static final double VITESSE_LANCER = -4;

  public static final int OBSTACLE_RADIUS = 20;
  public static final int OBSTACLES_LIST_CAPACITY = 5;
  public static final int POINT_LIST_CAPACITY = 4;

  public static final Color OBSTACLE_NOT_TOUCHED_COLOR = Color.BLUE;
  public static final Color OBSTACLE_TOUCHED_COLOR = Color.MAGENTA;

  public static final int X_FRAME = 900;
  public static final int Y_FRAME = 470;

  public static final Color POINT_BEZIER = Color.BLUE;
  
  public static final String[] FORME = new String[]{RectangleBounds.NAME,CercleBounds.NAME};
}
