/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import Exceptions.PointCourbeException;
import HappyBird.Constante;
import HappyBird.Coordonnee;
import HappyBird.Plateau;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;

/**
 * 
 * @author debaerdm
 */
public class GamePanel extends JPanel{
    
    private static final long serialVersionUID = 1L;
    private Plateau plateau;

    public GamePanel() {
        plateau = new Plateau(this);
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        g.drawImage(new ImageIcon(getClass().getResource("/GUI/images/background.png")).getImage(), 0, 0, null);
        try {
            g.setColor(Color.BLUE);
            for (double i = 0; i < plateau.getOiseau().getTemps() ; i+=plateau.getOiseau().getSpeed()) {
                g.fillOval((int)plateau.getOiseau().getCourbe().calculerPoint(i).getX(),(int)plateau.getOiseau().getCourbe().calculerPoint(i).getY(), 6, 6);
            }
        } catch (PointCourbeException e) {
            e.getMessage();
        }
        g.setColor(Color.BLACK);
        for (Coordonnee Coordonnee : plateau.getOiseau().getCourbe().getListPoint()) {
            g.fillOval((int)Coordonnee.getX(), (int)Coordonnee.getY(), 15, 15);
        }
        if (!plateau.getOiseau().isTouched()) {
            g.setColor(Constante.BIRD_BODY_COLOR);
        }
        else
            g.setColor(Constante.BIRD_BEAK_COLOR);
        g.fillOval((int)plateau.getOiseau().getPosition().getX()-Constante.BIRD_BODY_RADIUS/2, (int)plateau.getOiseau().getPosition().getY()-Constante.BIRD_BODY_RADIUS/2, Constante.BIRD_BODY_RADIUS, Constante.BIRD_BODY_RADIUS);
        for (int i = 0 ; i < plateau.getObstacles().size(); i++) {
            if(plateau.getObstacles().get(i).isTouched())
                g.setColor(Constante.OBSTACLE_TOUCHED_COLOR);
            else
                g.setColor(Constante.OBSTACLE_NOT_TOUCHED_COLOR);
        	g.fillOval((int)plateau.getObstacles().get(i).getX()-Constante.OBSTACLE_RADIUS/2, (int)plateau.getObstacles().get(i).getY()-Constante.OBSTACLE_RADIUS/2, Constante.OBSTACLE_RADIUS, Constante.OBSTACLE_RADIUS);
        }
    }
}

