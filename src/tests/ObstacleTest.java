package tests;

import model.Coordinates;
import model.obstacle.Circle;
import model.obstacle.Obstacle;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Benjamin on 17/01/16.
 */
public class ObstacleTest {

    @Test
    public void testGetHealth() throws Exception {
        Obstacle o = new Circle(new Coordinates(0, 0));
        assertTrue(o.getHealth() == Obstacle.MAX_HEALTH);
    }

    @Test
    public void testReduceHealth() throws Exception {
        Obstacle o = new Circle(new Coordinates(0, 0));
        int hp = o.getHealth();
        hp -= 30;
        o.reduceHealth(30);
        assertTrue(o.getHealth() == hp);
    }
}