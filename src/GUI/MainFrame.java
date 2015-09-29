package GUI;

import java.awt.Dimension;

import javax.swing.JFrame;

public class MainFrame extends JFrame{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  private MainPanel animationPanel;

  public MainFrame(String nom, int x, int y) {
    this.animationPanel = new MainPanel(x, y);
    this.setTitle(nom);
    this.setPreferredSize(new Dimension(x, y));
    this.setResizable(false);
    this.setLocationRelativeTo(null);
    this.pack();
    this.getContentPane().add(this.animationPanel);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  

}
