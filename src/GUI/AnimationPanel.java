/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import HappyBird.Oiseau;
import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author debaerdm
 */
public class AnimationPanel extends JPanel{
    
    private Oiseau oiseau;

    public AnimationPanel(int x, int y) {
        oiseau = new Oiseau(20, y-60);
        //this.setBackground(Color.black);
        this.add(this.oiseau);
    }
    
    
}
