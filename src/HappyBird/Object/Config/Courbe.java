package HappyBird.Object.Config;

import java.awt.Point;
import java.util.List;

import HappyBird.model.PlateauModel;

/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

/**
 * Concerne les courbes de trajectoire (principalement la partie math)
 * 
 * @author debaerdm
 */
public class Courbe {

  private double coordX;
  private double coordY;
  private double coordXDeriv;
  private double coordYDeriv;
  private int vitesseInitial = 10;
  private int angleInitial = (int) (Math.PI / 3);
  private double vitesseY = Constante.VITESSE_LANCER;

  // //////////////// Calcule vitesses horizontale et verticale ///////////
  /*
   * private double vitesseX = Math.cos(angleInitial)*vitesseInitial; private double vitesseY =
   * Math.sin(angleInitial)*vitesseInitial;
   */

  /**
   * Applique la formule de bezier a la liste de points
   * 
   * @param listPoint : la liste de points en coordonnees
   * @param t : valeur de temps t
   * @return : les nouvelles coordonnees
   */
  public Coordonnee calculerPoint(List<Coordonnee> listPoint, double t) {
    // return new Coordonnee(getOiseauPostion().getX()+10,
    // (37.0/20250.0)*Math.pow(getOiseauPostion().getX(),
    // 2)+(-74.0/45.0)*getOiseauPostion().getX()+470);
    return formulBezier(listPoint, t);
  }

  /**
   * Applique la formule de bezier a la liste de points (derive)
   * 
   * @param listPoint : la liste de points en coordonnees
   * @param t : valeur de temps t
   * @return : les nouvelles coordonnees
   */
  public Coordonnee calculerPointDerive(List<Coordonnee> listPoint, double t) {
    return formulBezierDeriver(listPoint, t);
  }

  /**
   * Calcule la tangente et donne ses coordonnees
   * 
   * @param x : le positionnement x actuel
   * @param y : le positionnement y actuel
   * @param coordonnees : liste de coordonnees pour la tangente
   * @param t : la valeur de temps t
   * @return les coordonnees de la tangente
   */
  public Coordonnee calculerTangente(double x, double y, List<Coordonnee> coordonnees, double t) {
    double xtmp =
        ((x - calculerPoint(coordonnees, t).getX()) / (calculerPointDerive(coordonnees, t).getX()));
    double ytmp =
        ((y - calculerPoint(coordonnees, t).getY()) / (calculerPointDerive(coordonnees, t).getY()));
    return new Coordonnee(xtmp, ytmp);
  }

  /**
   * Applique la formule de bezier sur chaque point de la liste donnee
   * 
   * @param listpoint : la liste de point
   * @param t : la valeur de temps t
   * @return : les nouvelles coordonnees
   */
  public Coordonnee formulBezier(List<Coordonnee> listpoint, double t) {
    double x = 0;
    double xtmp = 0;
    double ytmp = 0;
    double y = 0;
    for (int i = listpoint.size(); i > 0; i--) {
      x += formuleBezierTest(0, listpoint.get(i - 1).getX(), t, i);
      xtmp = x;
      y += formuleBezierTest(0, listpoint.get(i - 1).getY(), t, i);
      ytmp = y;
    }
    return new Coordonnee(xtmp, ytmp);
  }

  /**
   * Applique la formule de bezier sur chaque point de la liste donnee (derive)
   * 
   * @param point : la liste de point
   * @param t : la valeur de temps t
   * @return : les nouvelles coordonnees
   */
  public Coordonnee formulBezierDeriver(List<Coordonnee> point, double t) {
	  return new Coordonnee(test(point.get(0).getX(), point.get(1).getX(), point.get(2).getX(), point.get(3).getX(), t),
			  test(point.get(0).getY(), point.get(1).getY(), point.get(2).getY(), point.get(3).getY(), t));
    /*double x = 0;
    double xtmp = 0;
    double ytmp = 0;
    double y = 0;
    for (int i = point.size() - 1; i > 1; i--) {
      x += formuleBezierDeriveTest(0, point.get(i - 1).getX(), point.get(i).getX(), t, i);
      xtmp = x;
      y += formuleBezierDeriveTest(0, point.get(i - 1).getY(), point.get(i).getY(), t, i);
      ytmp = y;
    }
    return new Coordonnee(xtmp, ytmp);*/
  }


  /**
   * Calculs brut sur la formule de beziers
   * 
   * @param resultat : le resultat que l'on cherche
   * @param listPoint : la position du point (x ou y)
   * @param t : la valeur de temps t
   * @param size : taille de la liste de points
   * @return : le resultat
   */
  // (p0*Math.pow((1-t), 3)) + (((3*p1)*t)*Math.pow((1-t), 2)) +
  // (((3*p2)*Math.pow(t, 2))*(1-t)) + p3*Math.pow(t, 3);
  public double formuleBezierTest(double resultat, double listPoint, double t, int size) {
    switch (size) {
      case 4:
        resultat += listPoint * Math.pow(t, 3);
        break;
      case 3:
        resultat += (((3 * listPoint) * Math.pow(t, 2)) * (1 - t));
        break;
      case 2:
        resultat += (((3 * listPoint) * t) * Math.pow((1 - t), 2));
        break;
      case 1:
        resultat += (listPoint * Math.pow((1 - t), 3));
        break;
      default:
        break;
    }

    return resultat;
  }

  /**
   * Calculs brut sur la formule de beziers (derive
   * 
   * @param resultat : le resultat que l'on cherche
   * @param listPoint1 : la premiere valeur du point (x ou y)
   * @param listPoint2 : la deuxieme valeur du point (x ou y)
   * @param t : la valeur de temps t
   * @param size : taille de la liste de points
   * @return : le resultat
   */
  // 3*(((p1-p0)*Math.pow((1-t), 2)) + (2*(p2-p1)*t*(t-1)) +
  // ((p3-p2)*Math.pow(t, 2)));
  public double formuleBezierDeriveTest(double resultat, double listPoint1, double listePoint2,
      double t, int size) {
    switch (size) {
      case 3:
        resultat += ((listePoint2 - listPoint1) * Math.pow(t, 2));
        break;
      case 2:
        resultat += (2 * (listePoint2 - listPoint1) * t * (t - 1));
        break;
      case 1:
        resultat += ((listePoint2 - listPoint1) * Math.pow((1 - t), 2));
        break;
      default:
        break;
    }

    return resultat;
  }
  
  public double test(double p0, double p1, double p2, double p3, double t){
	  return 3*(((p1-p0)*Math.pow((1-t), 2)) + (2*(p2-p1)*t*(t-1)) + ((p3-p2)*Math.pow(t, 2)));
  }
	
  	/*------------------Soit la derivee est mauvaise(ce qui m'etonnerai), soit la formule qui l'est)----------*/
	/*-----------------------------------------------------------------------------------------------------*/
  
  /**
   * Calcule l'orientation du bec
   * @param model : le plateau de jeu
   * @return
   */
  public Point rotatePoint(Point pt, Point center, double angleDeg)
	{
	    double angleRad = (angleDeg/180)*Math.PI;
	    double cosAngle = Math.cos(angleRad );
	    double sinAngle = Math.sin(angleRad );
	    double dx = (pt.x-center.x);
	    double dy = (pt.y-center.y);

	    pt.x = center.x + (int) (dx*cosAngle-dy*sinAngle);
	    pt.y = center.y + (int) (dx*sinAngle+dy*cosAngle);
	    return pt;
	}
   
  /**
   * Donne l'angle voulu du bec en fonction d'un point d'origine
   * @param mX : le centre X de l'oiseau
   * @param mY : le centre Y de l'oiseau
   * @param aX : le centre X de rotation
   * @param aY : le centre Y de rotation
   * @return : l'angle en degree
   */
  public double donnerAngle (int mX, int mY, int aX, int aY) {
		double rep = 0.0;
		
		double coteX = mX-aX;
		double coteY = mY-aY;
		
		//rep = Math.tan(coteY/coteX);
		rep = Math.toDegrees(Math.atan(coteY/coteX));
				//Math.atan2(coteY,coteX);
		//System.out.println("X : "+coteX+" Y : "+coteY+" Angle : "+rep);
		return rep;
	}
  
  
  /**
   * Retourne la coordonnee x de la courbe
   * 
   * @return la coordonnee x
   */
  public double getCoordX() {
    return coordX;
  }

  /**
   * Retourne la coordonnee y de la courbe
   * 
   * @return la coordonne y
   */
  public double getCoordY() {
    return coordY;
  }

  /**
   * Retourne la coordonnee x de la derivee
   * 
   * @return la coordonnee x
   */
  public double getCoordXDeriv() {
    return coordXDeriv;
  }

  /**
   * Retourne la coordonnee y de la derivee
   * 
   * @return la coordonnee y
   */
  public double getCoordYDeriv() {
    return coordYDeriv;
  }

  /**
   * Retourne l'angle initiale en entier (normalement en degres)
   * 
   * @return
   */
  public int getAngleInitial() {
    return angleInitial;
  }

  /**
   * Retourne la vitesse initiale
   * 
   * @return : la vitesse initiale
   */
  public int getVitesseInitial() {
    return vitesseInitial;
  }

  /**
   * Retourne la vitesse de l'axe y
   * 
   * @return la vitesse
   */
  public double getVitesseY() {
    return vitesseY;
  }
  
  

}
