package HappyBird.Object.Bounds;

import HappyBird.Exception.BoundsException;

public abstract class BoundsFactory {

	public static Bounds boundsFactory(String bounds, double x, double y, int width, int height)
			throws BoundsException {
		switch (bounds.toLowerCase()) {
		case "rectangle":
			return new RectangleBounds(x, y, width, height);
		case "cercle":
			return new CercleBounds(x, y, width, height);
		default:
			throw new BoundsException(bounds);
		}
	}
}
