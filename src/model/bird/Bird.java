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

    public boolean hasUsePower() {
        return powerUsed;
    }

    public void powerActivated(){
        powerUsed = true;
    }
}
