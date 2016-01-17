package model.bird;

import model.Coordinates;
import model.math.Vector;

/**
 * Created by Benjamin on 12/01/16.
 */
public class Beak {

    public static final int WIDTH = 8;
    public static final int LENGTH = 12;
    public static final int FROM_BIRD_CENTER = Bird.BODY_RADIUS-3;

    private Coordinates coordinates;
    private Vector direction;


    /**
     * Creer un bec avec un vecteur de direction horizontal.
     * @param coordinates Les coordonnées initial du bec.
     */

    public Beak(Coordinates coordinates){
        this.coordinates = coordinates;
        direction = new Vector(LENGTH, 0);
    }

    public Coordinates getCoordinates(){
        return coordinates;
    }

    public Vector getDirection(){
        return direction;
    }

    public void setCoordinates(Coordinates c){
        coordinates.set(c);
    }

}
