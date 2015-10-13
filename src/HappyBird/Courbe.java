package HappyBird;
import Exceptions.PointCourbeException;
import GUI.MainFrame;
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

    public Courbe() {
        listPoint = new ArrayList<>();
        listePointTangente = new ArrayList<>();
    }
  
  
  public Courbe(List<Coordonnee> listPoint) {
    this.listPoint = listPoint;
  }

  
    public void setRandomCourbe(Coordonnee beginning){
        Random rand = new Random();
        listPoint.add(new Coordonnee(beginning.getX(), beginning.getY())); // Premier point
        listPoint.add(new Coordonnee(rand.nextInt(50)+MainFrame.X_FRAME/5, rand.nextInt(100)+MainFrame.Y_FRAME/4)); // Deuxieme point
        listPoint.add(new Coordonnee(rand.nextInt(50)+MainFrame.X_FRAME-150, rand.nextInt(100)+MainFrame.Y_FRAME/5)); // Troisieme point0
        listPoint.add(new Coordonnee(MainFrame.X_FRAME, rand.nextInt(100)+MainFrame.Y_FRAME/4)); // Quatrieme point
    }

  public Coordonnee calculerPoint(double t) throws PointCourbeException {
    Coordonnee bezier = null;
    try{
     bezier = formulBezier(this.listPoint, t);
    } catch (PointCourbeException exception) {
        exception.getMessage();
    }
    listePointTangente.add(bezier);
    return bezier;
  }

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
  
  public double formuleBezierParam(double p0, double p1, double p2, double p3, double t){
    return (p0*Math.pow((1-t), 3)) + (((3*p1)*t)*Math.pow((1-t), 2)) + (((3*p2)*Math.pow(t, 2))*(1-t)) + p3*Math.pow(t, 3);
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
    
    public boolean clearList(){
        boolean clear = false;
        listPoint.clear();
        if (listPoint.isEmpty()) {
            clear = true;
        }
        return clear;
    }
  
  
}