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
public class Coordonnee {
    private double x;
    private double y;

    public Coordonnee(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public Coordonnee CalculPointBez(Coordonnee pb){
        return new Coordonnee(this.x-pb.getX(), this.y-pb.getY());
    }
    
    public double getX(){
        return this.x;
    }
    
    public double getY(){
        return this.y;
    }
    
    public boolean equals(Coordonnee c){
        return this.x == c.x && this.y == c.y;
    }
    
    @Override
    public String toString(){
        return "x : " + this.x + "\ty : " + this.y;
    }
}
