package HappyBird;



public class TrucBleu {

	/**
	 * 
	 * @author garbey
	 * Il s'agit des trucs bleus qui apparaissent sur l'ecran
	 * 
	 */
	private int x, y;

	
	/**
	 * Cree un TrucBleu
	 * @param x : la position de x
	 * @param y : la position de y
	 * 
	 */
	public TrucBleu (int x, int y) {
		this.x = x;
		this.y = y;
	}

	
	/*-------------------Les getter-----------------------------*/
	
	/**
	 * Retourne la position x
	 * @return x : la position x du TrucBleu
	 */
	public int getX() {
		return this.x;
	}
	
	/**
	 * Retourne la position y
	 * @return y : la position y du TrucBleu
	 */
	public int getY() {
		return this.y;
	}
}
