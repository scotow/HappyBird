package controller;

import model.Coordinates;
import model.bird.Beak;
import model.bird.Bird;
import model.Board;
import model.math.Forces;
import model.math.Vector;
import model.obstacle.Obstacle;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Benjamin on 09/01/16.
 */
public class BirdController {

    private Bird bird;
    private final ArrayList<Obstacle> obstacles;
    private final BoardController boardController;
    private final ObstacleController obstacleController;
    private TimerTask flyTask;


    /**
     *
     * @param bird L'oiseau de début de partie.
     * @param obstacles Les obstacles actuels du plateau.
     * @param boardController Le controlleur du plateau.
     * @param obstacleController Le controlleur des obstacles.
     */

    public BirdController(Bird bird, ArrayList<Obstacle> obstacles, BoardController boardController, ObstacleController obstacleController){
        this.bird = bird;
        this.obstacles = obstacles;
        this.boardController = boardController;
        this.obstacleController = obstacleController;
    }

    /**
     * Déplace l'oiseau lors du glissement de souris.
     * @param c Les coordonnées de destination.
     */

    public void drag(Coordinates c){
        bird = boardController.getActualBird();
        bird.setCoordinates(c);
    }


    /**
     * Démarre le vol de l'oiseau actuellement en jeu.
     * @param v0 Le vecteur vitesse initial.
     */

    public void fly(Vector v0){
        bird.setForces(new Forces(v0, true));
        bird.getPath().resetPoints();
        bird.setFlying(true);
        Timer flyTimer = new Timer();
        flyTask = new TimerTask() {
            @Override
            public void run() {
                Coordinates next = bird.getForces().calculateNext(bird.getCoordinates());
                bird.setCoordinates(next);
                bird.getPath().addPoints(next);
                updateBeak();
                checkForGroundWall();
                checkForColision();
                if(bird.isTooSlow()) {
                    boardController.nextBird();
                    flyTask.cancel();
                }
            }
        };
        flyTimer.schedule(flyTask, 10, 10);
    }


    /**
     *  Met à jour le bec de l'oiseau.
     */

    private void updateBeak(){
        Vector speed = bird.getForces().getSpeed();
        double coef = speed.getNorme()/(Beak.FROM_BIRD_CENTER);
        Beak b = bird.getBeak();
        b.getCoordinates().set(bird.getCoordinates().getX()+(int)(speed.getX()/coef), bird.getCoordinates().getY()+(int)(speed.getY()/coef));
        b.getDirection().set((int)(speed.getX()/coef*Beak.LENGTH), (int)(speed.getY()/coef*Beak.LENGTH));
    }

    /**
     * Créer la prévisualisation de la courbe lorsque que l'oiseau est déplacer à l'aide de la souris.
     * @param v0 Le vecteur vitesse initial.
     * @param c Les coordonnées initials de l'oiseau.
     */

    public void previewFlight(Vector v0, Coordinates c){
        Forces preview = new Forces(v0, true);
        bird.setForces(preview);
        updateBeak();
        bird.getPath().generateFullPath(c, preview);
    }


    /**
     * Vérifie si il y a eu collision avec le sol ou le mur.
     */

    private void checkForGroundWall(){
        Coordinates c = bird.getCoordinates();
        if(c.getX() + Bird.BODY_RADIUS > Board.X_SIZE) { //   Mur de droite.
            bird.getForces().getSpeed().reverse();
            bird.getCoordinates().setX(Board.X_SIZE - Bird.BODY_RADIUS);
        }else if(c.getX()+Bird.BODY_RADIUS <=0) { //    Mur de gauche.
            bird.getForces().getSpeed().reverse();
            bird.getCoordinates().setX(Bird.BODY_RADIUS);
        }
        if((c.getY() < Bird.BODY_RADIUS+Board.GROUND && bird.getForces().getSpeed().getY() < 0)) { //  Sol.
            Vector speed = bird.getForces().getSpeed();
            speed.redirectUp();
            speed.multiply(Board.GROUND_ELASTICITY);
            bird.getCoordinates().setY(Board.GROUND+Bird.BODY_RADIUS);
        }
    }


    /**
     * Vérifie si il y a eu collision les obstacles.
     */

    private void checkForColision(){
        for(int i = 0 ; i < obstacles.size() ; i++){
            Obstacle o = obstacles.get(i);
            if(o.collideWithCircle(bird.getCoordinates(), bird.BODY_RADIUS))
                obstacleController.collide(o, bird.getForces().getSpeed());
        }
    }


    /**
     * Active le pouvoir d'un oiseau à usage unique après apuit sur la touche espace.
     */

    public void activatePower(){
        if(bird.hasUsePower() || !bird.isFlying())
            return;
        bird.powerActivated();
        switch (bird.getPower()){
            case NONE:
                break;
            case SPRINT:
                bird.getForces().getSpeed().multiply(2); break;
        }
    }


}
