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

    /**
     * Classe abstraite d'un obstacle.
     * @param coordinates Le centre de l'obstacle.
     */

    public Obstacle(Coordinates coordinates) {
        super(coordinates);
    }

    public abstract boolean collideWithCircle(Coordinates c, int radius);

    public abstract boolean collideWithRectangle(Coordinates c, int radius);


    /**
     * Retourne les points de vie restant de l'obstacle.
     * @return Les points de vie restant de l'obstacle.
     */

    public int getHealth(){
        return health;
    }


    /**
     * Reduit la vie d'un obstacle.
     * @param amount Le montant de points de vie a rettirer.
     * @return Si l'objet est mort.
     */

    public boolean reduceHealth(int amount){
        health -= amount;
        if(health <= 0)
            return true;
        return false;
    }


}
