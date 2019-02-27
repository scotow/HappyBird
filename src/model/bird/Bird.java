package model.bird;

import model.Coordinates;
import model.Movable;
import model.math.Path;

/**
 * Created by Benjamin on 09/01/16.
 */
public class Bird extends Movable {

    public static final int BODY_RADIUS = 20;
    public static final int EYES_RADIUS = 3;

    private Beak beak;
    private Path path;
    private final Power power;

    private boolean powerUsed;


    /**
     * Créer un oiseau avec un bec et un chemin de positions vide.
     * @param coordinates La position initiale.
     * @param power Le pouvoir (touche espace) qu'il possède.
     */

    public Bird(Coordinates coordinates, Power power){
        super(coordinates);
        beak = new Beak(new Coordinates(coordinates.getX()+Beak.FROM_BIRD_CENTER, coordinates.getY()));
        path = new Path();
        this.power = power;
    }

    public Power getPower(){
        return power;
    }

    public Beak getBeak() {
        return beak;
    }

    public Path getPath(){
        return path;
    }


    /**
     * Demande si le pouvoir a déja était utilisé.
     * @return La disponibilité du pouvoir.
     */

    public boolean hasUsePower() {
        return false;
    }


    /**
     * Change l'état du pouvoir à déja utilisé.
     */

    public void powerActivated(){
        powerUsed = true;
    }
}
