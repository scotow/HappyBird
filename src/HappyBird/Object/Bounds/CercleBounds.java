package HappyBird.Object.Bounds;

import HappyBird.Object.Element.Obstacle;
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
	public boolean collision(Obstacle o1, Oiseau o2) {
		int d2 = (int) (Math.pow(o1.getPositionX() - o2.getX(), 2) + Math.pow(o1.getPositionY() - o2.getY(), 2));
		return !(d2 > Math.pow(o1.getBounds().getWidth() / 2 + o2.getWidth() / 2, 2));
	}

}
