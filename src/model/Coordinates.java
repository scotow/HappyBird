package model;

/**
 *
 * @author Lopez Benjamin
 */

public class Coordinates {
    
    private int x,y;


    /**
     *  Créer un points de coordonnées.
     * @param x
     * @param y
     */
    
    public Coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void set(Coordinates c){
        this.x = c.getX();
        this.y = c.getY();
    }

    public void add(int x, int y){this.x+=x; this.y+=y;}

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public Coordinates clone(){
        return new Coordinates(x, y);
    }
}
