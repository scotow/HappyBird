package model.math;

import model.Coordinates;

/**
 * Created by Benjamin on 09/01/16.
 */
public class Vector {

    private int x, y;

    /**
     * Créer un vecteur avec des valleurs directes.
     * @param x
     * @param y
     */

    public Vector(int x, int y){
        this.x = x;
        this.y = y;
    }


    /**
     * Créer un vecteur avec des coordonnées de départs et d'arrivées.
     * @param start Les coordonnées de départs.
     * @param end coordonnées d'arrivées.
     */

    public Vector(Coordinates start, Coordinates end){
        x = end.getX() - start.getX();
        y = end.getY() - start.getY();
    }

    public Vector getRightAngle(){
        return new Vector(y, x);
    }


    /**
     * Redirige le vecteur vers le haut.
     */

    public void redirectUp(){
        y = (y < 0 ? -y : y);
    }


    /**
     * Redirige de le vecteur vers le bas.
     */

    public void redirectDown(){
        y = (y > 0 ? -y : y);
    }


    /**
     * Redirige le veteur vers son opposé par rapport à l'axe des abscisses.
     */

    public void reverse(){
        x = -x;
    }


    /**
     * Ajoute un vecteur au vecteur actuel.
     * @param add Le vecteur à ajouter.
     */

    public void add(Vector add){
        x += add.getX();
        y += add.getY();
    }


    /**
     * Modifie les deux valeurs du vecteur.
     * @param x
     * @param y
     */

    public void set(int x, int y){
        this.x = x;
        this.y = y;
    }


    /**
     * Multiplie le vecteur par un valeur décimale.
     * @param by Le multiplicateur.
     */

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


    /**
     * Renvoie la norme du vecteur.
     * @return La norme.
     */

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
