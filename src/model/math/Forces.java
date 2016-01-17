package model.math;

import model.Board;
import model.Coordinates;

/**
 * Created by Benjamin on 09/01/16.
 */
public class Forces {

    private final Vector speed;
    private final Vector acceleration;
    private boolean gravity;


    /**
     * Les forces de déplacements et de gravité.
     * @param v0 Le vecteur vitesse initial.
     * @param gravity Subbit la gravité ou pas.
     */

    public Forces(Vector v0, boolean gravity) {
        this.speed = v0;
        this.gravity = gravity;
        acceleration = new Vector(0, gravity ? -10/Board.MAP_RATIO : 0);
    }

    public Vector getSpeed(){
        return speed;
    }


    /**
     * Calcule le prochain point en fonction de la vitesse et met à jour la vitesse en fonctions de la gravité et du frottement de l'air.
     * @param coordinates Les coordonnées actuelles.
     * @return Les coordonnées suivantes.
     */

    public Coordinates calculateNext(Coordinates coordinates){
        Coordinates c = coordinates.clone();
        c.add(speed.getX()/Board.MAP_RATIO, speed.getY()/Board.MAP_RATIO);
        speed.add(acceleration);
        if(!gravity)
            applyAirResistance();
        return c;
    }


    /**
     * Applique la résistance à l'air sur le vecteur vitesse.
     */

    private void applyAirResistance(){
        speed.multiply(0.99);
    }

}
