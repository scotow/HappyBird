package HappyBird.main;

import HappyBird.Controller.CollisionControler;
import HappyBird.Controller.PositionControler;
import HappyBird.model.PlateauModel;
import HappyBird.view.HappyView;

public class HappyBird {

  /**
   * Initialisation du pattern MVC et du programme.
   */
  public HappyBird() {
    PlateauModel plateauModel = new PlateauModel();
    CollisionControler collisionControler = new CollisionControler(plateauModel);
    PositionControler controler = new PositionControler(plateauModel);
    HappyView happyView = new HappyView("Happy Bird", plateauModel, collisionControler, controler);
    collisionControler.addView(happyView);
    controler.addView(happyView);
  }

  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {

      @Override
      public void run() {
        new HappyBird();
      }
    });
  }

}
