package tests;

import model.Coordinates;
import model.bird.Bird;
import model.bird.Power;
import model.math.Path;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Benjamin on 17/01/16.
 */
public class BirdTest {

    @Test
    public void testGetPower() throws Exception {
        Power p = Power.SPRINT;
        Bird b = new Bird(new Coordinates(0, 0), p);
        assertTrue(b.getPower() == p);
    }

    @Test
    public void testGetPath() throws Exception {
        Bird b = new Bird(new Coordinates(0, 0), Power.NONE);
        assertTrue(b.getPath().getPoints().isEmpty() && b.getPath().getClass() == Path.class);
    }

    @Test
    public void testHasUsePower() throws Exception {
        Bird b = new Bird(new Coordinates(0, 0), Power.SPRINT);
        assertFalse(b.hasUsePower());
        b.powerActivated();
        assertTrue(b.hasUsePower());
    }

    @Test
    public void testPowerActivated() throws Exception {
        Bird b = new Bird(new Coordinates(0, 0), Power.SPRINT);
        assertFalse(b.hasUsePower());
        b.powerActivated();
        assertTrue(b.hasUsePower());
    }
}