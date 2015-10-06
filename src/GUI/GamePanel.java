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
    private int buffer;
    private Random rd = new Random();
    
    /**
     * ajoute les elements dans le panel principal
     * @author garbey
     * @param x : position x du panel
     * @param y : position y du panel
     */
    public GamePanel() {
        this.listeObs = new ArrayList <Obstacle>();
        this.listPoint = new ArrayList<Coordonnee>();
        this.listPoint2 = new ArrayList<Coordonnee>();
        //test.setListPoint(new Coordonnee(600, 250));
        //this.listeObs.add(new TrucBleu(100,200,0));
        this.b = new Obstacle (100,200,50);
        this.add(b);
        this.initCompenent();
        //Ajoute un par un les TrucBleu 
        /*for (int i = 0 ; i < this.listeObs.size() ; i++) {
        	this.add(this.listeObs.get(i));
        }*/
        setBackground(Color.BLACK);
    }
    
    public void initCompenent(){
        this.oiseau = new Oiseau(600);
        System.out.println(this.getHeight());
        listPoint.add(new Coordonnee(this.oiseau.getPosition().getX()+(Oiseau.BIRD_BODY_RADIUS/2), this.oiseau.getPosition().getY())); // Premier point
        listPoint.add(new Coordonnee(rd.nextInt(20)+50, rd.nextInt(20)+120)); // Deuxieme point
        listPoint.add(new Coordonnee(rd.nextInt(50)+550, rd.nextInt(50)+200)); // Troisieme point
        //listPoint.add(new Coordonnee(600, rd.nextInt(80)+250));
        listPoint2.add(new Coordonnee(1, 0)); // Premier point
        listPoint2.add(new Coordonnee(rd.nextInt(20)+50, rd.nextInt(20)+120)); // Deuxieme point
        listPoint2.add(new Coordonnee(rd.nextInt(50)+250, rd.nextInt(50)+200)); // Troisieme point
        //listPoint.add(new Coordonnee(600, rd.nextInt(80)+250));
        courbeBezier = new Mathematique(listPoint, listPoint2);
          Random r = new Random();
        for (int i = 0 ; i < 10 ; i++) {
        	b = new Obstacle(r.nextInt(200)+380, r.nextInt(350), 15);
        	listeObs.add(b);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
       // super.paintComponents(g); //To change body of generated methods, choose Tools | Templates.
        try {
            for (double i = 0; i < 1; i+=0.02) {
		g.setColor(Color.BLUE);
		g.fillOval((int)courbeBezier.calculerPoint(i).getX(),(int)courbeBezier.calculerPoint(i).getY(), 6, 6);
		g.setColor(Color.ORANGE);
		g.fillOval((int)courbeBezier.calculerPoint2(i).getX(),(int)courbeBezier.calculerPoint2(i).getY(), 6, 6);
            }
            g.drawLine((int)courbeBezier.tangente(listPoint.get(0).getX(), listPoint.get(0).getY()), (int)courbeBezier.tangente(listPoint.get(1).getX(), listPoint.get(1).getY()), (int)listPoint.get(0).getY(), (int)listPoint.get(1).getY());
        } catch (PointCourbeException e) {
            e.getMessage();
        }
        g.setColor(Oiseau.BIRD_BODY_COLOR);
        g.fillOval((int)oiseau.getPosition().getX(), (int)oiseau.getPosition().getY(), Oiseau.BIRD_BODY_RADIUS, Oiseau.BIRD_BODY_RADIUS);
        g.setColor(Color.blue);
        for (int i = 0 ; i < this.listeObs.size(); i++) {
        	g.fillOval(listeObs.get(i).getX(), listeObs.get(i).getY(), 15,15);
        }
    }
    
    
    
    
}

