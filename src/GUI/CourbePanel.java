/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import Exceptions.PointCourbeException;
import HappyBird.Courbe;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author debaerdm
 */
public class CourbePanel extends JPanel{

    private Courbe courbe;
    private int frameHeight;
    
    public CourbePanel(int x, int y, int width, int height, int frameHeight, Courbe mathematique) {
        this.setPreferredSize(new Dimension(width, height));
        this.setLocation(new Point(x, y));
        this.frameHeight = frameHeight;
        this.courbe = mathematique;
    }

    @Override
    public void paintComponent(Graphics g) {
        try {
          for (double i = 0.0; i < 0.99; i += 0.01) {
            Thread.sleep(30);
            g.fillOval((int)courbe.calculerPoint(i).getX(),(int)((this.frameHeight-50) - courbe.calculerPoint(i).getY()), 20, 20);
          }
        } catch (PointCourbeException exception) {
          exception.getMessage();
        } catch (InterruptedException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
