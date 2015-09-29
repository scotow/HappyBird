/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import HappyBird.Oiseau;
import HappyBird.Obstacle;
import java.awt.Color;
import java.awt.Graphics;

import java.util.ArrayList;
import java.util.List;


import javax.swing.JPanel;

/**
 * 
 * @author debaerdm
 */
public class GamePanel extends JPanel{
    
    private Oiseau oiseau;
    private List <Obstacle> listeObs;
    private Obstacle b;
    
    /**
     * ajoute les elements dans le panel principal
     * @author garbey
     * @param x : position x du panel
     * @param y : position y du panel
     */
    public GamePanel() {
        this.oiseau = new Oiseau();
        this.listeObs = new ArrayList <Obstacle>();
        //this.listeObs.add(new TrucBleu(100,200,0));
        this.b = new Obstacle (100,200,50);
        this.add(b);
        //Ajoute un par un les TrucBleu 
        /*for (int i = 0 ; i < this.listeObs.size() ; i++) {
        	this.add(this.listeObs.get(i));
        }*/
        setBackground(Color.BLACK);
        
       
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g); //To change body of generated methods, choose Tools | Templates.
        g.setColor(oiseau.BIRD_BODY_COLOR);
        g.fillOval((int)oiseau.getPosition().getX(), (int)oiseau.getPosition().getY(), oiseau.BIRD_BODY_RADIUS, oiseau.BIRD_BODY_RADIUS);
    }
    
    
    
    
}
