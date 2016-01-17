package tests;

import controller.BirdController;
import controller.BoardController;
import model.Board;
import model.bird.Bird;
import model.math.Vector;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Benjamin on 17/01/16.
 */
public class BoardControllerTest {

    @Test
    public void testNextBird() throws Exception {
        Board board = new Board();
        BoardController boardController = new BoardController(board);
        Bird b1 = board.getActualBird();
        boardController.nextBird();
        assertTrue(b1 != board.getActualBird());
    }

    @Test
    public void testGetActualBird() throws Exception {
        Board board = new Board();
        BoardController boardController = new BoardController(board);
        assertTrue(boardController.getActualBird().getClass() == Bird.class);
    }

    @Test
    public void testAddPoints() throws Exception {
        Board board = new Board();
        BoardController boardController = new BoardController(board);
        int pts = board.getScore();
        pts += 2000;
        boardController.addPoints(2000);
        assertTrue(board.getScore() == pts);
    }
}