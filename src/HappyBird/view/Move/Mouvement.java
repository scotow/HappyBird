package HappyBird.view.Move;

/**
 * Cette classe concerne tous les mouvements (issus du Livrable 2), elle comprend les mouvements et orientation de l'oiseau
 * ainsi que ceux des obstacles.		- 
 * @author housett
 *
 */
public class Mouvement {
	
	// Origines en x et en y de l'oiseau (point de départ).
	private int x0Oiseau;
	private int y0Oiseau;
	// Vitesses initiales de l'oiseau en x et en y.
	private double VxOiseau;
	private double VyOiseau;
	// Constante de gravitation Happyverselle (et non universelle car la constante n'est pas celle que l'on connaît).
	private double g = 9.81;
	
	/**
	 * Méthode permettant de retrouver la position en x de l'oiseau sur la trajectoire de la courbe en x.
	 * (On suppose que l'oiseau ne rencontre pas de résistance (ex: Air), donc sa vitesse est constante)
	 * @param t l'instant t
	 * @return la position sur l'axe x de l'oiseau.
	 */
	public int posXOiseau(int t){
		return (int) (VxOiseau*t+this.x0Oiseau);
	}
	
	/**
	 * Méthode permettant de retrouver la position en y de l'oiseau sur la trajectoire de la courbe en x.
	 * (On suppose que l'oiseau ne rencontre pas de résistance (ex: Air), donc sa vitesse est constante)
	 * @param t l'instant t.
	 * @return la position sur l'axe y de l'oiseau
	 */
	public int posYOiseau(int t){
		return (int) ( (-(t*t*g)/2) + VyOiseau*t + y0Oiseau );
	}
	
	/** 
	 * Méthode permettant de retrouver l'angle X du bec de l'oiseau.
	 * @param t l(instant t.
	 * @return l'angle selon l'axe x du bec de l'oiseau.
	 */
	public int angleXOiseau(int t){
		return (int) (VxOiseau);
	}
	
	/**
	 * Méthode permettant de retrouver l'angle Y du bec de l'oiseau.
	 * @param t l'instant t.
	 * @return l'angle selon l'axe y du bec de l'oiseau.
	 */
	public int angleYOiseau(int t){
		return (int) ( -g*t + VyOiseau );
	}
}
