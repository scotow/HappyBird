package model.obstacle;

import model.Coordinates;
import model.bird.Bird;

/**
 * Created by Benjamin on 09/01/16.
 */
public class Circle extends Obstacle {

    public Circle(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public boolean collideWithCircle(Coordinates c, int radius) {
        return  Math.abs(c.getX()- coordinates.getX()) <= Obstacle.RADIUS+radius &&
                Math.abs(c.getY()- coordinates.getY()) <= Obstacle.RADIUS+radius;
    }

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
