package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import HappyBird.Controller.PositionControler;
import HappyBird.Object.Constante;
import HappyBird.Object.Coordonnee;
import HappyBird.Object.Obstacle;
import HappyBird.Object.Oiseau;
import HappyBird.model.PlateauModel;

public class TestPosition {

  public PlateauModel plateauModel;
  public PositionControler position;
  public List<Coordonnee> pointBezier;

  @Before
  public void test() {
    plateauModel = new PlateauModel();
    position = new PositionControler(plateauModel);
    pointBezier = new ArrayList<>();
  }

  // Test si les obstacles sont placer au bonne endroit.
  @Test
  public void positionObstacle() {
    // Pas placer dans la zone des obstacles.
    Obstacle o = new Obstacle(0.0, 50.0);
    assertFalse(position.controlObstacle(o.getPositionX(), o.getPositionY()));
    // Placer dans la zone des obstacles
    o = new Obstacle(780.0, 200.0);
    assertFalse(position.controlObstacle(o.getPositionX(), o.getPositionY()));
    // En-dehors de la Frame
    o = new Obstacle(Constante.X_FRAME + 50.0, 500.0);
    assertFalse(position.controlObstacle(o.getPositionX(), o.getPositionY()));
    // En-dehors de la frame mais tres loin.
    o = new Obstacle(-50.0, 10000.0);
    assertFalse(position.controlObstacle(o.getPositionX(), o.getPositionY()));
  }

  @Test
  public void postionOiseauAuDepart() {
    assertEquals(plateauModel.getOiseau().getPositionX(), Constante.BIRD_BODY_RADIUS * 2, 0);
    assertEquals(plateauModel.getOiseau().getPositionY(), Constante.Y_FRAME
        - (Constante.BIRD_BODY_RADIUS * 3), 0);
  }

  @Test
  public void positionOiseauDansSaTrajectoire() {
    Oiseau oiseau = new Oiseau(20, (Constante.Y_FRAME - 20));
    plateauModel.setOiseauPosition(oiseau.getPositionX(), oiseau.getPositionY());
    pointBezier.add(new Coordonnee(plateauModel.getOiseauPostion().getX(), plateauModel
        .getOiseauPostion().getY()));
    pointBezier.add(new Coordonnee(100.0, 100.0));
    pointBezier.add(new Coordonnee(300.0, 300.0));
    pointBezier.add(new Coordonnee(Constante.X_FRAME + 50, 500.0));
    plateauModel.setOiseauPosition(plateauModel.getCourbe().calculerPoint(pointBezier, 0.2).getX(),
        plateauModel.getCourbe().calculerPoint(pointBezier, 0.2).getY());
    assertEquals(plateauModel.getOiseauPostion().getX(), 85.04, 0.00000001);
    assertEquals(plateauModel.getOiseauPostion().getY(), 301.6, 0.00000001);
  }


}
