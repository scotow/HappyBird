package model.obstacle;

import model.Coordinates;
import model.bird.Bird;

/**
 * Created by Benjamin on 09/01/16.
 */
public class Rectangle extends Obstacle {

    public Rectangle(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public boolean collideWithCircle(Coordinates c, int radius) {
        int xDiff = Math.abs(c.getX() - coordinates.getX());
        int yDiff = Math.abs(c.getY() - coordinates.getY());
        if (xDiff > (Obstacle.RADIUS + radius)) { return false; }
        if (yDiff > (Obstacle.RADIUS + radius)) { return false; }
        if (xDiff <= (Obstacle.RADIUS)) { return true; }
        if (yDiff <= (Obstacle.RADIUS)) { return true; }
        return Math.pow(xDiff - Obstacle.RADIUS, 2) + Math.pow(yDiff - Obstacle.RADIUS, 2) <= (Math.pow(radius,2));
    }

    @Override
    public boolean collideWithRectangle(Coordinates c, int radius) {
        if (coordinates.getX() > c.getX()+radius || c.getX() > coordinates.getX()+RADIUS)
            return false;
        if (coordinates.getY() < c.getY()+radius || c.getY() < coordinates.getY()+RADIUS)
            return false;
        return true;
    }
}
