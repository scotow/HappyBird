package model.math;

import model.Coordinates;

/**
 * Created by Benjamin on 09/01/16.
 */
public class Vector {

    private int x, y;

    public Vector(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Vector(Coordinates start, Coordinates end){
        x = end.getX() - start.getX();
        y = end.getY() - start.getY();
    }

    public Vector getRightAngle(){
        return new Vector(y, x);
    }

    public void redirectUp(){
        y = (y < 0 ? -y : y);
    }

    public void redirectDown(){
        y = (y > 0 ? -y : y);
    }

    public void reverse(){
        x = -x;
    }

    public void add(Vector add){
        x += add.getX();
        y += add.getY();
    }

    public void set(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void multiply(double by){
        x *= by;
        y *= by;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public double getNorme(){
        return Math.sqrt(Math.pow(x,2) + Math.pow(y, 2));
    }

    public Vector clone(){
        return new Vector(x, y);
    }

    @Override
    public String toString() {
        return "Vector{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
