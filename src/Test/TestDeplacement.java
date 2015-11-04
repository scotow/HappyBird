package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import HappyBird.Object.Constante;
import HappyBird.Object.Coordonnee;
import HappyBird.Object.Obstacle;
import HappyBird.Object.Oiseau;

public class TestDeplacement {


	@Test
	public void limiteDroite () {
		//voir CollisionController
		Oiseau o = new Oiseau(1000.00,1000.00);
		assertTrue(o.getPositionX() + Constante.BIRD_BODY_RADIUS /2 >= Constante.X_FRAME ||
					o.getPositionY() + Constante.BIRD_BODY_RADIUS /2 >= Constante.Y_FRAME);
		o = new Oiseau(540,320);
		assertFalse(o.getPositionX() + Constante.BIRD_BODY_RADIUS /2 >= Constante.X_FRAME ||
			o.getPositionY() + Constante.BIRD_BODY_RADIUS /2 >= Constante.Y_FRAME);
	}
	
	@Test 
	public void testCollisionObstacleCercle () {
		//voir CollisionControler
		Obstacle obs = new Obstacle (780.00, 200.00);
		Oiseau o = new Oiseau (780.00,200.00);
		assertTrue(Math.abs(obs.getPositionX() - o.getPositionX()) <= Constante.OBSTACLE_RADIUS / 2
					+ Constante.BIRD_BODY_RADIUS / 2
					&& Math.abs(obs.getPositionY() - o.getPositionY()) <= Constante.OBSTACLE_RADIUS / 2
							+ Constante.BIRD_BODY_RADIUS / 2);
		o = new Oiseau (680.00,250.00);
		assertFalse(Math.abs(obs.getPositionX() - o.getPositionX()) <= Constante.OBSTACLE_RADIUS / 2
				+ Constante.BIRD_BODY_RADIUS / 2
				&& Math.abs(obs.getPositionY() - o.getPositionY()) <= Constante.OBSTACLE_RADIUS / 2
						+ Constante.BIRD_BODY_RADIUS / 2);
	}
    /*@Test 
	public void testAjoutCoordonneesObstacle() {
		Obstacle o = new Obstacle (50,50);
		o.ajout(2.00, 2.00);
		Coordonnee c = new Coordonnee(52,52);
		//assertTrue(c.equals(o.getCoord()));
	}
    
    @Test
    public void testCollisionBordureObstacleVrai() {
    	Obstacle o1 = new Obstacle (50,50);
    	Obstacle o2 = new Obstacle (55,55);
    	//assertTrue(o1.getCoord().collisionCercle(o2.getCoord()));
    }

    @Test
    public void testCollisionBordureObstacleFaux() {
    	Obstacle o1 = new Obstacle(50,50);
    	Obstacle o2 = new Obstacle(80,80);
    	//assertFalse(o1.getCoord().collisionCercle(o2.getCoord()));
    }*/
}
