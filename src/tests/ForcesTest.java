package tests;

import model.Board;
import model.Coordinates;
import model.math.Forces;
import model.math.Vector;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Benjamin on 17/01/16.
 */
public class ForcesTest {

    @Test
    public void testGetSpeed() throws Exception {
        Vector v = new Vector(0, 0);
        Forces f = new Forces(v, false);
        assertTrue(f.getSpeed() == v);
    }

    @Test
    public void testCalculateNext() throws Exception {
        Vector v = new Vector(5, 10);
        Forces f = new Forces(v, false);
        Coordinates c = f.calculateNext(new Coordinates(100, 100));
        assertTrue(c.getX() == 100+5/Board.MAP_RATIO && c.getY() == 100+10/Board.MAP_RATIO);
    }
}