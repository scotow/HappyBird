/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HappyBird;

import GUI.GamePanel;
import GUI.MainFrame;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Lopez Benjamin
 * Le fameux plateau de jeu
 */
public class Plateau {

    private final GamePanel gamePanel;
    private Oiseau oiseau;
    private final ArrayList <Obstacle> obstacles;
    private int simulation = 10;
    
    public Plateau(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        this.obstacles = new ArrayList<>();
        this.oiseau = new Oiseau(gamePanel, this);
        simulationDeVol(false);
    }
    /**
     * Place un certain nombre d'obstacle dans le plateau
     * @param nombre voulu d'obstacle
     */
    private void placerObstacles(int nombre){
        obstacles.clear();
        for (int i = 0 ; i < nombre ; i++) {
            Random rand = new Random();
            Obstacle tmp = new Obstacle(rand.nextInt(MainFrame.X_FRAME/3)+MainFrame.X_FRAME/3*2 - 20, rand.nextInt(MainFrame.Y_FRAME/2));
            boolean valuable = true;
            for(Obstacle j : obstacles){
                 if(Math.abs(tmp.getX() - j.getX()) <= Obstacle.RADIUS*2 && Math.abs(tmp.getY() - j.getY()) <= Obstacle.RADIUS*2){
                     i--;
                     valuable = false;
                     break;
                }
            }
            if(valuable)
                obstacles.add(tmp);
        }
    }
    /**
     * Test les collisions entre l'oiseau et les obstacles 
     */
    public void checkForColision(){
        for(Obstacle i : obstacles){
            if(Math.abs(i.getX() - oiseau.getPosition().getX()) <= Obstacle.RADIUS/2 + Oiseau.BIRD_BODY_RADIUS/2 &&
                    Math.abs(i.getY() - oiseau.getPosition().getY()) <= Obstacle.RADIUS/2 + Oiseau.BIRD_BODY_RADIUS/2){
                i.touched();
                oiseau.stopFly();
                simulationDeVol(true);
            }
        }
    }
    
    
    /**
     * Reset le Plateau a sa forme initiale
     */
    public void resetPlateau(){
        oiseau.resetPosition();
        placerObstacles(10);
        oiseau.bouger();
    }

    /**
     * La simulation qui lance la boucle de jeu. S'il y a collision, je recommence jusqu'a 10 tentatives
     * @param obstacleTouched booleen donnant l'existence de la collision
     */
    public void simulationDeVol(boolean obstacleTouched){
        Timer waitingTimer = new Timer();
        waitingTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                resetPlateau();
            }
        }, obstacleTouched ? 2000:1000);
        simulation--;
        if(simulation == 0)
            System.exit(0);

    }
    
    /**
     * Donne l'oiseau du plateau
     * @return l'oiseau du plateau
     */
    public Oiseau getOiseau(){
        return this.oiseau;
    }
    
    /**
     * Donne la liste d'obstacle du plateau
     * @return Les obstacle du plateau
     */
    public ArrayList<Obstacle> getObstacles(){
        return this.obstacles;
    }
    
    
}


