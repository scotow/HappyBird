package tests;

import model.Coordinates;

import static org.junit.Assert.*;

/**
 * Created by Benjamin on 17/01/16.
 */
public class CoordinatesTest {

    @org.junit.Test
    public void testGetX() throws Exception {
        Coordinates c = new Coordinates(2, 3);
        assert c.getX() == 2;
    }

    @org.junit.Test
    public void testGetY() throws Exception {
        Coordinates c = new Coordinates(2, 3);
        assert c.getY() == 3;
    }

    @org.junit.Test
    public void testSetX() throws Exception {
        Coordinates c = new Coordinates(2, 3);
        c.setX(4);
        assert c.getX() == 4;
    }

    @org.junit.Test
    public void testSetY() throws Exception {
        Coordinates c = new Coordinates(2, 3);
        c.setY(4);
        assert c.getY() == 4;
    }

    @org.junit.Test
    public void testSet() throws Exception {
        Coordinates c = new Coordinates(2, 3);
        c.set(5, 6);
        assert c.getX() == 5;
        assert c.getY() == 6;
    }

    @org.junit.Test
    public void testSet1() throws Exception {
        Coordinates c1 = new Coordinates(2, 3);
        Coordinates c2 = new Coordinates(8, 3);
        c1.set(c2);
        assert c1.getX() == 8;
        assert c1.getY() == 3;
    }

    @org.junit.Test
    public void testAdd() throws Exception {
        Coordinates c = new Coordinates(2, 3);
        c.add(3, 0);
        assert c.getX() == 5;
        assert c.getY() == 3;
    }

    @org.junit.Test
    public void testClone() throws Exception {
        Coordinates c1 = new Coordinates(3, 5);
        Coordinates c2 = c1.clone();
        assert c2.getX() == c1.getX() && c2.getY() == c1.getY();
    }
}