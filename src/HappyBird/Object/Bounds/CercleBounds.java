package HappyBird.Object.Bounds;

import HappyBird.Object.Element.Oiseau;

public class CercleBounds extends Bounds {

	public static final String NAME = "Cercle";

	public CercleBounds(double x, double y, int width, int height) {
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
		return this.width;
	}

	@Override
	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public int getHeight() {
		return this.height;
	}

	@Override
	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public boolean collision(Oiseau o2) {
		double d2 = (Math.pow(this.getX() - o2.getX(), 2) + Math.pow(this.getY() - o2.getY(), 2));
		return !(d2 > Math.pow(this.getWidth() / 2 + o2.getWidth() / 2, 2));
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
