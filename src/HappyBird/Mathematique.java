package HappyBird;

import java.util.ArrayList;
import java.util.List;

import Exception.PointCourbeException;

/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

/**
 *
 * @author debaerdm
 */
public class Mathematique {

  private List<Coordonnee> listPoint;
  private List<Coordonnee> listPoint2;

    public Mathematique() {
        listPoint = new ArrayList<Coordonnee>();
    }
  
  
  public Mathematique(List<Coordonnee> listPoint, List<Coordonnee> listPoint2) {
    this.listPoint = listPoint;
    this.listPoint2 = listPoint2;
  }



  public Coordonnee calculerPoint(double t) throws PointCourbeException {
	double coordX = 0.0;
	double coordY = 0.0;
    if (listPoint.size() <= 3) {
    	/*Coordonnee coord = calculeBezier(listPoint, 1, 1, t);
        coordX = coord.getX();
        coordY = coord.getY();*/
      switch (listPoint.size()) {
        case 1:
          coordX = listPoint.get(0).getX();
          coordY = listPoint.get(0).getY();
          break;
        case 2:
          coordX = formulBezier(listPoint.get(0).getX(), listPoint.get(1).getX(), t);
          coordY = formulBezier(listPoint.get(0).getY(), listPoint.get(1).getY(), t);
          break;
        case 3:
          coordX =
              formulBezier(formulBezier(listPoint.get(0).getX(), listPoint.get(1).getX(), t),
                  formulBezier(listPoint.get(1).getX(), listPoint.get(2).getX(), t), t);
          coordY =
              formulBezier(formulBezier(listPoint.get(0).getY(), listPoint.get(1).getY(), t),
                  formulBezier(listPoint.get(1).getY(), listPoint.get(2).getY(), t), t);
          break;
        /*case 4:
          coordX =
              formulBezier(
                  formulBezier(formulBezier(listPoint.get(0).getX(), listPoint.get(1).getX(), t),
                      formulBezier(listPoint.get(1).getX(), listPoint.get(2).getX(), t), t),
                  formulBezier(formulBezier(listPoint.get(1).getX(), listPoint.get(2).getX(), t),
                      formulBezier(listPoint.get(2).getX(), listPoint.get(3).getX(), t), t), t);
          coordY =
              formulBezier(
                  formulBezier(formulBezier(listPoint.get(0).getY(), listPoint.get(1).getY(), t),
                      formulBezier(listPoint.get(1).getY(), listPoint.get(2).getY(), t), t),
                  formulBezier(formulBezier(listPoint.get(1).getY(), listPoint.get(2).getY(), t),
                      formulBezier(listPoint.get(2).getY(), listPoint.get(3).getY(), t), t), t);
          break;*/
        default:
          coordX = 0.0;
          coordY = 0.0;
          break;
      }
    } else {
      throw new PointCourbeException("Trop de point !");
    }
    return new Coordonnee(coordX, coordY);
  }
  
  public Coordonnee calculerPoint2(double t) throws PointCourbeException {
		double coordX = 0.0;
		double coordY = 0.0;
	    if (listPoint2.size() <= 4) {
	    	/*Coordonnee coord = calculeBezier(listPoint2,listPoint2.get(0).getX(),listPoint2.get(0).getY(),t);
	        coordX = coord.getX();
	        coordY = coord.getY();*/
	    } else {
	      throw new PointCourbeException("Trop de point !");
	    }
	    return new Coordonnee(coordX, coordY);
	  }
  
  public Coordonnee calculeBezier(List<Coordonnee> listPoint,Coordonnee result,double x, double y,  double t ) {
	if (listPoint.size() == 1) {
		return result;
	}
	return null;
  }

  public double formulBezier(double point1, double point2, double t) {
    return ((1 - t) * point1) + (t * point2);
  }

  public List<Coordonnee> getListPoint() {
    return this.listPoint;
  }

  public void setListPoint(Coordonnee coordonnee) {
    listPoint.add(coordonnee);
  }
  
  public boolean videListe(){
	  for(int i = listPoint.size()-1; i != 0; --i){
		  this.listPoint.remove(i);
	  }
	  return this.listPoint.isEmpty();
  }
}
