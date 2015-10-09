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

/**
 *
 * @author Lopez Benjamin
 */
public class Plateau {
    
    private final Oiseau oiseau;
    private final ArrayList <Obstacle> obstacles;
    
    public Plateau(GamePanel gamePanel){
        this.oiseau = new Oiseau(gamePanel, this);
        this.obstacles = new ArrayList<>();
        placerObstacles(10);
        oiseau.bouger();
    }
    
    private void placerObstacles(int nombre){
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
                oiseau.resetPosition();
            }
        }
    }
    
    public Oiseau getOiseau(){
        return this.oiseau;
    }
    
    public ArrayList<Obstacle> getObstacles(){
        return this.obstacles;
    }
    
    
}


