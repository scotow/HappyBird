package view;

import controller.BirdController;
import controller.BoardController;
import model.Coordinates;
import model.bird.Beak;
import model.bird.Bird;
import model.Board;
import model.bird.Power;
import model.math.Forces;
import model.math.Vector;
import model.obstacle.*;
import model.obstacle.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Benjamin on 09/01/16.
 */
public class GamePanel extends JPanel implements MouseMotionListener, MouseListener, KeyListener, Observer {

    private final int BIRD_REMAINING_RADIUS = 10;
    private final Color BIRD_COLOR_NONE = Color.RED;
    private final Color BIRD_COLOR_SPRINT = Color.MAGENTA;
    private final Color BEAK_COLOR = Color.BLACK;
    private final Color EYES_COLOR = Color.WHITE;
    private final Color ELASTIC_COLOR = Color.ORANGE;
    private final Color SHADOW_COLOR = new Color(0, 0 , 0, 128);
    private final Color CURVE_COLOR = Color.GRAY;
    private final Color SCORE_COLOR = Color.WHITE;

    private Image background;

    private final Board board;
    private final BoardController boardController;
    private final BirdController birdController;

    private Coordinates drag_start;
    private Vector elastic;

    public GamePanel(Board board,BoardController boardController, BirdController birdController){
        this.board = board;
        this.boardController = boardController;
        this.birdController = birdController;
        board.getActualBird().addObserver(this);
        for(Bird b : board.getBirds())
            b.addObserver(this);
        for(Obstacle o : board.getObstacles())
            o.addObserver(this);
        setFocusable(true);
        requestFocus();
        addMouseMotionListener(this);
        addMouseListener(this);
        addKeyListener(this);
        background = new ImageIcon(getClass().getResource("images/background.png")).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
        repaintRemainingBird(g);
        repaintElastic(g);
        repaintPath(g);
        repaintObstacle(g);
        repaintBird(g);
        repaintScore(g);
    }

    private void repaintBird(Graphics g){
        repaintShadow(g);
        repaintBeak(g);
        if(board.getActualBird().getPower() == Power.NONE)
            g.setColor(BIRD_COLOR_NONE);
        else if (board.getActualBird().getPower() == Power.SPRINT)
            g.setColor(BIRD_COLOR_SPRINT);
        Coordinates c = board.getActualBird().getCoordinates();
        g.fillOval(c.getX()-Bird.BODY_RADIUS, getHeight() - c.getY()-Bird.BODY_RADIUS, Bird.BODY_RADIUS*2, Bird.BODY_RADIUS*2);
        repaintEyes(g);
    }

    private void repaintShadow(Graphics g){
        g.setColor(SHADOW_COLOR);
        Coordinates c = board.getActualBird().getCoordinates();
        double size = 1 + Math.max(0.0, (double)(c.getY()-Board.GROUND)/750);
        if(c.getY() >= Board.GROUND + Board.GROUND/2 + Bird.BODY_RADIUS)
            g.fillOval(c.getX()-(int)(Bird.BODY_RADIUS*size), getHeight() - Board.GROUND - Board.GROUND/2 - Bird.BODY_RADIUS, (int)(Bird.BODY_RADIUS*2*size), (int)(Bird.BODY_RADIUS*size));
    }

    private void repaintBeak(Graphics g){
        g.setColor(BEAK_COLOR);
        Beak b = board.getActualBird().getBeak();
        Coordinates c = b.getCoordinates();
        Vector direction = b.getDirection();
        Vector rotated = direction.getRightAngle();
        double coefWidth = rotated.getNorme()/Beak.WIDTH;
        double coefLenght = direction.getNorme()/Beak.LENGTH;
        g.fillPolygon(new int[]{
                        c.getX()+(int)(rotated.getX()/coefWidth),
                        c.getX()-(int)(rotated.getX()/coefWidth),
                        (int)(c.getX()+direction.getX()/coefLenght)},
                new int[]{
                        getHeight() - c.getY()+(int)(rotated.getY()/coefWidth),
                        getHeight() - c.getY()-(int)(rotated.getY()/coefWidth),
                        getHeight() - (int)(c.getY()+direction.getY()/coefLenght)}, 3);
    }

    private void repaintEyes(Graphics g){
        g.setColor(EYES_COLOR);
        Coordinates c = board.getActualBird().getBeak().getCoordinates();
        g.fillOval(c.getX()-Bird.EYES_RADIUS, getHeight()-c.getY()-Bird.EYES_RADIUS, Bird.EYES_RADIUS*2, Bird.EYES_RADIUS*2);
    }

    private void repaintObstacle(Graphics g) {
        for(Obstacle o : board.getObstacles()){
            g.setColor(new Color(0, 0, 255*o.getHealth()/Obstacle.MAX_HEALTH));
            Coordinates c = o.getCoordinates();
            if(o instanceof Circle)
                g.fillOval(c.getX()-Obstacle.RADIUS, getHeight()-c.getY()-Obstacle.RADIUS, Obstacle.RADIUS*2, Obstacle.RADIUS*2);
            else if(o instanceof Rectangle)
                g.fillRect(c.getX()-Obstacle.RADIUS, getHeight()-c.getY()-Obstacle.RADIUS, Obstacle.RADIUS*2, Obstacle.RADIUS*2);
        }
    }

    private void repaintElastic(Graphics g){
        if(elastic == null)
            return;
        g.setColor(ELASTIC_COLOR);
        Coordinates c = board.getActualBird().getCoordinates();
        g.drawLine(c.getX(), getHeight()-c.getY(), c.getX()+elastic.getX(), getHeight()-(c.getY()+elastic.getY()));

    }

    private void repaintPath(Graphics g){
        g.setColor(CURVE_COLOR);
        ArrayList<Coordinates> points = board.getActualBird().getPath().getPoints();
        for (int i = 0 ; i < points.size() ; i++)
            g.fillOval(points.get(i).getX() - Forces.POINTS_RADIUS, getHeight() - points.get(i).getY() - Forces.POINTS_RADIUS, Forces.POINTS_RADIUS * 2, Forces.POINTS_RADIUS * 2);
    }

    private void repaintRemainingBird(Graphics g){
        for(int i = 0 ; i < board.getBirds().size() ; i++){
            switch (board.getBirds().get(i).getPower()){
                case NONE:
                    g.setColor(BIRD_COLOR_NONE); break;
                case SPRINT:
                    g.setColor(BIRD_COLOR_SPRINT); break;
            }
            g.fillOval(10 + i*(BIRD_REMAINING_RADIUS*2+8), getHeight()-10-BIRD_REMAINING_RADIUS*2, BIRD_REMAINING_RADIUS*2, BIRD_REMAINING_RADIUS*2);
        }
    }

    private void repaintScore(Graphics g){
        g.setColor(SCORE_COLOR);
        g.setFont(new Font("ARIAL", Font.BOLD, 22));
        g.drawString(String.valueOf(board.getScore()), getWidth() - 70 , getHeight() - 20);
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(!board.getActualBird().isFlying()) {
            Coordinates c = new Coordinates(e.getX(), getHeight() - e.getY());
            if (drag_start == null) {
                Coordinates cBird = board.getActualBird().getCoordinates();
                if(c.getX() < cBird.getX()-Bird.BODY_RADIUS || c.getX() > cBird.getX()+Bird.BODY_RADIUS || c.getY() < cBird.getY()-Bird.BODY_RADIUS || c.getY() > cBird.getY()+Bird.BODY_RADIUS)
                    return;
                drag_start = c;
            } else {
                elastic = new Vector(c, drag_start);
                birdController.drag(c);
                birdController.previewFlight(elastic.clone(), c);
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {
        if(drag_start != null){
            Coordinates drag_done = new Coordinates(e.getX(), getHeight()-e.getY());
            Vector v0 = new Vector(drag_done, drag_start);
            drag_start = null;
            elastic = null;
            birdController.fly(v0);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == 32)
            birdController.activatePower();
    }

    @Override
    public void keyReleased(KeyEvent e) {}
}
