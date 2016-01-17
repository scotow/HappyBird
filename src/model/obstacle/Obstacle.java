package model.obstacle;

import model.Coordinates;
import model.Movable;

/**
 * Created by Benjamin on 09/01/16.
 */
public abstract class Obstacle extends Movable {

    public final static int RADIUS = 15;
    public final static int MAX_HEALTH = 3000;

    private int health = MAX_HEALTH;
    private boolean touched;

    public Obstacle(Coordinates coordinates) {
        super(coordinates);
    }

    public void setTouched(boolean touched){
        this.touched = touched;
    }

    public boolean isTouched(){
        return touched;
    }

    public abstract boolean collideWithCircle(Coordinates c, int radius);

    public int getHealth(){
        return health;
    }

    public boolean reduceHealth(int amount){
        health -= amount;
        if(health <= 0)
            return true;
        return false;
    }

    public abstract boolean collideWithRectangle(Coordinates c, int radius);

}
