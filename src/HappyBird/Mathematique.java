package HappyBird;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author debaerdm
 */
public class Mathematique {
    
    private PointBez pb1;
    private PointBez pb2;
    private int nbPoint;
    //(1-t)*xa + txa;
    
    // AB = (1-t)xa + txb;
    //    = (1-t)xa + tyb;
    public Mathematique(PointBez pb1, PointBez pb2, int nbPoint) {
        this.pb1 = pb1;
        this.pb2 = pb2;
        this.nbPoint = nbPoint;
    }
    
    
    public void calculerPoint(int t){
       
    }
    
    public double formulBezierX(PointBez p1, PointBez p2, int t){
        return (1-t)*p1.getX() + t*p2.getX();
    }
    
    public double formulBezierY(PointBez p1, PointBez p2, int t){
        return (1-t)*p1.getY() + t*p2.getY();
    }
      
}
