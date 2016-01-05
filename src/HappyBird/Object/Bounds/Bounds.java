package HappyBird.Object.Bounds;

import HappyBird.Object.Element.Oiseau;

/**
 * Gere la Hitbox.
 * 
 * @author debaerdm
 *
 */
public abstract class Bounds {

	protected double x;
	protected double y;
	protected int width;
	protected int height;
	protected double poids;

	public abstract double getX();

	public abstract void setX(double x);

	public abstract double getY();

	public abstract void setY(double y);

	public abstract int getWidth();

	public abstract void setWidth(int width);

	public abstract int getHeight();

	public abstract void setHeight(int height);

	public abstract boolean collision(Oiseau o2);
	
	public abstract double getPoids ();
	
	public abstract void setPoids (double p);

}
