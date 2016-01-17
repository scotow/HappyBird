package tests;

import model.math.Vector;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Benjamin on 17/01/16.
 */
public class VectorTest {

    @Test
    public void testGetRightAngle() throws Exception {
        Vector v1 = new Vector(2, 5);
        Vector v2 = v1.getRightAngle();
        assertTrue(v2.getX() == v1.getY() && v2.getY() == v1.getX());
    }

    @Test
    public void testRedirectUp() throws Exception {
        Vector v = new Vector(2, 5);
        v.redirectUp();
        assertTrue(v.getY() >= 0);
    }

    @Test
    public void testRedirectDown() throws Exception {
        Vector v = new Vector(2, 5);
        v.redirectDown();
        assertTrue(v.getY() <= 0);
    }

    @Test
    public void testReverse() throws Exception {
        Vector v1 = new Vector(2, 5);
        Vector v2 = new Vector(-7, 9);
        v1.reverse();
        v2.reverse();
        assertTrue(v1.getX() == -2 && v2.getX() == 7);
    }

    @Test
    public void testAdd() throws Exception {
        Vector v1 = new Vector(2, 5);
        Vector v2 = new Vector(-7, 9);
        v1.add(v2);
        assertTrue(v1.getX() == -5 && v1.getY() == 14);
    }

    @Test
    public void testSet() throws Exception {
        Vector v = new Vector(2, 5);
        v.set(10, -15);
        assertTrue(v.getX() == 10 && v.getY() == -15);
    }

    @Test
    public void testMultiply() throws Exception {
        Vector v = new Vector(2, 5);
        v.multiply(5);
        assertTrue(v.getX() == 10 && v.getY() == 25);
    }

    @Test
    public void testGetX() throws Exception {
        Vector v = new Vector(2, 5);
        assertTrue(v.getX() == 2);
    }

    @Test
    public void testGetY() throws Exception {
        Vector v = new Vector(2, 5);
        assertTrue(v.getY() == 5);
    }

    @Test
    public void testGetNorme() throws Exception {
        Vector v = new Vector(2, 5);
        assertTrue(v.getNorme() == Math.sqrt(29));
    }

    @Test
    public void testClone() throws Exception {
        Vector v = new Vector(2, 5);
        Vector v1 = v.clone();
        assertTrue(v1.getX() == 2 && v1.getY() == 5);
    }
}