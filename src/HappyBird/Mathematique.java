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
        int coordX = this.formulBezier(this.formulBezier(pb1.getX(), pb2.getX(), t), this.formulBezier(pb2.getX(), pb3.getX(), t), t);
        int coordY = this.formulBezier(this.formulBezier(pb1.getY(), pb2.getY(), t), this.formulBezier(pb2.getY(), pb3.getY(), t), t);
        return new Coordonnee(coordX, coordY);
    }
    
    public int formulBezier(int point1, int point2, int t){
        return (1-t)*point1 + t*point2;
    }
}
