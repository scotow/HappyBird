package GUI;


import javax.swing.JFrame;

public class MainFrame extends JFrame{

  /**
   * Poulpe-Man
   */

  public static final int X_FRAME = 600;
  public static final int Y_FRAME = 600;

  public MainFrame() {
    setTitle("Happy Bird");
    setSize(X_FRAME, Y_FRAME);
    this.setResizable(false);
    this.setLocationRelativeTo(null);    
    this.getContentPane().add(new GamePanel());
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    setVisible(true);
  }
  
  

}
