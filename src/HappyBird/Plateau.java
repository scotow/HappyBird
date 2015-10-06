/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HappyBird;

import GUI.GamePanel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Lopez Benjamin
 */
public class Plateau {
    
    private final Oiseau oiseau;
    private final ArrayList <Obstacle> obstacles;
    //private Obstacle b;
    private Courbe courbeBezier;
    private List<Coordonnee> listPoint;
    //private List<Coordonnee> listPoint2;
    private int buffer;
    private Random rd = new Random();
    
    public Plateau(GamePanel gamePanel){
        this.oiseau = new Oiseau(gamePanel);
        this.obstacles = new ArrayList<>();
        placerObstacles(10);
        oiseau.bougerOiseau();
    }
    
    private void placerObstacles(int nombre){
        for (int i = 0 ; i < nombre ; i++) {
            Random rand = new Random();
        	obstacles.add(new Obstacle(rand.nextInt(200)+380, rand.nextInt(350), 15));
        }
    }
    
    public Oiseau getOiseau(){
        return this.oiseau;
    }
    
    public ArrayList<Obstacle> getObstacles(){
        return this.obstacles;
    }
    
    
}


