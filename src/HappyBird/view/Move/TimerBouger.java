package HappyBird.view.Move;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Timer;

import HappyBird.Controller.CollisionControler;
import HappyBird.Controller.PositionControler;
import HappyBird.model.PlateauModel;
import HappyBird.view.ObjectView;

public class TimerBouger implements Observer {

  /**
   * Concerne les deplacements de l'oiseau, implemente l'observeur
   */
  protected PlateauModel model;
  protected CollisionControler collisionControler;
  protected PositionControler positionControler;
  private ObjectView objectView;

  /**
   * Cree le timerBouger
   * 
   * @param objectView : la vue objet
   * @param plateauModel : le plateau de jeu
   * @param collisionControler : le controleur de collision
   * @param positionControler : le controleur de position
   */
  public TimerBouger(ObjectView objectView, PlateauModel plateauModel,
      CollisionControler collisionControler, PositionControler positionControler) {
    this.objectView = objectView;
    this.model = plateauModel;
    this.collisionControler = collisionControler;
    this.positionControler = positionControler;
    plateauModel.addObserver(TimerBouger.this);
  }

  /**
   * Fait deplacer l'oiseau, en controlant les collisions et le positionnement
   */
  public void bouger() {
    model.setFlyTimer(new Timer((int) model.getSpeed() * 5000, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        model.setT(model.getT() + model.getSpeed());
        positionControler.fixeOiseau();
        model.addRectangle(new Rectangle((int) model.getOiseauPostion().getX(), (int) model
            .getOiseauPostion().getY(), 5, 5));
        if (collisionControler.collision()) {
          model.stopFly();
          objectView.simulationDeVol();
        }
        objectView.repaint();
      }
    }));
    model.startFly();
  }

  @Override
  public void update(Observable o, Object arg) {
    objectView.repaint();

  }

}
