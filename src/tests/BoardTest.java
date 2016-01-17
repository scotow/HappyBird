package tests;

import model.Board;
import model.Coordinates;
import model.bird.Bird;
import model.bird.Power;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Benjamin on 17/01/16.
 */
public class BoardTest {

    @Test
    public void testSetActualBird() throws Exception {
        Board board = new Board();
        Bird bird = new Bird(new Coordinates(0, 0), Power.NONE);
        board.setActualBird(bird);
        assertTrue(board.getActualBird() == bird);
    }

    @Test
    public void testGetBirds() throws Exception {
        assertTrue(new Board().getBirds().getClass() == ArrayList.class);
    }

    @Test
    public void testGetActualBird() throws Exception {
        Board board = new Board();
        Bird bird = new Bird(new Coordinates(0, 0), Power.NONE);
        board.setActualBird(bird);
        assertTrue(board.getActualBird() == bird);
    }

    @Test
    public void testGetObstacles() throws Exception {
        assertTrue(new Board().getObstacles().getClass() == ArrayList.class);
    }

    @Test
    public void testGetScore() throws Exception {
        assertTrue(new Board().getScore() >= 0);
    }

    @Test
    public void testAddPoints() throws Exception {
        Board b = new Board();
        int pts = b.getScore();
        int expected = pts + 153;
        b.addPoints(153);
        assertTrue(expected == b.getScore());

    }
}