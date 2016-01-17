package tests;

import controller.BirdController;
import controller.BoardController;
import controller.ObstacleController;
import model.Board;
import model.Coordinates;
import model.math.Vector;
import model.obstacle.Circle;
import model.obstacle.Obstacle;
import model.obstacle.Rectangle;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Benjamin on 17/01/16.
 */
public class ObstacleControllerTest {

    @Test
    public void testCollide() throws Exception {
        Board board = new Board();
        BoardController boardController = new BoardController(board);
        ObstacleController obstacleController = new ObstacleController(boardController, board.getObstacles());
        Obstacle o = new Circle(new Coordinates(250, 250));
        obstacleController.collide(o, new Vector(20, 30));
        assertTrue(o.getForces().getSpeed().getX() == 30 && o.getForces().getSpeed().getY() == 45);
    }

    @Test
    public void testGenerateObstacles() throws Exception {
        Board board = new Board();
        BoardController boardController = new BoardController(board);
        ObstacleController obstacleController = new ObstacleController(boardController, board.getObstacles());
        obstacleController.generateObstacles();
        assertTrue(board.getObstacles().size() >=  Board.MIN_OBSTACLES_AMOUNT && board.getObstacles().size() <=  Board.MAX_OBSTACLES_AMOUNT);
        for(Obstacle o1 : board.getObstacles()){
            for(Obstacle o2 : board.getObstacles()){
                if(o1 == o2)
                    continue;
                if(o2 instanceof Circle)
                    assertFalse(o1.collideWithCircle(o2.getCoordinates(), Obstacle.RADIUS));
                else if(o2 instanceof Rectangle)
                    assertFalse(o1.collideWithRectangle(o2.getCoordinates(), Obstacle.RADIUS));
            }
        }
    }
}