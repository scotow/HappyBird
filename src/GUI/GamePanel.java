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
import java.util.Random;

import javax.swing.JPanel;

/**
 * 
 * @author debaerdm
 */
public class GamePanel extends JPanel{
    
    private Oiseau oiseau;
    private List <Obstacle> listeObs;
    private Obstacle b;
    private Mathematique courbeBezier;
    private List<Coordonnee> listPoint;
    private List<Coordonnee> listPoint2;
    private int width;
    private int height;
    private int buffer;
    private Random rd = new Random();
    
    /**
     * ajoute les elements dans le panel principal
     * @author garbey
     * @param x : position x du panel
     * @param y : position y du panel
     */
    public GamePanel(int width, int height) {
        this.oiseau = new Oiseau();
        this.listeObs = new ArrayList <Obstacle>();
        this.listPoint = new ArrayList<Coordonnee>();
        this.listPoint2 = new ArrayList<Coordonnee>();
        this.width = width;
        this.height = height;
        listPoint.add(new Coordonnee(1, 0)); // Premier point
        listPoint.add(new Coordonnee(rd.nextInt(20)+50, rd.nextInt(20)+120)); // Deuxieme point
        listPoint.add(new Coordonnee(rd.nextInt(50)+250, rd.nextInt(50)+200)); // Troisieme point
        //listPoint.add(new Coordonnee(600, rd.nextInt(80)+250));
        listPoint2.add(new Coordonnee(1, 0)); // Premier point
        listPoint2.add(new Coordonnee(rd.nextInt(20)+50, rd.nextInt(20)+120)); // Deuxieme point
        listPoint2.add(new Coordonnee(rd.nextInt(50)+250, rd.nextInt(50)+200)); // Troisieme point
        //listPoint.add(new Coordonnee(600, rd.nextInt(80)+250));
        courbeBezier = new Mathematique(listPoint, listPoint2);
        //test.setListPoint(new Coordonnee(600, 250));
        //this.listeObs.add(new TrucBleu(100,200,0));
        //Ajoute un par un les TrucBleu 
        /*for (int i = 0 ; i < this.listeObs.size() ; i++) {
        	this.add(this.listeObs.get(i));
        }*/
        setBackground(Color.BLACK);
        Obstacle o;
        Random r = new Random();
        int x, y;
        for (int i = 0 ; i < 10 ; i++) {
        	o = new Obstacle(r.nextInt(500), r.nextInt(350), 15);
        	listeObs.add(o);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
       // super.paintComponents(g); //To change body of generated methods, choose Tools | Templates.
        g.setColor(Oiseau.BIRD_BODY_COLOR);
        g.fillOval((int)oiseau.getPosition().getX(), (int)oiseau.getPosition().getY(), Oiseau.BIRD_BODY_RADIUS, Oiseau.BIRD_BODY_RADIUS);
        try {
			for (double i = 0.0; i < 1; i+=0.01) {
				g.setColor(Color.BLUE);
				g.fillOval((int)courbeBezier.calculerPoint(i).getX(),(this.height-30)-(int)courbeBezier.calculerPoint(i).getY(), 3, 3);
				g.setColor(Color.ORANGE);
				g.fillOval((int)courbeBezier.calculerPoint2(i).getX(),(this.height-30)-(int)courbeBezier.calculerPoint2(i).getY(), 3, 3);
			}
		} catch (PointCourbeException e) {
			e.getMessage();
		}
        
        g.setColor(Color.blue);
        for (int i = 0 ; i < this.listeObs.size(); i++) {
        	g.fillOval(listeObs.get(i).getX(), listeObs.get(i).getY(), 15,15);
        }
        
    }
    
    
    
    
}
