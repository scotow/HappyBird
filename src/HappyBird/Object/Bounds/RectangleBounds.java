package HappyBird.Object.Bounds;

import HappyBird.Object.Element.Oiseau;

public class RectangleBounds extends Bounds {

	public static final String NAME = "Rectangle";

	public RectangleBounds(double x, double y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	@Override
	public double getX() {
		return x;
	}

	@Override
	public void setX(double x) {
		this.x = x;
	}

	@Override
	public double getY() {
		return y;
	}

	@Override
	public void setY(double y) {
		this.y = y;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public boolean collision(Oiseau o2) {
		return this.getX() < o2.getX() + o2.getHeight() / 2
				&& this.getX() + this.getWidth() > o2.getX()
				&& this.getY() < o2.getY() + o2.getHeight() / 2
				&& this.getHeight() + this.getY() > o2.getY();
		
	}
	
	@Override
	public double getPoids() {
		return poids;
	}

	@Override
	public void setPoids(double p) {
		this.poids = p;
	}

}
