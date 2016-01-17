package controller;

import model.Board;
import model.Coordinates;
import model.bird.Bird;
import model.bird.Power;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Benjamin on 09/01/16.
 */
public class BoardController {

    private final Board board;

    public BoardController(Board board) {
        this.board = board;
        generateBirds();
    }

    private void generateBirds(){
        ArrayList<Bird> birds = board.getBirds();
        Random rand = new Random();
        for(int i = 0 ; i < Board.BIRDS_AMOUNT ; i++){
            birds.add(new Bird(new Coordinates(Bird.BODY_RADIUS*8, Bird.BODY_RADIUS*10), rand.nextBoolean() ? Power.NONE : Power.SPRINT));
        }
        board.setActualBird(birds.remove(0));
    }

    public void nextBird(){
        if(board.getBirds().size() == 0) {
            JOptionPane.showMessageDialog(null, "Partie terminé.\nScore : " + board.getScore() + ".\n\nMerci d'avoir joué.", "Fin de partie", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        Bird bird = board.getBirds().remove(0);
        board.setActualBird(bird);
    }

    public Bird getActualBird(){
        return board.getActualBird();
    }

    public void addPoints(int points){
        board.addPoints(points);
    }

}
