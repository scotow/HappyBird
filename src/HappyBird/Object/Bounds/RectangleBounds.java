package HappyBird.Object.Bounds;

import HappyBird.Object.Element.Obstacle;
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
	public boolean collision(Obstacle o1, Oiseau o2) {
		int cercleDistanceX = (int) Math.abs(o2.getX() - o1.getPositionX() - (o1.getWidth() / 2));
		int cercleDistanceY = (int) Math.abs(o2.getY() - o1.getPositionY() - (o1.getHeight() / 2));

		if (cercleDistanceX > (o1.getWidth() / 2 + o2.getWidth() / 2)) {
			return false;
		}
		
		if (cercleDistanceY > (o1.getHeight() / 2 + o2.getWidth() / 2)) {
			return false;
		}

		if (cercleDistanceX <= (o1.getWidth() / 2)) {
			return true;
		}
		if (cercleDistanceY <= (o1.getHeight() / 2)) {
			return true;
		}

		int cornerDistance = (int) (Math.pow(cercleDistanceX - o1.getWidth() / 2, 2)
				+ Math.pow(cercleDistanceY - o1.getHeight() / 2, 2));

		return (cornerDistance <= (int) Math.pow(o2.getWidth(), 2));
	}

}
