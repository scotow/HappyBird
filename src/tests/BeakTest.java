package tests;

import model.Coordinates;
import model.bird.Beak;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Benjamin on 17/01/16.
 */
public class BeakTest {

    @Test
    public void testGetCoordinates() throws Exception {
        Beak b = new Beak(new Coordinates(0, 0));
        assertTrue(b.getCoordinates().getX() == 0 && b.getCoordinates().getY() == 0);
    }

    @Test
    public void testGetDirection() throws Exception {
        Beak b = new Beak(new Coordinates(0, 0));
        assertTrue(b.getDirection().getX() >= 0 && b.getDirection().getY() == 0);
    }

    @Test
    public void testSetCoordinates() throws Exception {
        Beak b = new Beak(new Coordinates(0, 0));
        b.setCoordinates(new Coordinates(45, 29));
        assertTrue(b.getCoordinates().getX() == 45 && b.getCoordinates().getY() == 29);
    }
}