package HappyBird;

import java.math.*;

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
    
    private Coordonnee pb1;
    private Coordonnee pb2;
    private Coordonnee pb3;
    private int nbPoint;
    //(1-t)*xa + txa;
    
    // AB = (1-t)xa + txb;
    //    = (1-t)xa + tyb;
    public Mathematique(Coordonnee pb1, Coordonnee pb2, Coordonnee pb3, int nbPoint) {
        this.pb1 = pb1;
        this.pb2 = pb2;
        this.pb3 = pb3;
        this.nbPoint = nbPoint;
    }
    
    
    public Coordonnee calculerPoint(int t){
        int coordX = this.formulBezierX(this.formulBezierX(pb1.getX(), pb2.getX(), t), this.formulBezierX(pb2.getX(), pb3.getX(), t), t);
        int coordY = this.formulBezierX(this.formulBezierX(pb1.getY(), pb2.getY(), t), this.formulBezierX(pb2.getY(), pb3.getY(), t), t);
        return new Coordonnee(coordX, coordY);
    }
    
    public int formulBezierX(int x1, int x2, int t){
        return (1-t)*x1 + t*x2;
    }
    
    public int formulBezierY(int y1,int y2, int t){
        return (1-t)*y1 + t*y2;
    }
      
}
