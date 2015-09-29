/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import HappyBird.Oiseau;
import HappyBird.Obstacle;

import java.util.ArrayList;
import java.util.List;


import javax.swing.JPanel;

/**
 * 
 * @author debaerdm
 */
public class MainPanel extends JPanel{
    
    private Oiseau oiseau;
    private List <Obstacle> listeObs;
    private Obstacle b;
    
    /**
     * ajoute les elements dans le panel principal
     * @author garbey
     * @param x : position x du panel
     * @param y : position y du panel
     */
    public MainPanel(int x, int y) {
        this.oiseau = new Oiseau();
        this.add(this.oiseau);
        this.listeObs = new ArrayList <Obstacle>();
        //this.listeObs.add(new TrucBleu(100,200,0));
        this.b = new Obstacle (100,200,50);
        this.add(b);
        //Ajoute un par un les TrucBleu 
        /*for (int i = 0 ; i < this.listeObs.size() ; i++) {
        	this.add(this.listeObs.get(i));
        }*/
    }
    
    
}
