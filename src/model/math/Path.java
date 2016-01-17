package model.math;

import model.Board;
import model.Coordinates;

import java.util.ArrayList;

/**
 * Created by Benjamin on 15/01/16.
 */
public class Path {

    public final static int POINTS_RADIUS = 2;

    private final ArrayList<Coordinates> points;


    /**
     * Les coordonnées parcourus par un objet déplacable.
     */

    public Path() {
        points = new ArrayList<>();
    }


    /**
     * Génére l'intégralité des points d'un courbe jusqu'a sortir du plateau par les côtés.
     * @param start Les coordonnées de départ.
     * @param forces Les forces appliquées.
     */

    public void generateFullPath(Coordinates start, Forces forces){
        resetPoints();
        Coordinates c = forces.calculateNext(start);
        addPoints(c);
        while(c.getX() < Board.X_SIZE && c.getX() > 0 && (c.getY() > Board.GROUND || forces.getSpeed().getY()>0)) {
            c = forces.calculateNext(c);
            addPoints(c);
        }
    }

    public void addPoints(Coordinates c){
        points.add(c.clone());
    }

    public ArrayList<Coordinates> getPoints() {
        return points;
    }


    /**
     * Rétianilise les points de la courbe.
     */

    public void resetPoints(){
        points.clear();
    }

}
