/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import Exception.PointCourbeException;
import HappyBird.Coordonnee;
import HappyBird.Mathematique;
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
    private Mathematique test = new Mathematique();
    private int width;
    private int height;
    
    /**
     * ajoute les elements dans le panel principal
     * @author garbey
     * @param x : position x du panel
     * @param y : position y du panel
     */
    public GamePanel(int width, int height) {
        this.oiseau = new Oiseau();
        this.listeObs = new ArrayList <Obstacle>();
        this.width = width;
        this.height = height;
        test.setListPoint(new Coordonnee(1, 3)); // Premier point
        test.setListPoint(new Coordonnee(3, 8.5)); // Deuxieme point
        test.setListPoint(new Coordonnee(8, 14)); // Troisieme point
        //test.setListPoint(new Coordonnee(25, 20)); 
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
       // super.paintComponents(g); //To change body of generated methods, choose Tools | Templates.
        g.setColor(Oiseau.BIRD_BODY_COLOR);
        g.fillOval((int)oiseau.getPosition().getX(), (int)oiseau.getPosition().getY(), Oiseau.BIRD_BODY_RADIUS, Oiseau.BIRD_BODY_RADIUS);
        g.setColor(Color.GREEN);
        try {
          for (int i = 0; i < 25; i++) {
            g.fillOval((int)test.calculerPoint(i).getX(),(int)((this.height-50) - test.calculerPoint(i).getY()), 20, 20);
          }
        } catch (PointCourbeException exception) {
          // TODO Auto-generated catch block
          exception.printStackTrace();
        }
        
    }
    
    
    
    
}
