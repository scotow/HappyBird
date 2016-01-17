package model.obstacle;

import model.Coordinates;
import model.bird.Bird;

/**
 * Created by Benjamin on 09/01/16.
 */
public class Circle extends Obstacle {


    /**
     * Un obstacle de forme ronde.
     * @param coordinates Le centre du cercle.
     */

    public Circle(Coordinates coordinates) {
        super(coordinates);
    }


    /**
     * Renvoie si il y a eu collision avec ce rond et une forme de forme ronde.
     * @param c Les coordonnées de l'objet mouvant.
     * @param radius Le rayon de l'objet mouvant.
     * @return Si il y a eu collision.
     */

    @Override
    public boolean collideWithCircle(Coordinates c, int radius) {
        return  Math.abs(c.getX()- coordinates.getX()) <= Obstacle.RADIUS+radius &&
                Math.abs(c.getY()- coordinates.getY()) <= Obstacle.RADIUS+radius;
    }


    /**
     * Renvoie si il y a eu collision avec ce rond et une forme de forme rectangle..
     * @param c Les coordonnées de l'objet mouvant.
     * @param radius Le rayon de l'objet mouvant.
     * @return Si il y a eu collision.
     */

    @Override
    public boolean collideWithRectangle(Coordinates c, int radius) {
        int xDiff = Math.abs(c.getX() - coordinates.getX());
        int yDiff = Math.abs(c.getY() - coordinates.getY());
        if (xDiff > (Obstacle.RADIUS + radius)) { return false; }
        if (yDiff > (Obstacle.RADIUS + radius)) { return false; }
        if (xDiff <= (Obstacle.RADIUS)) { return true; }
        if (yDiff <= (Obstacle.RADIUS)) { return true; }
        return Math.pow(xDiff - Obstacle.RADIUS, 2) + Math.pow(yDiff - Obstacle.RADIUS, 2) <= (Math.pow(radius,2));
    }


}
