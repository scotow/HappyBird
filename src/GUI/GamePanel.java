/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import Exception.PointCourbeException;
import HappyBird.Coordonnee;
import HappyBird.Courbe;
import HappyBird.Oiseau;
import HappyBird.Obstacle;
import HappyBird.Plateau;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;

/**
 * 
 * @author debaerdm
 */
public class GamePanel extends JPanel{
    
    private final Plateau plateau;
    
    /**
     * ajoute les elements dans le panel principal
     * @author garbey
     * @param x : position x du panel
     * @param y : position y du panel
     */
    public GamePanel() {
        plateau = new Plateau();
        
        setBackground(Color.BLACK);
    }

    @Override
    public void paintComponent(Graphics g) {
        try {
            g.setColor(Color.BLUE);
            for (double i = 0; i < 1; i+=0.02) {
		//g.fillOval((int)courbeBezier.calculerPoint(i).getX(),(int)courbeBezier.calculerPoint(i).getY(), 6, 6);
//		g.setColor(Color.ORANGE);
//		g.fillOval((int)courbeBezier.calculerPoint2(i).getX(),(int)courbeBezier.calculerPoint2(i).getY(), 6, 6);
                g.fillOval((int)plateau.getOiseau().getCourbe().calculerPoint(i).getX(),(int)plateau.getOiseau().getCourbe().calculerPoint(i).getY(), 6, 6);
            }
        } catch (PointCourbeException e) {
            e.getMessage();
        }
        g.setColor(Oiseau.BIRD_BODY_COLOR);
        g.fillOval((int)plateau.getOiseau().getPosition().getX(), (int)plateau.getOiseau().getPosition().getY(), Oiseau.BIRD_BODY_RADIUS, Oiseau.BIRD_BODY_RADIUS);
        g.setColor(Color.ORANGE);
        //System.out.println(plateau.getObstacles().size());
        for (int i = 0 ; i < plateau.getObstacles().size(); i++) {
        	g.fillOval((int)plateau.getObstacles().get(i).getX(), (int)plateau.getObstacles().get(i).getY(), 15,15);                
        }
    }
    
    
    
    
}

