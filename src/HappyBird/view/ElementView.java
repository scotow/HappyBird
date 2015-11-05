package HappyBird.view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;

import HappyBird.Controller.CollisionControler;
import HappyBird.Controller.PositionControler;
import HappyBird.Object.Constante;
import HappyBird.model.PlateauModel;

public class ElementView extends ObjectView {

  /**
   * Concerne l'affichage des elements, herite de la vue objet
   */
  private static final long serialVersionUID = 1L;

  /**
   * Cree la vue element et place des point de bezier puis fixe les obstacles et démarre l'animation
   * 
   * @param plateauModel : le plateau de jeu
   * @param collisionControler : le controleur de collision
   * @param positionControler : le controler de position
   */
  public ElementView(PlateauModel plateauModel, CollisionControler collisionControler,
      PositionControler positionControler) {
    super(plateauModel, collisionControler, positionControler);
    random = true;
    positionControler.fixePointBezier();
    positionControler.fixeObstacles((random) ? 0 : clickPut().getX(), (random) ? 0 : clickPut()
        .getY(), random);
    bouger();
  }

  @Override
  public void update(Observable o, Object arg) {
    ElementView.this.repaint();
  }

  /**
   * Affiche les differents objets
   */
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    for (int i = 0; i < model().getListeDObstacles().size(); i++) {
      g.setColor(model().getObstaclesColor(i));
      g.fillOval((int) model().getObstaclePostion(i).getX() - model().getObstacleTaille(i)[0] / 2,
          (int) model().getObstaclePostion(i).getY() - model().getObstacleTaille(i)[1] / 2, model()
              .getObstacleTaille(i)[0], model().getObstacleTaille(i)[1]);
    }
    g.setColor(Constante.POINT_BEZIER);

    /*
     * for (int i = 0; i < model().getListeDePoint().size(); i++) { g.fillOval((int)
     * model().getPoint(i).getX(), (int) model().getPoint(i).getY(), 15, 15); if (i >= 1) {
     * g.drawLine((int) model().getPoint(i - 1).getX() + 15 / 2, (int) model().getPoint(i - 1)
     * .getY() + 15 / 2, (int) model().getPoint(i).getX() + 15 / 2, (int) model().getPoint(i)
     * .getY() + 15 / 2); } }
     */

    for (int i = 0; i < model().getRectangles().size(); i++) {
      if (i % 80 == 0) {
        g.fillRect(model().getRectangleByIndex(i).x, model().getRectangleByIndex(i).y, model()
            .getRectangleByIndex(i).width, model().getRectangleByIndex(i).height);
      }
    }
    g.setColor(model().getBecOiseauColor());
    g.fillPolygon(model().getBecOiseauPolygon());
    g.setColor(model().getOiseauColor());
    g.fillOval((int) model().getOiseauPostion().getX() - model().getOiseauTaille()[0] / 2,
        (int) model().getOiseauPostion().getY() - model().getOiseauTaille()[1] / 2, model()
            .getOiseauTaille()[0], model().getOiseauTaille()[1]);
    g.setColor(Color.BLACK);
  }

}
