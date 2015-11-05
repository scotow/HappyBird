package HappyBird.Object;

import java.awt.Color;
import java.awt.Polygon;
import java.util.List;

import HappyBird.model.Courbe;

/**
 * Correspond au bec de l'oiseau Created by Benjamin on 04/11/15.
 */
public class Bec {

  private Coordonnee coordonnee;
  private Color color = Color.BLACK;
  private Polygon bec;

  public Bec(Coordonnee coordonnee) {
    this.coordonnee = coordonnee;
    this.bec = new Polygon();
  }

  /**
   * Fabrique le bec de l'oiseau
   * 
   * @param t La courbe de bezier
   * @param listPoint Les listes de point de bezier
   * @param courbe access a la methode de calculer point.
   * 
   */
  public void setPolygon(double t, List<Coordonnee> listPoint, Courbe courbe) {
    bec =
        new Polygon(new int[] {(int) (coordonnee.getX() + Math.cos(1 / 2)),
            (int) (coordonnee.getX() - Math.cos(1 / 2)),
            (int) courbe.calculerPoint(listPoint, t).getX() + 25}, new int[] {
            (int) (coordonnee.getY() + Math.sin(1 / 2)),
            (int) (coordonnee.getY() - Math.sin(1 / 2)),
            (int) courbe.calculerPoint(listPoint, t).getY() + 25}, 3);
    System.out.println(Math.cos(Math.PI * (Constante.BIRD_BODY_RADIUS / 2)));
    System.out.println(Math.cos(Math.PI * (Constante.BIRD_BODY_RADIUS / 2)));
    System.out.println(Math.sin(Math.PI * (Constante.BIRD_BODY_RADIUS / 2)));
    System.out.println(Math.sin(Math.PI * (Constante.BIRD_BODY_RADIUS / 2)));
  }

  public Polygon getBec() {
    return bec;
  }

  public Coordonnee getCoordonnee() {
    return coordonnee;
  }

  public void setPosition(Coordonnee coordonnee) {
    this.coordonnee = coordonnee;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public Color getColor() {
    return color;
  }
}
