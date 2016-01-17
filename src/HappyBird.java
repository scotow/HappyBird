import controller.BirdController;
import controller.BoardController;
import controller.ObstacleController;
import model.Board;
import view.MainFrame;

/**
 * Created by Benjamin on 09/01/16.
 */
public class HappyBird {


    /**
     * Lance l'inialisation des controlleurs et des vues.
     */

    public HappyBird(){
        Board board = new Board();
        BoardController boardController = new BoardController(board);
        ObstacleController obstacleController = new ObstacleController(boardController, board.getObstacles());
        BirdController birdController = new BirdController(board.getActualBird(), board.getObstacles(), boardController, obstacleController);
        new MainFrame(board, boardController, birdController);
    }


    /**
     * Le commencemant.
     * @param args
     */

    public static void main(String[] args) {
        new HappyBird();
    }

}
