package HappyBird.Object.Element;

import java.awt.Color;
import java.awt.Polygon;

import HappyBird.Object.Bounds.CercleBounds;
import HappyBird.Object.Config.Constante;
import HappyBird.Object.Config.Coordonnee;

public class Oiseau extends CercleBounds{

  /**
   * L'objet oiseau, element principal du jeu
   */
  private Bec bec;

  private Color OiseauColor = Constante.BIRD_BODY_COLOR;

  /**
   * Cree l'oiseau avec son positionnement
   * 
   * @param x : positionnement en x
   * @param y : positionnement en y
   */
  public Oiseau(double x, double y) {
	super(x, y, Constante.BIRD_BODY_RADIUS, Constante.BIRD_BODY_RADIUS);
    this.bec = new Bec(new Coordonnee(this.getX(), this.getY()));
  }

  /**
   * Modifie la position de l'oiseau
   * 
   * @param positionX : nouvelle position x
   * @param positionY : nouvelle position y
   */
  public void setPosition(double positionX, double positionY) {
    this.setX(positionX);
    this.setY(positionY);
  }


  public void setBecCoordonnee(double x, double y) {
    this.bec.setPosition(x,y);
  }

  public void setBecColor(Color color) {
    this.bec.setColor(color);
  }

  /**
   * Retourne la position de l'oiseau en coordonnees
   * 
   * @return les coordonnees de l'oiseau
   */
  public Coordonnee getPostionCoordonnee() {
    return new Coordonnee(this.getX(), this.getY());
  }

  public Coordonnee getBecPositionCoordonne() {
    return this.bec.getCoordonnee();
  }

  public Color getBecColor() {
    return this.bec.getColor();
  }

  public void setBecPolygon() {
    bec.setPolygon();
  }

  public Polygon getBecPolygon() {
    return bec.getBec();
  }

  /**
   * Modifie la couleur de l'oiseau
   * 
   * @param oiseauColor : la nouvelle couleur de l'oiseau
   */
  public void setOiseauColor(Color oiseauColor) {
    OiseauColor = oiseauColor;
  }

  /**
   * Retourne la couleur de l'oiseau
   * 
   * @return : la couleur de l'oiseau
   */
  public Color getOiseauColor() {
    return OiseauColor;
  }

}
