package HappyBird;

public class Bounds extends Coordonnee {

	private double x;
	private double y;
	private int width;
	private int height;
	private int radius;

	public Bounds(double x, double y, int longueur, int largeur) {
		super(x, y);
		this.x = x;
		this.y = y;
		this.width = largeur;
		this.height = longueur;
	}

	public Bounds(double x, double y, int radius) {
		super(x, y);
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	public boolean equalsSquare(Oiseau oiseau) {
		return (int) this.x < (int) oiseau.getPosition().getX() + oiseau.getLongueur() / 2
				&& (int) this.x + this.width > (int) oiseau.getPosition().getX()
				&& (int) this.y < (int) oiseau.getPosition().getY() + oiseau.getLargeur() / 2
				&& this.height + (int) this.y > (int) oiseau.getPosition().getY();
	}

	public boolean equalsCercle(Oiseau oiseau) {
		double d2 = (Math.pow(this.x - oiseau.getPosition().getX(), 2)
				+ Math.pow((this.y - oiseau.getPosition().getY()), 2));
		return (d2 > Math.pow(this.radius + oiseau.getRadius() - 5, 2));
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public int getLongueur() {
		return width;
	}

	public int getLargeur() {
		return height;
	}

	public int getRadius() {
		return radius;
	}

}
