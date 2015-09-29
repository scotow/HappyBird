package HappyBird;

import java.util.ArrayList;
import java.util.List;

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
    
    private List<Coordonnee> listPoint;
    //(1-t)*xa + txa;
    
    // AB = (1-t)xa + txb;
    //    = (1-t)xa + tyb;
    public Mathematique(){
        this.listPoint = new ArrayList<Coordonnee>();
    }
    
    public Mathematique(double x, double y) {
        this();
        //listPoint.add(new Coordonnee(x, y));
        if (listPoint.size() < 4) {
            listPoint.add(new Coordonnee(x, y));
        }
    }
    
    
    public Coordonnee calculerPoint(double t){
        double coordX = 0.0;
        double coordY = 0.0;
        switch(listPoint.size()){
            case 0:
                coordX = listPoint.get(0).getX();
                coordY = listPoint.get(0).getY();
                break;
            case 1:
                coordX = formulBezier(listPoint.get(0).getX(), listPoint.get(1).getX(), t);
                coordY = formulBezier(listPoint.get(0).getY(), listPoint.get(1).getY(), t);
                break;
            case 2:
                coordX = formulBezier(formulBezier(listPoint.get(0).getX(),
                        listPoint.get(1).getX(), t), formulBezier(listPoint.get(1).getX(), listPoint.get(2).getX(), t), t);
                coordY = formulBezier(formulBezier(listPoint.get(0).getY(),
                        listPoint.get(1).getY(), t), formulBezier(listPoint.get(1).getY(), listPoint.get(2).getY(), t), t);
                break;
            case 3:
                coordX = formulBezier(formulBezier(formulBezier(listPoint.get(0).getX(),
                        listPoint.get(1).getX(), t),
                        formulBezier(listPoint.get(1).getX(),
                        listPoint.get(2).getX(), t), t),
                        formulBezier(formulBezier(listPoint.get(1).getX(),
                        listPoint.get(2).getX(), t), formulBezier(listPoint.get(2).getX(),
                        listPoint.get(3).getX(), t), t), t);
                coordY = formulBezier(formulBezier(formulBezier(listPoint.get(0).getY(),
                        listPoint.get(1).getY(), t),
                        formulBezier(listPoint.get(1).getY(),
                        listPoint.get(2).getY(), t), t),
                        formulBezier(formulBezier(listPoint.get(1).getY(),
                        listPoint.get(2).getY(), t), formulBezier(listPoint.get(2).getY(),
                        listPoint.get(3).getY(), t), t), t);
                break;
            default:
                coordX = 0.0;
                coordY = 0.0;
                break;
        }

        return new Coordonnee(coordX, coordY);
    }
    
    public double formulBezier(double point1, double point2, double t){
        return (1-t)*point1 + t*point2;
    }
    
    public List<Coordonnee> getListPoint(){
        return this.listPoint;
    }
}
