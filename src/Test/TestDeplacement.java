package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import HappyBird.Controller.PositionControler;
import HappyBird.Object.Config.Constante;
import HappyBird.Object.Element.Obstacle;
import HappyBird.Object.Element.Oiseau;
import HappyBird.model.PlateauModel;

public class TestDeplacement {

  public PlateauModel plateauModel;
  public PositionControler position;

  @Before
  public void test() {
    plateauModel = new PlateauModel();
    position = new PositionControler(plateauModel);
  }

  @Test
  public void limiteDroite() {
    // voir CollisionController
    Oiseau o = new Oiseau(1000.00, 1000.00);
    assertTrue(o.getX() + Constante.BIRD_BODY_RADIUS / 2 >= Constante.X_FRAME
        || o.getY() + Constante.BIRD_BODY_RADIUS / 2 >= Constante.Y_FRAME);
    o = new Oiseau(540, 320);
    assertFalse(o.getX() + Constante.BIRD_BODY_RADIUS / 2 >= Constante.X_FRAME
        || o.getY() + Constante.BIRD_BODY_RADIUS / 2 >= Constante.Y_FRAME);
  }

  @Test
  public void testCollisionObstacleCercle() {
    // voir CollisionControler
    Obstacle obs = new Obstacle(780.00, 200.00, Constante.OBSTACLE_RADIUS,Constante.OBSTACLE_RADIUS, "Cercle");
    Oiseau o = new Oiseau(761.00, 200.00);
    assertTrue(Math.abs(obs.getPositionX() - o.getX()) <= Constante.OBSTACLE_RADIUS / 2
        + Constante.BIRD_BODY_RADIUS / 2
        && Math.abs(obs.getPositionY() - o.getY()) <= Constante.OBSTACLE_RADIUS / 2
            + Constante.BIRD_BODY_RADIUS / 2);
    o = new Oiseau(680.00, 250.00);
    assertFalse(Math.abs(obs.getPositionX() - o.getX()) <= Constante.OBSTACLE_RADIUS / 2
        + Constante.BIRD_BODY_RADIUS / 2
        && Math.abs(obs.getPositionY() - o.getY()) <= Constante.OBSTACLE_RADIUS / 2
            + Constante.BIRD_BODY_RADIUS / 2);
  }

  @Test
  public void OiseauAvantCollision() {
    double xtmp = 0;
    double ytmp = 0;
    Oiseau oiseau = new Oiseau(100, 100);
    Obstacle obstacle = new Obstacle(160, 100,Constante.OBSTACLE_RADIUS,Constante.OBSTACLE_RADIUS,"Rectangle");
    for (int i = 0; i < 10; i += 10) {
      oiseau.setPosition(oiseau.getX() + i, oiseau.getY());
      if (!(Math.abs(obstacle.getPositionX() - oiseau.getX()) <= Constante.OBSTACLE_RADIUS
          / 2 + Constante.BIRD_BODY_RADIUS / 2 && Math.abs(obstacle.getPositionY()
          - oiseau.getY()) <= Constante.OBSTACLE_RADIUS / 2 + Constante.BIRD_BODY_RADIUS
          / 2)) {
        System.out.println("Pas de collision");
      }
    }
    oiseau.setPosition(100.0, 100.0);
    for (int i = 0; i < 70; i += 10) {
      oiseau.setPosition(oiseau.getX() + i, oiseau.getY());
      if ((Math.abs(obstacle.getPositionX() - oiseau.getX()) <= Constante.OBSTACLE_RADIUS
          / 2 + Constante.BIRD_BODY_RADIUS / 2 && Math.abs(obstacle.getPositionY()
          - oiseau.getY()) <= Constante.OBSTACLE_RADIUS / 2 + Constante.BIRD_BODY_RADIUS
          / 2)) {
        System.out.println("Il y a collision");
        xtmp = oiseau.getX();
        ytmp = oiseau.getY();
      }
    }

    for (int i = 0; i < 70; i += 10) {
      oiseau.setPosition(oiseau.getX() + i, oiseau.getY());
      if (oiseau.getX() == xtmp && oiseau.getY() == ytmp) {
        System.out.println("Pas bouger !");
      }
    }
  }
  /*
   * @Test public void testAjoutCoordonneesObstacle() { Obstacle o = new Obstacle (50,50);
   * o.ajout(2.00, 2.00); Coordonnee c = new Coordonnee(52,52);
   * //assertTrue(c.equals(o.getCoord())); }
   * 
   * @Test public void testCollisionBordureObstacleVrai() { Obstacle o1 = new Obstacle (50,50);
   * Obstacle o2 = new Obstacle (55,55); //assertTrue(o1.getCoord().collisionCercle(o2.getCoord()));
   * }
   * 
   * @Test public void testCollisionBordureObstacleFaux() { Obstacle o1 = new Obstacle(50,50);
   * Obstacle o2 = new Obstacle(80,80); //assertFalse(o1.getCoord().collisionCercle(o2.getCoord()));
   * }
   */
}
