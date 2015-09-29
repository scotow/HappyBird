/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author debaerdm
 */
public class PointBez {
    private double x;
    private double y;

    public PointBez(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public PointBez CalculPointBez(PointBez pb){
        return new PointBez(this.x-pb.getX(), this.y-pb.getY());
    }
    
    public double getX(){
        return this.x;
    }
    
    public double getY(){
        return this.y;
    }
}
