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
  public void fixePointBezier() {
    if (!controlPoint(plateauModel.getCompteurListe())) {
      switch (plateauModel.getCompteurListe()) {
        case 0:
          /*plateauModel.addPoint(new Coordonnee(Constante.BIRD_BODY_RADIUS * 2, Constante.Y_FRAME
              - (Constante.BIRD_BODY_RADIUS * 3)));
          plateauModel.addPoint(new Coordonnee(0, 0));
          plateauModel.addPoint(new Coordonnee(0, 0));
          plateauModel.addPoint(new Coordonnee(Constante.X_FRAME + 50, 200));*/
        	System.out.println(v.posXOiseau(1)+" Bonjour "+v.posYOiseau(1));
        	plateauModel.addPoint(new Coordonnee(v.posXOiseau(0),v.posYOiseau(0) ));
  		  plateauModel.addPoint(new Coordonnee(v.posXOiseau(1),v.posYOiseau(1) ));
  		  plateauModel.addPoint(new Coordonnee(v.posXOiseau(2),v.posYOiseau(2) ));
  		  plateauModel.addPoint(new Coordonnee(v.posXOiseau(3),v.posYOiseau(3) ));
          break;
        case 1:
          plateauModel.addPoint(new Coordonnee(Constante.BIRD_BODY_RADIUS * 2, Constante.Y_FRAME
              - (Constante.BIRD_BODY_RADIUS * 3)));
          plateauModel.addPoint(new Coordonnee(200, Constante.Y_FRAME
              - (Constante.BIRD_BODY_RADIUS * 3)));
          plateauModel.addPoint(new Coordonnee(200, 100));
          plateauModel.addPoint(new Coordonnee(-100, 100));
          break;
        case 2:
          plateauModel.addPoint(new Coordonnee(Constante.BIRD_BODY_RADIUS * 2, Constante.Y_FRAME
              - (Constante.BIRD_BODY_RADIUS * 3)));
          plateauModel.addPoint(new Coordonnee(350, 200));
          plateauModel.addPoint(new Coordonnee(200, 200));
          plateauModel.addPoint(new Coordonnee(Constante.X_FRAME + 50, 600));
          break;
        case 3:
          plateauModel.addPoint(new Coordonnee(Constante.BIRD_BODY_RADIUS * 2, Constante.Y_FRAME
              - (Constante.BIRD_BODY_RADIUS * 3)));
          plateauModel.addPoint(new Coordonnee(500, 100));
          plateauModel.addPoint(new Coordonnee(500, 0));
          plateauModel.addPoint(new Coordonnee(-100, 0));
          break;
        case 4:
          plateauModel.addPoint(new Coordonnee(Constante.BIRD_BODY_RADIUS * 2, Constante.Y_FRAME
              - (Constante.BIRD_BODY_RADIUS * 3)));
          plateauModel.addPoint(new Coordonnee(Constante.BIRD_BODY_RADIUS * 6, Constante.Y_FRAME
              - (Constante.BIRD_BODY_RADIUS * 7)));
          plateauModel.addPoint(new Coordonnee(Constante.BIRD_BODY_RADIUS * 10, Constante.Y_FRAME
              - (Constante.BIRD_BODY_RADIUS * 11)));
          plateauModel.addPoint(new Coordonnee(Constante.X_FRAME, 0));
          break;
        case 5:
          plateauModel.addPoint(new Coordonnee(Constante.BIRD_BODY_RADIUS * 2, Constante.Y_FRAME
              - (Constante.BIRD_BODY_RADIUS * 3)));
          plateauModel.addPoint(new Coordonnee(Constante.X_FRAME, Constante.Y_FRAME
              - (Constante.BIRD_BODY_RADIUS * 3)));
          plateauModel.addPoint(new Coordonnee(15, 0));
          plateauModel.addPoint(new Coordonnee(Constante.X_FRAME, 0));
          break;
        case 6:
          plateauModel.addPoint(new Coordonnee(Constante.BIRD_BODY_RADIUS * 2, Constante.Y_FRAME
              - (Constante.BIRD_BODY_RADIUS * 3)));
          plateauModel.addPoint(new Coordonnee(300, Constante.Y_FRAME
              - (Constante.BIRD_BODY_RADIUS * 3)));
          plateauModel.addPoint(new Coordonnee(Constante.BIRD_BODY_RADIUS * 2, Constante.Y_FRAME
              - (Constante.BIRD_BODY_RADIUS * 6)));
          plateauModel.addPoint(new Coordonnee(300, Constante.Y_FRAME
              - (Constante.BIRD_BODY_RADIUS * 9)));
          break;
        case 7:
          plateauModel.addPoint(new Coordonnee(Constante.BIRD_BODY_RADIUS * 2, Constante.Y_FRAME
              - (Constante.BIRD_BODY_RADIUS * 3)));
          plateauModel.addPoint(new Coordonnee(200, Constante.Y_FRAME
              - (Constante.BIRD_BODY_RADIUS * 3)));
          plateauModel.addPoint(new Coordonnee(200, 100));
          plateauModel.addPoint(new Coordonnee(Constante.X_FRAME + 50, 100));
          break;
        case 8:
          plateauModel.addPoint(new Coordonnee(Constante.BIRD_BODY_RADIUS * 2, Constante.Y_FRAME
              - (Constante.BIRD_BODY_RADIUS * 3)));
          plateauModel.addPoint(new Coordonnee(250, 200));
          plateauModel.addPoint(new Coordonnee(400, 100));
          plateauModel.addPoint(new Coordonnee(Constante.X_FRAME + 50, 100));
          break;
        case 9:
          plateauModel.addPoint(new Coordonnee(Constante.BIRD_BODY_RADIUS * 2, Constante.Y_FRAME
              - (Constante.BIRD_BODY_RADIUS * 3)));
          plateauModel.addPoint(new Coordonnee(100, 100));
          plateauModel.addPoint(new Coordonnee(300, 200));
          plateauModel.addPoint(new Coordonnee(Constante.X_FRAME + 50, 500));
          break;
        default:
          plateauModel.addPoint(null);
          plateauModel.addPoint(null);
          plateauModel.addPoint(null);
          plateauModel.addPoint(null);
          break;
      }
    }
  }
  public void fixeCourbe() {
	  if (!controlPoint(plateauModel.getCompteurListe())) {
		  System.out.println(v.posXOiseau(0)+" Bonjour "+v.posYOiseau(0));
		  System.out.println(v.posXOiseau(1)+" Bonsoir "+v.posYOiseau(1));
		 
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
