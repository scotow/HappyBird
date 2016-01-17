package model.math;

import model.Board;
import model.Coordinates;

/**
 * Created by Benjamin on 09/01/16.
 */
public class Forces {

    public final static int POINTS_RADIUS = 2;

    private final Vector speed;
    private final Vector acceleration;
    private boolean gravity;

    public Forces(Vector v0, boolean gravity) {
        this.speed = v0;
        this.gravity = gravity;
        acceleration = new Vector(0, gravity ? -10/Board.MAP_RATIO : 0);
    }

    public Vector getSpeed(){
        return speed;
    }

    public Coordinates calculateNext(Coordinates coordinates){
        Coordinates c = coordinates.clone();
        c.add(speed.getX()/Board.MAP_RATIO, speed.getY()/Board.MAP_RATIO);
        speed.add(acceleration);
        if(!gravity)
            applyAirResistance();
        return c;
    }

    private void applyAirResistance(){
        speed.multiply(0.99);
    }

}
