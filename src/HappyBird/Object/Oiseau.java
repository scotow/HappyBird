package HappyBird.Object;

import java.awt.Color;

public class Oiseau extends Bounds{

	/**
	 * L'objet oiseau, element principal du jeu
	 */
    
    private double positionX;
    private double positionY;
    
    private Color OiseauColor = Constante.BIRD_BODY_COLOR;
    
    /**
     * Cree l'oiseau avec son positionnement
     * @param x : positionnement en x
     * @param y : positionnement en y
     */
    public Oiseau(double x, double y) {
    	super(x, y, Constante.BIRD_BODY_RADIUS, Constante.BIRD_BODY_RADIUS);
		this.positionX = x;
		this.positionY = y;
	}
    
    /**
     * Modifie la position de l'oiseau
     * @param positionX : nouvelle position x
     * @param positionY : nouvelle position y 
     */
    public void setPosition(double positionX, double positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
	}
    
    /**
     * Retourne la position de l'oiseau en coordonnees
     * @return les coordonnees de l'oiseau
     */
	public Coordonnee getPostionCoordonnee(){
		return new Coordonnee(positionX, positionY);
	}
    
	/**
	 * Retourne la position X de l'oiseau
	 * @return la position x de l'oiseau
	 */
    public double getPositionX() {
		return positionX;
	}
    
    /**
     * Retourne la position y de l'oiseau
     * @return la position y de l'oiseau
     */
    public double getPositionY() {
		return positionY;
	}
    
    @Override
    public int getWidth() {
    	return super.getWidth();
    }
    
    @Override
    public int getHeight() {
    	return super.getHeight();
    }
    
    /**
     * Modifie la couleur de l'oiseau
     * @param oiseauColor : la nouvelle couleur de l'oiseau
     */
    public void setOiseauColor(Color oiseauColor) {
		OiseauColor = oiseauColor;
	}
    
    /**
     * Retourne la couleur de l'oiseau
     * @return : la couleur de l'oiseau
     */
    public Color getOiseauColor() {
		return OiseauColor;
	}
        
        
        
}