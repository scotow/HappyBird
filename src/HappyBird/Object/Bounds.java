package HappyBird.Object;

/**
 * Gère la Hitbox.
 * @author debaerdm
 *
 */
public class Bounds extends Coordonnee {
  
  private double x;
  private double y;
  private int width;
  private int height;

  public Bounds(double x, double y, int width, int height) {
    super(x, y);
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }
  
  public double getX() {
    return x;
  }
  
  public void setX(double x) {
    this.x = x;
  }
  
  public double getY() {
    return y;
  }
  
  public void setY(double y) {
    this.y = y;
  }
  
  public int getWidth() {
    return width;
  }
  
  public int getHeight() {
    return height;
  }

}
