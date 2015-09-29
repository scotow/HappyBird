package GUI;

import java.awt.Dimension;

import javax.swing.JFrame;

public class FenetreHappy extends JFrame{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  private AnimationPanel animationPanel;

  public FenetreHappy(String nom, int x, int y) {
    this.animationPanel = new AnimationPanel(x, y);
    this.setTitle(nom);
    this.setPreferredSize(new Dimension(x, y));
    this.setResizable(false);
    this.setLocationRelativeTo(null);
    this.getContentPane().add(this.animationPanel);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.pack();
  }

}
