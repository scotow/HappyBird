package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import HappyBird.Coordonnee;
import HappyBird.Obstacle;

public class TestDeplacement {


	
    @Test 
	public void testAjoutCoordonneesObstacle() {
		Obstacle o = new Obstacle (50,50,15);
		o.getCoord().ajout(2.00, 2.00);
		Coordonnee c = new Coordonnee(52,52);
		assertTrue(c.equals(o.getCoord()));
	}
    
    @Test
    public void testCollisionBordureObstacleVrai() {
    	Obstacle o1 = new Obstacle (50,50,15);
    	Obstacle o2 = new Obstacle (55,55,15);
    	assertTrue(o1.getCoord().collisionCercle(o2.getCoord()));
    }

    @Test
    public void testCollisionBordureObstacleFaux() {
    	Obstacle o1 = new Obstacle(50,50,15);
    	Obstacle o2 = new Obstacle(80,80,15);
    	assertFalse(o1.getCoord().collisionCercle(o2.getCoord()));
    }
}
