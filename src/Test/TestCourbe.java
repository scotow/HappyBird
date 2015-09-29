/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Test;

import HappyBird.Coordonnee;
import HappyBird.Mathematique;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author debaerdm
 */
public class TestCourbe {
    
    
    @Test
    public void testBezierQuatreParametre(){
      Mathematique bezierQuatreParametre = new Mathematique();
      for (double i = 0.0; i < 4.0; i++) {
        bezierQuatreParametre.setListPoint(new Coordonnee(i+1.0, i+2.0)); //(1;2)(2;3)(3;4)(4;5)
       }
        Assert.assertEquals(bezierQuatreParametre.calculerPoint(1).getX(), 4.0, 1);
        Assert.assertEquals(bezierQuatreParametre.calculerPoint(1).getY(), 5.0, 1);
    }
    
    @Test
    public void testBezierTroisParametre(){
      Mathematique bezierTroisParametre = new Mathematique();
      for (double i = 0.0; i < 3.0; i++) {
        bezierTroisParametre.setListPoint(new Coordonnee(i+1.0, i+2.0)); //(1;2)(2;3)(3;4)
       }
      Assert.assertEquals(bezierTroisParametre.calculerPoint(1).getX(), 3.0, 1);
      Assert.assertEquals(bezierTroisParametre.calculerPoint(1).getY(), 4.0, 1);
      Assert.assertEquals(bezierTroisParametre.calculerPoint(0.4).getX(), 1.8, 1);
      Assert.assertEquals(bezierTroisParametre.calculerPoint(0.4).getY(), 2.8, 1); // Calcul fait a la main.
    }
    
    @Test
    public void testBezierDeuxParametre(){
      Mathematique bezierDeuxParametre = new Mathematique();
      for (double i = 0.0; i < 2.0; i++) {
        bezierDeuxParametre.setListPoint(new Coordonnee(i+1.0, i+2.0)); //(1;2)(2;3)
       }
      Assert.assertEquals(bezierDeuxParametre.calculerPoint(1).getX(), 2.0, 1);
      Assert.assertEquals(bezierDeuxParametre.calculerPoint(1).getY(), 3.0, 1);
      Assert.assertEquals(bezierDeuxParametre.calculerPoint(0.2).getX(), 1.2, 1);
      Assert.assertEquals(bezierDeuxParametre.calculerPoint(0.2).getY(), 2.2, 1);
    }
    
    @Test
    public void testBezierUnParametre(){
      Mathematique bezierUnParametre = new Mathematique();
      bezierUnParametre.setListPoint(new Coordonnee(1.0, 2.0));;
      Assert.assertEquals(bezierUnParametre.calculerPoint(0).getX(), 1.0, 1);
      Assert.assertEquals(bezierUnParametre.calculerPoint(0).getY(), 2.0, 1);
    }
    
    @Test
    public void testBezierVoid(){
      Mathematique bezierVoid = new Mathematique();
      Assert.assertEquals(bezierVoid.calculerPoint(0).getX(), 0.0, 1);
      Assert.assertEquals(bezierVoid.calculerPoint(0).getY(), 0.0, 1);
    }
    
    @Test
    public void testBezierError(){
      Mathematique bezierError = new Mathematique();
      for (double i = 0.0; i < 5.0; i++) {
        bezierError.setListPoint(new Coordonnee(i+1.0, i+2.0)); //(1;2)(2;3)(3;4)(4;5)
       }
        Assert.assertEquals(bezierError.calculerPoint(1).getX(), 4.0, 42); //42 est le signal d'erreur envoyer !
        Assert.assertEquals(bezierError.calculerPoint(1).getY(), 5.0, 42);
    }
}
