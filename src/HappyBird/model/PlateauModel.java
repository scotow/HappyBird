package HappyBird.model;

import java.awt.Color;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javax.swing.Timer;

import HappyBird.Object.*;

/**
 * Concerne tout les objets du plateau de vue
 * 
 * @author debaerdm
 *
 */
public class PlateauModel extends Observable {

  /**
   * Le plateau de jeu (qui est un observable appelant chaque observeur apres une modification)
   */

  private int compteurListe = 0;
  private List<Coordonnee> ListeDePoint = new ArrayList<>(Constante.POINT_LIST_CAPACITY);
  private List<Obstacle> ListeDObstacles = new ArrayList<>(Constante.OBSTACLES_LIST_CAPACITY);
  private Oiseau oiseau = new Oiseau(0, 0);
  private Courbe courbe = new Courbe();
  private double t = 0;
  private double speed = 0.0002;
  private int waiting = 1;
  private int simulation = 10;
  private Timer flyTimer;
  private List<Rectangle> rectangles = new ArrayList<>();
  private List<Coordonnee> coordDeriver = new ArrayList<>();

  /**
   * Retourne la liste d'obstacle du plateau
   * 
   * @return la liste d'obstacle du plateau
   */
  public List<Obstacle> getListeDObstacles() {
    return ListeDObstacles;
  }

  /**
   * Retourne l'oiseau du plateau
   * 
   * @return l'oiseau du plateau
   */
  public Oiseau getOiseau() {
    return oiseau;
  }

  /**
   * Retourne la courbe du plateau
   * 
   * @return la courbe du plateau
   */
  public Courbe getCourbe() {
    return courbe;
  }

  /**
   * Retourne la liste de points de bezier du plateau
   * 
   * @return la liste de points de bezier du plateau
   */
  public List<Coordonnee> getListeDePoint() {
    return ListeDePoint;
  }

  /**
   * Cela permet de savoir combien de fois on a regenerer une liste
   * 
   * @return le nombre de liste passer.
   */
  public int getCompteurListe() {
    return compteurListe;
  }

  /**
   * Retourne la liste de rectangle du plateau
   * 
   * @return la liste de rectangle du plateau
   */
  public List<Rectangle> getRectangles() {
    return rectangles;
  }

  /**
   * Retourne la liste des derivees de coordonnees du plateau
   * 
   * @return la liste des derivees de coordonnees du plateau
   */
  public List<Coordonnee> getCoordonneeDerive() {
    return coordDeriver;
  }

  /**
   * Retourne l'obstacle a l'indice "index" de la liste
   * 
   * @param l'indice de la liste d'obstacle
   * @return l'obstacle choisi
   */
  public Obstacle getObstacle(int index) {
    return ListeDObstacles.get(index);
  }

  /**
   * Retourne les coordonnees du point a l'indice "index" de la liste
   * 
   * @param l'indice de la liste de coordonnees de points
   * @return les coordonnees du point choisi
   */
  public Coordonnee getPoint(int index) {
    return ListeDePoint.get(index);
  }

  /**
   * Retourne la position de l'oiseau en coordonnees
   * 
   * @return les coordonnees de l'oiseau
   */
  public Coordonnee getOiseauPostion() {
    return oiseau.getPostionCoordonnee();
  }

  /**
   * 
   * @return la position du bec
   */
  public Coordonnee getBecOiseauPosition() {
    return oiseau.getBecPositionCoordonne();
  }

  /**
   * Change la position du bec de l'oiseau
   * 
   * @param coordonnee
   */
  public void setBecOiseauPosition(Coordonnee coordonnee) {
    oiseau.setBecCoordonnee(coordonnee);
    setChanged();
    notifyObservers();
  }

  /**
   * 
   * @return la couleur du bec
   */
  public Color getBecOiseauColor() {
    return oiseau.getBecColor();
  }

  /**
   * Modifie la couleur de l'oiseau
   * 
   * @param color
   */
  public void setBecOiseauColor(Color color) {
    oiseau.setBecColor(color);
    setChanged();
    notifyObservers();
  }

  /**
   * Fabrique le bec de l'oiseau
   * 
   * @param t La courbe de bezier
   * @param listPoint Les listes de point de bezier
   * @param courbe access a la methode de calculer point.
   * @return un triangle (qui est le bec)
   */
  public void setBecOiseau(double t, List<Coordonnee> listPoint, Courbe courbe) {
    oiseau.setBecPolygon(t, listPoint, courbe);
    setChanged();
    notifyObservers();
  }

  /**
   * 
   * @return Le bec
   */
  public Polygon getBecOiseauPolygon() {
    return oiseau.getBecPolygon();
  }

  /**
   * Retourne les coordonnees de l'obstacle l'indice "index" de la liste
   * 
   * @param l'indice de la liste d'obstacle
   * @return les coordonnees de l'obstacle choisi
   */
  public Coordonnee getObstaclePostion(int index) {
    return ListeDObstacles.get(index).getPostionCoordonnee();
  }

  /**
   * Donne la taille de l'obstacle a un indice donne
   * 
   * @param index
   * @return un tableau de taille [Width,Height].
   */
  public int[] getObstacleTaille(int index) {
    return new int[] {ListeDObstacles.get(index).getWidth(), ListeDObstacles.get(index).getHeight()};
  }

  /**
   * Donne la taille de l'oiseau
   * 
   * @return un tableau de taille [Width,Height].
   */
  public int[] getOiseauTaille() {
    return new int[] {oiseau.getWidth(), oiseau.getHeight()};
  }

  /**
   * Retourne la couleur de l'oiseau
   * 
   * @return la couleur de l'oiseau
   */
  public Color getOiseauColor() {
    return oiseau.getOiseauColor();
  }

  /**
   * Retourne la couleur de l'obstacle l'indice "index" de la liste
   * 
   * @param l'indice de la liste d'obstacle
   * @return la couleur de l'obstacle choisi
   */
  public Color getObstaclesColor(int index) {
    return ListeDObstacles.get(index).getObstacleColor();
  }

  /**
   * Retourne la vitesse de l'oiseau
   * 
   * @return la vitesse de l'oiseau
   */
  public double getSpeed() {
    return speed;
  }

  /**
   * Retourne la valeur t
   * 
   * @return la valeur t
   */
  public double getT() {
    return t;
  }

  /**
   * Retourne la valeur d'attente
   * 
   * @return la valeur d'attente
   */
  public int getWaiting() {
    return waiting;
  }

  /**
   * Retourne la simulation (ce qui va lancer la boucle de simulation)
   * 
   * @return la simulation
   */
  public int getSimulation() {
    return simulation;
  }

  /**
   * Retourne Le timer de vol
   * 
   * @return le timer de vol
   */
  public Timer getFlyTimer() {
    return flyTimer;
  }

  /**
   * Efface les points dans la liste, avertit les observeurs
   */
  public void clearPoint() {
    ListeDePoint.clear();
    setChanged();
    notifyObservers();
  }

  /**
   * Efface les obstacle dans la liste, avertit les obsterveurs
   */
  public void clearObstacles() {
    ListeDObstacles.clear();
    setChanged();
    notifyObservers();
  }

  /**
   * Ajoute un point a la liste de points du plateau
   * 
   * @param coordonnee : les coordonnees du point
   */
  public void addPoint(Coordonnee coordonnee) {
    ListeDePoint.add(coordonnee);
    // System.out.println("Point placer a "+coordonnee.toString()+".");
    setChanged();
    notifyObservers();
  }

  /**
   * Ajoute un rectangle a la liste de rectangles du plateau
   * 
   * @param rectangle : le rectangle a ajouter
   */
  public void addRectangle(Rectangle rectangle) {
    rectangles.add(rectangle);
    setChanged();
    notifyObservers();
  }

  /**
   * Ajoute une derivee de coordonnees dans la liste de coordonnees de derivees
   * 
   * @param coordonnee : la coordonnees de derivee a ajouter
   */
  public void addCoordonneeDerive(Coordonnee coordonnee) {
    coordDeriver.add(coordonnee);
    setChanged();
    notifyObservers();
  }

  /**
   * Retourne le rectangle a l'indice "index" de la liste
   * 
   * @param l'indice de la liste de rectangle
   * @return le rectangle choisi
   */
  public Rectangle getRectangleByIndex(int index) {
    return rectangles.get(index);
  }

  /**
   * Retourne la coordonnees derivee a l'indice "index" de la liste
   * 
   * @param l'indice de la liste de coordonnees derivees
   * @return la coordonnee choisie
   */
  public Coordonnee getCoordonneeDeriveByIndex(int index) {
    return coordDeriver.get(index);
  }

  /**
   * Supprime un point de la liste, avertit les observeurs
   * 
   * @param coordonnee : les coordonnees du point a supprimer
   */
  public void removePoint(Coordonnee coordonnee) {
    ListeDePoint.remove(coordonnee);
    setChanged();
    notifyObservers();
  }

  /**
   * Ajoute un obstacle a la liste
   * 
   * @param obstacle : obstacle a ajouter
   */
  public void addObstacles(Obstacle obstacle) {
    ListeDObstacles.add(obstacle);
    setChanged();
    notifyObservers();
  }

  /**
   * Set la liste suivant pour le voir a l'affichage
   * 
   * @param compteurListe
   */
  public void setCompteurListe(int compteurListe) {
    this.compteurListe = compteurListe;
    setChanged();
    notifyObservers();
  }

  /**
   * Supprime obstacle de la liste, avertit les observeurs
   * 
   * @param obstacle : l'obstacle a supprimer
   */
  public void removeObstacles(Obstacle obstacle) {
    ListeDObstacles.remove(obstacle);
    setChanged();
    notifyObservers();
  }

  /**
   * Modifie la couleur d'un obstacle a l'indice donne, avertit les observeurs
   * 
   * @param color : la couleur choisie
   * @param index : l'indice de la liste d'obstacle
   */
  public void setObstaclesColor(Color color, int index) {
    ListeDObstacles.get(index).setObstacleColor(color);
    setChanged();
    notifyObservers();
  }

  /**
   * Modifie la couleur de l'oiseau, avertit les observeurs
   * 
   * @param color : la couleur choisie
   */
  public void setOiseauColor(Color color) {
    oiseau.setOiseauColor(color);
    setChanged();
    notifyObservers();
  }

  /**
   * Modifie la position de l'oiseau, avertit les observeurs
   * 
   * @param x : la poisition x choisie
   * @param y : la position y choisie
   */
  public void setOiseauPosition(double x, double y) {
    this.oiseau.setPosition(x, y);
    // System.out.println("Oiseau placer a ("+x+";"+y+").");
    setChanged();
    notifyObservers();
  }

  /**
   * Modifie la position d'un obstacle a l'indice donne, avertit les observeurs
   * 
   * @param x : la position x choisie
   * @param y : la position y choisie
   * @param index : l'indice de la liste d'obstacles
   */
  public void setObstaclesPosition(double x, double y, int index) {
    ListeDObstacles.get(index).setPosition(x, y);
    setChanged();
    notifyObservers();
  }

  /**
   * Modifie le timer de vol, avertit les observeurs
   * 
   * @param flyTimer : le flyTimer choisi
   */
  public void setFlyTimer(Timer flyTimer) {
    this.flyTimer = flyTimer;
    setChanged();
    notifyObservers();
  }

  /**
   * Modifie la valeur t, avertit les observeurs
   * 
   * @param t : la nouvelle valeur t
   */
  public void setT(double t) {
    this.t = t;
    setChanged();
    notifyObservers();
  }

  /**
   * Modifie la vitesse de l'oiseau, avertit les observeurs
   * 
   * @param speed : la nouvelle vitesse de l'oiseau
   */
  public void setSpeed(double speed) {
    this.speed = speed;
    setChanged();
    notifyObservers();
  }

  /**
   * Modifie le temps d'attente, avertit les observeurs
   * 
   * @param waiting : le nouveau temps d'attente
   */
  public void setWaiting(int waiting) {
    this.waiting = waiting;
    setChanged();
    notifyObservers();
  }

  /**
   * Modifie la simulation, avertit les observeurs
   * 
   * @param simulation : la nouvelle simulation
   */
  public void setSimulation(int simulation) {
    this.simulation = simulation;
    setChanged();
    notifyObservers();
  }

  /**
   * Empeche l'oiseau de voler, stop le timer de vol, avertit les observeurs
   */
  public void stopFly() {
    this.flyTimer.stop();
    setChanged();
    notifyObservers();
  }

  /**
   * Fait animer les objetcs.
   */
  public void startFly() {
    this.flyTimer.start();
    setChanged();
    notifyObservers();
  }

  /**
   * Efface les rectangles de la liste, avertit les observeurs
   */
  public void clearRectangles() {
    rectangles.clear();
    setChanged();
    notifyObservers();
  }

  /**
   * Efface les coordonnees derivees, avertit les observeurs
   */
  public void clearCoordonneeDerive() {
    coordDeriver.clear();
    setChanged();
    notifyObservers();
  }

}
