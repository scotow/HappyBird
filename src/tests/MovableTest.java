package tests;

import model.Coordinates;
import model.bird.Bird;
import model.bird.Power;
import model.math.Forces;
import model.math.Vector;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Benjamin on 17/01/16.
 */
public class MovableTest {

    @Test
    public void testIsTooSlow() throws Exception {
        Bird b = new Bird(new Coordinates(0, 0), Power.NONE);
        b.setForces(new Forces(new Vector(3, 3), true));
        assertTrue(b.isTooSlow());
        b.setForces(new Forces(new Vector(30, 30), true));
        assertFalse(b.isTooSlow());
    }

    @Test
    public void testSetForces() throws Exception {
        Bird b = new Bird(new Coordinates(0, 0), Power.NONE);
        Forces f = new Forces(new Vector(3, 3), true);
        b.setForces(f);
        assertTrue(b.getForces() == f);
    }

    @Test
    public void testGetForces() throws Exception {
        Bird b = new Bird(new Coordinates(0, 0), Power.NONE);
        Forces f = new Forces(new Vector(3, 3), true);
        b.setForces(f);
        assertTrue(b.getForces() == f);
    }

    @Test
    public void testGetCoordinates() throws Exception {
        Coordinates c = new Coordinates(0, 0);
        Bird b = new Bird(c, Power.NONE);
        assertTrue(c == b.getCoordinates());
    }

    @Test
    public void testSetCoordinates() throws Exception {
        Coordinates c = new Coordinates(0, 0);
        Bird b = new Bird(c, Power.NONE);
        assertTrue(c == b.getCoordinates());
    }

    @Test
    public void testSetFlying() throws Exception {
        Bird b = new Bird(new Coordinates(0, 0), Power.NONE);
        b.setFlying(false);
        assertFalse(b.isFlying());
        b.setFlying(true);
        assertTrue(b.isFlying());
    }

    @Test
    public void testIsFlying() throws Exception {
        Bird b = new Bird(new Coordinates(0, 0), Power.NONE);
        assertFalse(b.isFlying());
        b.setFlying(true);
        assertTrue(b.isFlying());
    }
}