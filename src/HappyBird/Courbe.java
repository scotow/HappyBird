package HappyBird;

import Exceptions.PointCourbeException;

import java.math.*;
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
  private double coordX;
  private double coordY;
  private double coordXDeriv;
  private double coordYDeriv;
  private double bezierTangenteX;
  private double bezierTangenteY;
  //private List<Coordonnee> listPoint2;

    public Courbe() {
        listPoint = new ArrayList<Coordonnee>();
    }
  
  
  public Courbe(List<Coordonnee> listPoint) {
    this.listPoint = listPoint;
    //this.listPoint2 = listPoint2;
  }

  
    public void setRandomCourbe(Coordonnee beginning){
        Random rand = new Random();
        listPoint.add(new Coordonnee(beginning.getX()+(Oiseau.BIRD_BODY_RADIUS/2), beginning.getY())); // Premier point
        listPoint.add(new Coordonnee(rand.nextInt(20)+50, rand.nextInt(20)+120)); // Deuxieme point
        listPoint.add(new Coordonnee(rand.nextInt(50)+500, rand.nextInt(50)+100)); // Troisieme point
        listPoint.add(new Coordonnee(rand.nextInt(50)+550, rand.nextInt(50)+150)); // Quatrieme point
    }

  public Coordonnee calculerPoint(double t) throws PointCourbeException {
    Coordonnee bezier = null;
    Coordonnee bezierDeriv = null;
    try{
     bezier = formulBezier(this.listPoint, t);
     bezierDeriv = formulBezierDeriv(this.listPoint, t);
    } catch (PointCourbeException exception) {
      exception.printStackTrace();
    }
	this.coordX = bezier.getX();
	this.coordY = bezier.getY();
	this.coordXDeriv = bezierDeriv.getX();
	this.coordYDeriv = bezierDeriv.getY();
    return new Coordonnee(coordX, coordY);
  }
  
  public Coordonnee calculerTangente(int index){
    this.bezierTangenteX = this.tangente(this.listPoint.get(index).getX(), this.coordX, this.coordXDeriv);
    this.bezierTangenteY = this.tangente(this.listPoint.get(index).getY(), this.coordY, this.coordYDeriv);
    return new Coordonnee(bezierTangenteX, bezierTangenteY);
  }

  ///////////Non utiliser mais on la garde en cas de problème////////////////////
  /* public double formulBezier(double point1, double point2, double t) {
    return ((1 - t) * point1) + (t * point2);
  }*/


  public Coordonnee formulBezier(List<Coordonnee> listpoint, double t) throws PointCourbeException{
    if (listpoint.size() < 4 || listpoint.isEmpty()) {
      throw new PointCourbeException("Error : List nom conforme.");
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
  
  public Coordonnee formulBezierDeriv(List<Coordonnee> listpoint, double t) throws PointCourbeException{
    if (listpoint.size() < 4 || listpoint.isEmpty()) {
      throw new PointCourbeException("Error : List nom conforme.");
    }
    return new Coordonnee(formuleBezierParamDeriv((listpoint.get(0) == null)? 0.0:listpoint.get(0).getX(), // Pour les X
                                             (listpoint.get(1) == null)? 0.0:listpoint.get(1).getX(),
                                             (listpoint.get(2) == null)? 0.0:listpoint.get(2).getX(),
                                             (listpoint.get(3) == null)? 0.0:listpoint.get(3).getX(),t),
                         (formuleBezierParamDeriv((listpoint.get(0) == null)? 0.0:listpoint.get(0).getY(), // Pour les Y
                                             (listpoint.get(1) == null)? 0.0:listpoint.get(1).getY(),
                                             (listpoint.get(2) == null)? 0.0:listpoint.get(2).getY(),
                                             (listpoint.get(3) == null)? 0.0:listpoint.get(3).getY(),t)));
  }
  
  public double formuleBezierParam(double p0, double p1, double p2, double p3, double t){
    return (p0*Math.pow((1-t), 3)) + (((3*p1)*t)*Math.pow((1-t), 2)) + (((3*p2)*Math.pow(t, 2))*(1-t)) + p3*Math.pow(t, 3);
  }
  
  public double formuleBezierParamDeriv(double p0, double p1, double p2, double p3, double t){
    return 3*(((p1-p0)*Math.pow((1-t), 2)) + (((2*(p2-p1))*t)*(1-t)) + ((p3-p1)*Math.pow(t, 2)));
  }

  public List<Coordonnee> getListPoint() {
    return this.listPoint;
  }

  public void setListPoint(Coordonnee coordonnee) {
    listPoint.add(coordonnee);
  }

  public double tangente(double point, double bezier, double bezierDeriv){
      return (point-bezier)/bezierDeriv;
  }
  
  
  public double getCoordX() {
    return coordX;
  }


  public double getCoordY() {
    return coordY;
  }


  public double getCoordXDeriv() {
    return coordXDeriv;
  }


  public double getCoordYDeriv() {
    return coordYDeriv;
  }


  public double getBezierTangenteX() {
    return bezierTangenteX;
  }
  
  public double getBezierTangenteY() {
    return bezierTangenteY;
  }
}

