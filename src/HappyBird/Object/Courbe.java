package HappyBird.Object;

import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

/**
 *
 * @author debaerdm
 */
public class Courbe {

  private List<Coordonnee> listePointTangente;
  private double coordX;
  private double coordY;
  private double coordXDeriv;
  private double coordYDeriv;
  private int vitesseInitial = 10;
  private int angleInitial = (int) (Constante.PI/3);
  private double vitesseY = Constante.VITESSE_LANCER;
  
  //////////////////Calcule vitesses horizontale et verticale ///////////
  /*private double vitesseX = Math.cos(angleInitial)*vitesseInitial;
  private double vitesseY = Math.sin(angleInitial)*vitesseInitial;*/

  public Coordonnee calculerPoint(List<Coordonnee> listPoint, double t){
    /*Coordonnee bezier = null;
     bezier = formulBezier(listPoint, t);
    listePointTangente.add(bezier);*/
    return formulBezier(listPoint, t);
  }

  public Coordonnee formulBezier(List<Coordonnee> listpoint, double t){
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

    public List<Coordonnee> getListePointTangente() {
        return listePointTangente;
    }
    
    public int getAngleInitial() {
      return angleInitial;
    }
    
    public int getVitesseInitial() {
      return vitesseInitial;
    }
    
    public double getVitesseY() {
      return vitesseY;
    }
  
  
}