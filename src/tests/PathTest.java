package tests;

import model.Board;
import model.Coordinates;
import model.math.Forces;
import model.math.Path;
import model.math.Vector;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Benjamin on 17/01/16.
 */
public class PathTest {

    @Test
    public void testGenerateFullPath() throws Exception {
        Path p = new Path();
        p.generateFullPath(new Coordinates(100, 100), new Forces(new Vector(0, 10), true));
        for(Coordinates c : p.getPoints())
            assertTrue(c.getX() <= Board.X_SIZE && c.getX() >= 0 && c.getY() >= Board.GROUND);
    }

    @Test
    public void testAddPoints() throws Exception {
        Coordinates c = new Coordinates(5, 34);
        Path p = new Path();
        p.addPoints(c);
        assertTrue(c.getX() == p.getPoints().get(p.getPoints().size()-1).getX() && c.getY() == p.getPoints().get(p.getPoints().size()-1).getY());
    }

    @Test
    public void testGetPoints() throws Exception {
        Path p = new Path();
        assertTrue(p.getPoints().getClass() == ArrayList.class);
    }

    @Test
    public void testResetPoints() throws Exception {
        Coordinates c = new Coordinates(5, 34);
        Path p = new Path();
        p.addPoints(c);
        p.resetPoints();
        assertTrue(p.getPoints().isEmpty());
    }
}