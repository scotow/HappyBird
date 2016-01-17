package controller;

import model.Board;
import model.Coordinates;
import model.math.Forces;
import model.math.Vector;
import model.obstacle.Circle;
import model.obstacle.Obstacle;
import model.obstacle.Rectangle;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Benjamin on 09/01/16.
 */
public class ObstacleController {

    private final BoardController boardController;
    private final ArrayList<Obstacle> obstacles;
    private final ArrayList<Obstacle> flyings;

    private TimerTask flyTask;

    public ObstacleController(BoardController boardController, ArrayList<Obstacle> obstacles){
        this.boardController = boardController;
        this.obstacles = obstacles;
        flyings = new ArrayList<>();
        generateObstacles();
    }

    public void collide(Obstacle obstacle, Vector inSpeed){
        int damage = Math.abs(inSpeed.getX()) + Math.abs(inSpeed.getY());
        boardController.addPoints(damage);
        if(obstacle.reduceHealth(damage)) {
            obstacles.remove(obstacle);
            stopFly(obstacle);
            if(obstacles.isEmpty())
                generateObstacles();
            return;
        }
        Vector outSpeed = inSpeed.clone();
        outSpeed.multiply(1.50);
        obstacle.setForces(new Forces(outSpeed, false));
        if(flyings.contains(obstacle))
            return;
        flyings.add(obstacle);
        obstacle.setFlying(true);
        if(flyings.size() > 1)
            return;
        Timer flyTimer = new Timer();
        flyTask = new TimerTask() {
            @Override
            public void run() {
                for(int i = 0 ; i < flyings.size() ; i++){
                    Obstacle o = flyings.get(i);
                    o.setCoordinates(o.getForces().calculateNext(o.getCoordinates()));
                    checkForGroundWall(o);
                    checkForColision(o);
                    if (o.isTooSlow()) {
                        stopFly(o);
                    }
                }
            }
        };
        flyTimer.schedule(flyTask, 10, 10);
    }

    private void stopFly(Obstacle o){
        if(flyings.contains(o)){
            o.setFlying(false);
            flyings.remove(o);
            if(flyings.isEmpty()) {
                flyTask.cancel();
            }
        }

    }

    public void generateObstacles(){
        obstacles.clear();
        Random rand = new Random();
        for(int i = 0 ; i < 3 + rand.nextInt(5) ; i++){
            Coordinates tmp;
            boolean placable;
            int attempts = 0;
            do {
                placable = true;
                attempts++;
                tmp = new Coordinates(Board.X_SIZE - Board.X_SIZE/3 + rand.nextInt(Board.X_SIZE/3-50), Board.Y_SIZE - Board.Y_SIZE/10 - rand.nextInt(Board.Y_SIZE / 3));
                for (Obstacle o : obstacles) {
                    Coordinates c = o.getCoordinates();
                    if(tmp.getX()-Obstacle.RADIUS < c.getX()+Obstacle.RADIUS && tmp.getX()+Obstacle.RADIUS > c.getX()-Obstacle.RADIUS &&
                            tmp.getY()-Obstacle.RADIUS < c.getY()+Obstacle.RADIUS && tmp.getY()+Obstacle.RADIUS > c.getY()-Obstacle.RADIUS){
                        placable = false;
                        attempts++;
                        break;
                    }
                }
            }while (!placable && attempts < 100);
            obstacles.add(rand.nextBoolean() ? new Circle(tmp) : new Rectangle(tmp));
        }
    }

    private void checkForColision(Obstacle obstacle){
        for(int i = 0 ; i < obstacles.size() ; i++){
            Obstacle o = obstacles.get(i);
            if(o == obstacle)
                continue;
            if(o instanceof Circle ? obstacle.collideWithCircle(o.getCoordinates(), Obstacle.RADIUS) : obstacle.collideWithRectangle(o.getCoordinates(), Obstacle.RADIUS)){
                o.setTouched(true);
                collide(o, obstacle.getForces().getSpeed());
            }
        }
    }

    private void checkForGroundWall(Obstacle o){
        Coordinates c = o.getCoordinates();
        if(c.getX() + Obstacle.RADIUS > Board.X_SIZE) { //   Mur de droite.
            o.getForces().getSpeed().reverse();
            o.getCoordinates().setX(Board.X_SIZE - Obstacle.RADIUS);
        }else if(c.getX() + Obstacle.RADIUS <= 0) { //    Mur de gauche.
            o.getForces().getSpeed().reverse();
            o.getCoordinates().setX(Obstacle.RADIUS);
        }
        if((c.getY() < Obstacle.RADIUS+Board.GROUND && o.getForces().getSpeed().getY() < 0)) { //  Sol.
            Vector speed = o.getForces().getSpeed();
            speed.redirectUp();
            speed.multiply(Board.GROUND_ELASTICITY);
            o.getCoordinates().setY(Board.GROUND+Obstacle.RADIUS);
        }else if((c.getY() > Board.Y_SIZE - Obstacle.RADIUS && o.getForces().getSpeed().getY() > 0)) { //  Plafond.
            Vector speed = o.getForces().getSpeed();
            speed.redirectDown();
            speed.multiply(Board.GROUND_ELASTICITY);
            o.getCoordinates().setY(Board.Y_SIZE-Obstacle.RADIUS);
        }
    }



}
