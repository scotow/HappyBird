package GUI;

import java.awt.Dimension;

import javax.swing.JFrame;

public class FenetreHappy extends JFrame{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public FenetreHappy(String nom) {
    this.setTitle(nom);
    this.setPreferredSize(new Dimension(640, 480));
    this.setResizable(false);
    this.setLocationRelativeTo(null);
    this.pack();
  }

}
