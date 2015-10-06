package HappyBird;

import Exceptions.PointCourbeException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

/**
 *
 * @author debaerdm
 */
public class Courbe {

  private List<Coordonnee> listPoint;

    public Courbe() {
        listPoint = new ArrayList<Coordonnee>();
    }
  
  
  public Courbe(List<Coordonnee> listPoint) {
    this.listPoint = listPoint;
  }

  
    public void setRandomCourbe(Coordonnee beginning){
        Random rand = new Random();
        listPoint.add(new Coordonnee(beginning.getX()+(Oiseau.BIRD_BODY_RADIUS/2), beginning.getY())); // Premier point
        listPoint.add(new Coordonnee(rand.nextInt(20)+50, rand.nextInt(20)+120)); // Deuxieme point
        listPoint.add(new Coordonnee(rand.nextInt(50)+500, rand.nextInt(50)+100)); // Troisieme point
        listPoint.add(new Coordonnee(rand.nextInt(50)+550, rand.nextInt(50)+530)); // Quatrieme point
    }

  public Coordonnee calculerPoint(double t) throws PointCourbeException {
    Coordonnee bezier = formulBezier(this.listPoint, t);
	double coordX = bezier.getX();
	double coordY = bezier.getY();
    return new Coordonnee(coordX, coordY);
  }

  public double formulBezier(double point1, double point2, double t) {
    return ((1 - t) * point1) + (t * point2);
  }
  
  public Coordonnee formulBezier(List<Coordonnee> listpoint, double t){
    if (listpoint.size() > 4 || listpoint.isEmpty()) {
      return new Coordonnee(0, 0);
    }
    return new Coordonnee(formuleBezierParam((listpoint.get(0) == null)? 0.0:listpoint.get(0).getX(), // Pour les X
                                             (listpoint.get(1) == null)? 0.0:listpoint.get(1).getX(),
                                             (listpoint.get(2) == null)? 0.0:listpoint.get(2).getX(),
                                             (listpoint.get(3) == null)? 0.0:listpoint.get(3).getX(),t),
                         (formuleBezierParam((listpoint.get(0) == null)? 0.0:listpoint.get(0).getY(), // Pour les Y
                                             (listpoint.get(1) == null)? 0.0:listpoint.get(1).getY(),
                                             (listpoint.get(2) == null)? 0.0:listpoint.get(2).getY(),
                                             (listpoint.get(3) == null)? 0.0:listpoint.get(3).getY(),t)));
  }
  
  public double formuleBezierParam(double p0, double p1, double p2, double p3, double t){
    return (p0*Math.pow((1-t), 3)) + (((3*p1)*t)*Math.pow((1-t), 2)) + (((3*p2)*Math.pow(t, 2))*(1-t)) + p3*Math.pow(t, 3);
  }

  public List<Coordonnee> getListPoint() {
    return this.listPoint;
  }

  public void setListPoint(Coordonnee coordonnee) {
    listPoint.add(coordonnee);
  }
  
  public double tangente(double t){
      
    
      return t;
  }
}
