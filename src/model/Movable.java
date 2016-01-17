package model;

import model.math.Forces;
import model.math.Vector;

import java.util.Observable;

/**
 * Created by Benjamin on 13/01/16.
 */
public abstract class Movable extends Observable{

    protected Coordinates coordinates;
    protected Forces forces;
    private boolean flying;


    /**
     * Un objet mouvable abstrait.
     * @param coordinates Les coordonnées centrales.
     */

    public Movable(Coordinates coordinates){
        this.coordinates = coordinates;
    }


    /**
     * Déterminne si l'objet est trop lent et doit donc s'arreter.
     * @return L'objet est trop lent.
     */

    public boolean isTooSlow(){
        Vector speed = forces.getSpeed();
        if(Math.abs(speed.getX()) <= 5 && Math.abs(speed.getY()) <= 5)
            return true;
        return false;
    }

    public void setForces(Forces forces){
        this.forces = forces;
    }

    public Forces getForces() {
        return forces;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }


    /**
     * Modifie les coordonnées de l'objet et notifie les observers.
     * @param c Les coordonnées à changer.
     */

    public void setCoordinates(Coordinates c){
        coordinates.set(c);
        setChanged();
        notifyObservers();
    }

    public void setFlying(boolean flying){
        this.flying = flying;
    }

    public boolean isFlying() {
        return flying;
    }


}
