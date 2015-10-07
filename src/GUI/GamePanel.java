/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import Exceptions.PointCourbeException;
import HappyBird.Oiseau;
import HappyBird.Plateau;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

/**
 * 
 * @author debaerdm
 */
public class GamePanel extends JPanel implements KeyListener{
    
    private Plateau plateau;
    
    /**
     * ajoute les elements dans le panel principal
     * @author garbey
     * @param x : position x du panel
     * @param y : position y du panel
     */
    public GamePanel() {
        setFocusable(true);
        addKeyListener(this);

        plateau = new Plateau(this);
        setBackground(Color.BLACK);
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        try {
            g.setColor(Color.BLUE);
            for (double i = 0; i < 1; i+=0.02) {
                g.fillOval((int)plateau.getOiseau().getCourbe().calculerPoint(i).getX(),(int)plateau.getOiseau().getCourbe().calculerPoint(i).getY(), 6, 6);
            }
        } catch (PointCourbeException e) {
            e.getMessage();
        }
        g.setColor(Oiseau.BIRD_BODY_COLOR);
        g.fillOval((int)plateau.getOiseau().getPosition().getX()-Oiseau.BIRD_BODY_RADIUS/2, (int)plateau.getOiseau().getPosition().getY()-Oiseau.BIRD_BODY_RADIUS/2, Oiseau.BIRD_BODY_RADIUS, Oiseau.BIRD_BODY_RADIUS);
        g.setColor(Color.ORANGE);
        for (int i = 0 ; i < plateau.getObstacles().size(); i++) {
        	g.fillOval((int)plateau.getObstacles().get(i).getX(), (int)plateau.getObstacles().get(i).getY(), 15,15);                
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyChar() == ' ')
            this.plateau = new Plateau(this);
    }

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}

