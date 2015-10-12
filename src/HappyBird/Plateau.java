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

    public void resetPlateau(){
        oiseau.resetPosition();
        placerObstacles(10);
        oiseau.bouger();
    }

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
    
    public Oiseau getOiseau(){
        return this.oiseau;
    }
    
    public ArrayList<Obstacle> getObstacles(){
        return this.obstacles;
    }
    
    
}


