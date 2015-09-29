package HappyBird;

import GUI.MainFrame;


public class HappyBird {

  /**
   * @param args
   */
  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      
      @Override
      public void run() {
        new MainFrame("Happy-Bird", 1024, 720).setVisible(true);
      }
    });
  }

}
