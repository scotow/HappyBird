/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HappyBird;

import java.io.Serializable;

/**
 *
 * @author Lopez Benjamin
 */

public class Coordonnee implements Serializable{
    
    private int x,y;
    
    public Coordonnee(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
//    public void addDirection(Coordonnee ajout){
//        this.x += (ajout.x + Constantes.X_FRAME)%Constantes.X_FRAME;
//        this.y += (ajout.y + Constantes.Y_FRAME)%Constantes.Y_FRAME;
//    }
    
    public boolean equals(Coordonnee c){
        return this.x == c.x && this.y == c.y;
    }
    
    @Override
    public String toString(){
        return "x : " + this.x + "\ty : " + this.y;
    }
}
