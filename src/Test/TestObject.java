/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package Test;

import javax.swing.Timer;

import HappyBird.Controller.CollisionControler;
import HappyBird.Controller.PositionControler;
import HappyBird.Object.Config.Constante;
import HappyBird.Object.Element.Obstacle;
import HappyBird.model.PlateauModel;
import HappyBird.view.HappyView;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author debaerdm
 */
public class TestObject {

  public PlateauModel plateauModel;
  public PositionControler position;
  public CollisionControler collision;
  public HappyView happyView;

  @Before
  public void test() {
    plateauModel = new PlateauModel();
    position = new PositionControler(plateauModel);
    collision = new CollisionControler(plateauModel);
    happyView = new HappyView("Test", plateauModel, collision, position);
    collision.addView(happyView);
  }

  @Test
  public void timerStop() {
    plateauModel.setOiseauPosition(761.00, 200.00);
    plateauModel.addObstacles(new Obstacle(780.00, 200.00,Constante.OBSTACLE_RADIUS,Constante.OBSTACLE_RADIUS,"Cercle"));
    plateauModel.addObstacles(new Obstacle(740.00, 200.00,Constante.OBSTACLE_RADIUS,Constante.OBSTACLE_RADIUS,"Cercle"));
    plateauModel.setFlyTimer(new Timer(5000, null));
    plateauModel.startFly();
    if (collision.collision())
      plateauModel.stopFly();
    assertFalse(plateauModel.getFlyTimer().isRunning());
  }
}
