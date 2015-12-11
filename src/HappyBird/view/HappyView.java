package HappyBird.view;

import javax.swing.JFrame;
import HappyBird.Controller.CollisionControler;
import HappyBird.Controller.PositionControler;
import HappyBird.Object.Config.Constante;
import HappyBird.model.PlateauModel;
import HappyBird.view.Move.Mouvement;

/**
 * 
 * @author debaerdm
 *
 */
public class HappyView {

  protected PlateauModel plateauModel;
  protected CollisionControler collisionControler;
  protected PositionControler controler;
  protected Mouvement v;
  private ElementView elementView;
  private JFrame jFrame;

  /**
   * Génere la frame pour afficher notre programme
   * 
   * @param label
   * @param plateauModel
   * @param collisionControler
   * @param positionControler
   */
  public HappyView(String label, PlateauModel plateauModel, CollisionControler collisionControler,
      PositionControler positionControler) {
    this.plateauModel = plateauModel;
    this.collisionControler = collisionControler;
    this.controler = positionControler;
    this.elementView = new ElementView(plateauModel, collisionControler, positionControler, v);
    jFrame = new JFrame(label);
    jFrame.add(elementView);
    jFrame.setSize(Constante.X_FRAME, Constante.Y_FRAME);
    jFrame.setResizable(false);
    jFrame.setLocationRelativeTo(null);
    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jFrame.setVisible(true);
  }


}
