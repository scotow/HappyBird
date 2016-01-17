package view;

import controller.BirdController;
import controller.BoardController;
import model.Board;

import javax.swing.*;

/**
 * Created by Benjamin on 16/11/15.
 */
public class MainFrame extends JFrame {

    public MainFrame(Board board, BoardController boardController, BirdController birdController){
        setSize(Board.X_SIZE, Board.Y_SIZE);
        setTitle("Happy Bird");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(3);

        getContentPane().add(new GamePanel(board, boardController, birdController));
        setVisible(true);
        setSize(getWidth(), getHeight()+getInsets().top);
    }

}
