package HappyBird.Controller;

import HappyBird.Object.Element.Obstacle;
import HappyBird.model.PlateauModel;

import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by lopezb on 17/11/15.
 */
public class ObstacleControler {

    private final PlateauModel plateauModel;

    private final Timer movingTimer;
    private final ArrayList<Line2D> pathes;

    public ObstacleControler(PlateauModel plateauModel) {
        this.plateauModel = plateauModel;
        pathes = new ArrayList<>();
        movingTimer = new Timer();
        generatePathes(plateauModel.getListeDObstacles());
        startMoving();
    }

    private void generatePathes(ArrayList<Obstacle> obstacles){
        Random rand = new Random();
        for(Obstacle o : obstacles){
            pathes.add(new Line2D.Double(o.getPositionX(), o.getPositionY(), o.getPositionX()-50+100*rand.nextDouble(), o.getPositionY()-50+100*rand.nextDouble()));
        }
    }

    private void startMoving(){
        movingTimer.schedule(new TimerTask() {
            int index = 1;
            boolean direction = true;
            @Override
            public void run() {
                for(int i = 0 ; i < plateauModel.getListeDObstacles().size() ; i++){
                    double x = pathes.get(i).getX2() - pathes.get(i).getX1() / 100 * index;
                    plateauModel.getListeDObstacles().get(i).setPosition(x, getY(pathes.get(i), x));
                }
                if(index == 10 || index == 0)
                    direction = !direction;
                if(direction)
                    index++;
                else
                    index--;
                plateauModel.repaint();
            }
        },0, 50);
    }

    private double getY(Line2D path, double x){
        double m = (path.getY2() - path.getY1()) / (path.getX2()-path.getX1());
        double c = path.getY1() - path.getX1() * m;
        return m * x + c;
    }






}
