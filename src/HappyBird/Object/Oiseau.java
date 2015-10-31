package HappyBird.Object;

import java.awt.Color;

public class Oiseau{

    private boolean touched = false;
    
    private double positionX;
    private double positionY;
    
    private Color OiseauColor = Constante.BIRD_BODY_COLOR;
    
    public Oiseau(double x, double y) {
		this.positionX = x;
		this.positionY = y;
	}
    
    public void setPosition(double positionX, double positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
	}
    
	public Coordonnee getPostionCoordonnee(){
		return new Coordonnee(positionX, positionY);
	}
    
    public double getPositionX() {
		return positionX;
	}
    
    public double getPositionY() {
		return positionY;
	}
    
    public void setOiseauColor(Color oiseauColor) {
		OiseauColor = oiseauColor;
	}
    
    public Color getOiseauColor() {
		return OiseauColor;
	}

    public boolean isTouched() {
        return touched;
    }

    public void setTouched(boolean touched) {
        this.touched = touched;
    }
        
        
        
}