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

	private double coordX;
	private double coordY;
	private double coordXDeriv;
	private double coordYDeriv;
	private int vitesseInitial = 10;
	private int angleInitial = (int) (Constante.PI / 3);
	private double vitesseY = Constante.VITESSE_LANCER;

	////////////////// Calcule vitesses horizontale et verticale ///////////
	/*
	 * private double vitesseX = Math.cos(angleInitial)*vitesseInitial; private
	 * double vitesseY = Math.sin(angleInitial)*vitesseInitial;
	 */

	public Coordonnee calculerPoint(List<Coordonnee> listPoint, double t) {
		return formulBezier(listPoint, t);
	}

	public Coordonnee calculerPointDerive(List<Coordonnee> listPoint, double t) {
		return formulBezierDeriver(listPoint, t);
	}

	public Coordonnee calculerTangente(double x, double y, List<Coordonnee> coordonnees, double t) {
		double xtmp = ((x - calculerPoint(coordonnees, t).getX()) / (calculerPointDerive(coordonnees, t).getX()));
		double ytmp = ((y - calculerPoint(coordonnees, t).getY()) / (calculerPointDerive(coordonnees, t).getY()));
		return new Coordonnee(xtmp, ytmp);
	}

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

	public Coordonnee formulBezierDeriver(List<Coordonnee> point, double t) {
		double x = 0;
		double xtmp = 0;
		double ytmp = 0;
		double y = 0;
		for (int i = point.size() - 1; i > 1; i--) {
			x += formuleBezierDeriveTest(0, point.get(i - 1).getX(), point.get(i).getX(), t, i);
			xtmp = x;
			y += formuleBezierDeriveTest(0, point.get(i - 1).getY(), point.get(i).getY(), t, i);
			ytmp = y;
		}
		return new Coordonnee(xtmp, ytmp);
	}

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

	// 3*(((p1-p0)*Math.pow((1-t), 2)) + (2*(p2-p1)*t*(t-1)) +
	// ((p3-p2)*Math.pow(t, 2)));
	public double formuleBezierDeriveTest(double resultat, double listPoint1, double listePoint2, double t, int size) {
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