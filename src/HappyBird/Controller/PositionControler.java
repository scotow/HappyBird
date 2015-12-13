package HappyBird.Controller;

import java.util.Random;

import HappyBird.Object.Config.Constante;
import HappyBird.Object.Config.Coordonnee;
import HappyBird.Object.Element.Obstacle;
import HappyBird.model.PlateauModel;
import HappyBird.view.HappyView;
import HappyBird.view.Move.Mouvement;

public class PositionControler {

  /**
   * Concerne tous les controles de positionnement (notamment pour le lancement du processus)
   */

  private PlateauModel plateauModel;
  private Mouvement v;
  private HappyView happyView = null;


  /**
   * Cree un Controleur de position
   * 
   * @param plateauModel le plateau de jeu
   */
  public PositionControler(PlateauModel plateauModel) {
    this.plateauModel = plateauModel;
    this.v = new Mouvement ((int)(plateauModel.getOiseauPostion().getX()), (int)(plateauModel.getOiseauPostion().getY()),
    		25,50);
    
  }

  /**
   * Permet de placer des coordonnees pour la trajectoire de l'oiseau
   * 
   */
  
  public void fixeCourbe() {
	  if (!controlPoint(plateauModel.getCompteurListe())) {
		  //System.out.println(v.posXOiseau(0)+" Bonjour "+v.posYOiseau(0));
		  //System.out.println(v.posXOiseau(1)+" Bonsoir "+v.posYOiseau(1));
		 
		  for(int i = 0 ; i< 4 ;i++) {
			  plateauModel.addPoint(new Coordonnee(v.posXOiseau(i),v.posYOiseau(i) ));
		  }
	  }
  }
  
  
  /**
   * Permet de placer les obstacles, de facon aleatoire ou non
   * 
   * @param x : le positionnement en x s'il n'est pas aleatoire
   * @param y : le positionnement en y s'il n'est pas aleatoire
   * @param random : decide si l'obstacle est aleatoire ou non
   */
  public void fixeObstacles(double x, double y, boolean random) {
    if (random) {
      for (int i = 0; i < Constante.OBSTACLES_LIST_CAPACITY; i++) {
        Random rand = new Random();
        int radiusX = rand.nextInt(10)+20;
        int radiusY = rand.nextInt(10)+20;
        String type = Constante.FORME[rand.nextInt(2)];
        Obstacle tmp =
            new Obstacle(rand.nextInt(Constante.X_FRAME / 3) + Constante.X_FRAME / 3 * 2 - 20,
                rand.nextInt(Constante.Y_FRAME / 2)+(radiusY), radiusX,(type.toLowerCase().equals("cercle")) ? radiusX: radiusY, type);
        boolean valuable = true;
        for (Obstacle j : plateauModel.getListeDObstacles()) {
          if (Math.abs(tmp.getPositionX() - j.getPositionX()) <= j.getWidth() * 2
              && Math.abs(tmp.getPositionY() - j.getPositionY()) <= j.getHeight() * 2) {
            i--;
            valuable = false;
            break;
          }
        }
        if (valuable) {
          plateauModel.addObstacles(tmp);
          // System.out.println("Obstacle placer a ("+tmp.getPositionX()+";"+tmp.getPositionY()+").");
        }
      }
    } else {
      if (controlObstacle(x, y)) {
        plateauModel.addObstacles(new Obstacle(x, y,Constante.OBSTACLE_RADIUS,Constante.OBSTACLE_RADIUS,"cercle"));
        // System.out.println("Obstacle placer a ("+x+";"+y+").");
      }
    }
  }

  /**
   * Permet fixer la position de l'oiseau
   */
  public void fixeOiseau() {
    Coordonnee tmp =
        plateauModel.getCourbe().calculerPoint(plateauModel.getListeDePoint(), plateauModel.getT());
    Coordonnee tmp2 = plateauModel.getListeDePoint().get(plateauModel.getTemps());
	  
   // System.out.println("plateauModel  "+ plateauModel.getListeDePoint().get(1).toString() +". "+plateauModel.getTemps());
	  plateauModel.setOiseauPosition(tmp.getX()+50, tmp.getY() + 350);
	  	
	  	//plateauModel.setOiseauPosition(75+v.posXOiseau(plateauModel.getTemps()), 350+v.posYOiseau(plateauModel.getTemps()));
	  //System.out.println(plateauModel.getT());
	 
	  
  }

  /**
   * Teste si la liste et les coordonnees du point sont correctes
   * 
   * @param x : la position x du point de bezier
   * @param y : la position y du point de bezier
   * @return vrai si correctes, faux si incorrectes
   */
  public boolean controlPoint(double x, double y) {
    boolean ok = false;
    if (happyView != null) {
      if (plateauModel.getListeDePoint().size() < Constante.POINT_LIST_CAPACITY) {
        if ((x < Constante.X_FRAME && x > 0) && (y < Constante.Y_FRAME && y > 0)) {
          ok = true;
        }
      }
    }
    return ok;
  }

  /**
   * Regarde si on est pas en-dessous de 0 ou au-dessus de 10
   * 
   * @param compteur le compteur de toutes les listes de point
   * @return vrai si la liste est out of bounds.
   */
  public boolean controlPoint(int compteur) {
    boolean ok = false;
    if (happyView != null) {
      if (compteur < 0 || compteur > 9) {
        ok = true;
      }
    }
    return ok;
  }

  /**
   * Teste si la liste et les coordonnees de l'obstacle sont correctes
   * 
   * @param x : la position x de l'obstacle
   * @param y : la position y de l'obstacle
   * @return vrai si correctes, faux si incorrectes
   */
  public boolean controlObstacle(double x, double y) {
    boolean ok = false;
    if (happyView != null) {
      if (plateauModel.getListeDObstacles().size() < Constante.OBSTACLES_LIST_CAPACITY) {
        if ((x < Constante.X_FRAME && x > 0) && (y < Constante.Y_FRAME && y > 0)) {
          ok = true;
        }
      }
    }
    return ok;
  }

  /**
   * Ajoute la vue du jeu dans le controleur
   * 
   * @param happyView : la vue du jeu
   */
  public void addView(HappyView happyView) {
    this.happyView = happyView;
  }
  
  public Mouvement getMouvement() {
	  return v;
  }
}
