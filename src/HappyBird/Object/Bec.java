package HappyBird.Object;

import java.awt.Color;
import java.awt.Polygon;

/**
 * Created by Benjamin on 04/11/15.
 */
public class Bec{

    private Coordonnee coordonnee;
    private Color color = Color.BLACK;
    private final Oiseau oiseau;

    public Bec(Coordonnee coordonnee, Oiseau oiseau){
        this.coordonnee = coordonnee;
        this.oiseau = oiseau;
    }

    public void update(){

    }
    
    /*public Polygon getPolygon(){
      return new Polygon(int[]{(int)(oiseau.getPositionX()+(Math.sqrt(3)/2)), (int)(-oiseau.getPositionX()+(Math.sqrt(3)/2)), (int)coordonnee.getX()},
          int[]{(int)(oiseau.getPositionY()+(Math.sqrt(3)/2)), (int)(-oiseau.getPositionX()+(Math.sqrt(3)/2)), (int)coordonnee.getY()}, 3);
    }*/

    public Coordonnee getCoordonnee(){
        return coordonnee;
    }

    public void setPosition(Coordonnee coordonnee) {
        this.coordonnee = coordonnee;
    }
    
    public void setColor(Color color) {
      this.color = color;
    }
    
    public Color getColor() {
      return color;
    }
}
