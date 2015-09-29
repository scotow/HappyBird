package GUI;


import javax.swing.JFrame;

public class MainFrame extends JFrame{

  /**
   * 
   */
  //private static final long serialVersionUID = 1L;
  
 // private GamePanel gamePanel;

  public MainFrame() {
    setTitle("Happy Bird");
    setSize(600, 600);
    this.setResizable(false);
    this.setLocationRelativeTo(null);    
    this.getContentPane().add(new GamePanel(this.getWidth(),this.getHeight()));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    setVisible(true);
  }
  
  

}
