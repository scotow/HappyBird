/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import HappyBird.Oiseau;
import HappyBird.TrucBleu;
import java.awt.Color;
import java.util.List;

import javax.swing.JPanel;

/**
 * 
 * @author debaerdm
 */
public class MainPanel extends JPanel{
    
    private Oiseau oiseau;
    private List <TrucBleu> listeObs;

    public MainPanel(int x, int y) {
        this.oiseau = new Oiseau();
        //this.setBackground(Color.black);
        this.add(this.oiseau);
    }
    
    
}
