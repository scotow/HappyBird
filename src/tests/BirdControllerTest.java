package tests;

import controller.BirdController;
import controller.BoardController;
import controller.ObstacleController;
import model.Board;
import model.Coordinates;
import model.bird.Bird;
import model.bird.Power;
import model.math.Vector;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Benjamin on 17/01/16.
 */
public class BirdControllerTest {

    @Test
    public void testDrag() throws Exception {
        Board board = new Board();
        BoardController boardController = new BoardController(board);
        BirdController birdController = new BirdController(board.getActualBird(), board.getObstacles(), boardController, null);
        birdController.drag(new Coordinates(30, 24));
        assertTrue(board.getActualBird().getCoordinates().getX() == 30 && board.getActualBird().getCoordinates().getY() == 24);
    }

    @Test
    public void testFly() throws Exception {
        Board board = new Board();
        BoardController boardController = new BoardController(board);
        BirdController birdController = new BirdController(board.getActualBird(), board.getObstacles(), boardController, null);
        birdController.fly(new Vector(10, 0));
        assertTrue(board.getActualBird().isFlying());
    }

    @Test
    public void testPreviewFlight() throws Exception {
        Board board = new Board();
        BoardController boardController = new BoardController(board);
        BirdController birdController = new BirdController(board.getActualBird(), board.getObstacles(), boardController, null);
        birdController.previewFlight(new Vector(0, 0), board.getActualBird().getCoordinates());
        assertFalse(board.getActualBird().getPath().getPoints().isEmpty());
    }

    @Test
    public void testActivatePower() throws Exception {
        Board board = new Board();
        BoardController boardController = new BoardController(board);
        BirdController birdController = new BirdController(board.getActualBird(), board.getObstacles(), boardController, null);
        assertFalse(board.getActualBird().hasUsePower());
        birdController.fly(new Vector(0, 0));
        birdController.activatePower();
        assertTrue(board.getActualBird().hasUsePower());
    }
}