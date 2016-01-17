package model.math;

import model.Board;
import model.Coordinates;

import java.util.ArrayList;

/**
 * Created by Benjamin on 15/01/16.
 */
public class Path {

    private final ArrayList<Coordinates> points;

    public Path() {
        points = new ArrayList<>();
    }

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

    public void resetPoints(){
        points.clear();
    }

}
