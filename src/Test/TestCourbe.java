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
    
    Mathematique test;
    double x;
    double y;
    
    @Before
    public void init(){
        test = new Mathematique(new Coordonnee(1.0, 1.0), new Coordonnee(5.0, 3.0), new Coordonnee(8.0, 5.0));
        x = 0;
        y = 0;
    }
    
    @SuppressWarnings("deprecation")
    @Test
    public void test1(){
        Assert.assertEquals(test.calculerPoint(1).getX(), 8.0, 0);
        Assert.assertEquals(test.calculerPoint(1).getY(), 5.0, 0);
    }
    
    @Test
    public void test2(){
      Assert.assertEquals(test.calculerPoint(0).getX(), 1.0, 0);
      Assert.assertEquals(test.calculerPoint(0).getY(), 1.0, 0);
    }
}
