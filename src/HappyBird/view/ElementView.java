package HappyBird.view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;

import HappyBird.Controller.CollisionControler;
import HappyBird.Controller.PositionControler;
import HappyBird.Object.Constante;
import HappyBird.model.PlateauModel;

public class ElementView extends ObjectView {

  /**
   * Concerne l'affichage des elements, herite de la vue objet
   */
  private static final long serialVersionUID = 1L;

  /**
   * Cree la vue element et place des point de bezier puis fixe les obstacles et d�marre l'animation
   * 
   * @param plateauModel : le plateau de jeu
   * @param collisionControler : le controleur de collision
   * @param positionControler : le controler de position
   */
  public ElementView(PlateauModel plateauModel, CollisionControler collisionControler,
      PositionControler positionControler) {
    super(plateauModel, collisionControler, positionControler);
    random = true;
    positionControler.fixePointBezier();
    positionControler.fixeObstacles((random) ? 0 : clickPut().getX(), (random) ? 0 : clickPut()
        .getY(), random);
    bouger();
  }

  @Override
  public void update(Observable o, Object arg) {
    ElementView.this.repaint();
  }

  /**
   * Affiche les differents objets
   */
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    for (int i = 0; i < model().getListeDObstacles().size(); i++) {
      g.setColor(model().getObstaclesColor(i));
      g.fillOval((int) model().getObstaclePostion(i).getX() - model().getObstacleTaille(i)[0] / 2,
          (int) model().getObstaclePostion(i).getY() - model().getObstacleTaille(i)[1] / 2, model()
              .getObstacleTaille(i)[0], model().getObstacleTaille(i)[1]);
    }
    g.setColor(Constante.POINT_BEZIER);

    /*
     * for (int i = 0; i < model().getListeDePoint().size(); i++) { g.fillOval((int)
     * model().getPoint(i).getX(), (int) model().getPoint(i).getY(), 15, 15); if (i >= 1) {
     * g.drawLine((int) model().getPoint(i - 1).getX() + 15 / 2, (int) model().getPoint(i - 1)
     * .getY() + 15 / 2, (int) model().getPoint(i).getX() + 15 / 2, (int) model().getPoint(i)
     * .getY() + 15 / 2); } }
     */

    for (int i = 0; i < model().getRectangles().size(); i++) {
      if (i % 80 == 0) {
        g.fillRect(model().getRectangleByIndex(i).x, model().getRectangleByIndex(i).y, model()
            .getRectangleByIndex(i).width, model().getRectangleByIndex(i).height);
      }
    }
    g.setColor(model().getBecOiseauColor());
    /*-------Attention, tout ce qui suit deviendra inutine par la suite---*/
    DessinerBec(g, (int) model().getOiseauPostion().getX(), (int) model().getOiseauPostion().getY());
    g.setColor(model().getOiseauColor());
    g.fillOval((int) model().getOiseauPostion().getX() - model().getOiseauTaille()[0] / 2,
        (int) model().getOiseauPostion().getY() - model().getOiseauTaille()[1] / 2, model()
            .getOiseauTaille()[0], model().getOiseauTaille()[1]);  
  }
  
  public double AngleX (int x, int dx) {
		double nb;
		nb = dx-x;
		
		if (nb == 0) {
			return 0.00;
		} else {
			return nb;
		}
	}
	//si bas-gauche, difx = 5 | dify = 5, (5/5)/2
	
	public double AngleY (int y, int dy) {
		int nb;
		nb = dy-y;
		if (nb == 0) {
			return 0.00;
		} else {
			return nb;
		}
	}

  public void DessinerBec(Graphics g, int dx, int dy) {
	//Coordonnee tmp = this.model.getCourbe().calculerTangente(dx, dy, this.model.getListeDePoint(), this.model.getT());
	int tmpX, tmpY;
	if (this.model.getRectangles().size() == 0) {
		tmpX = 0;
		tmpY = 0;
	}	else if (this.model.getRectangles().size() <= 10) {
		tmpX = this.model.getRectangleByIndex(this.model.getRectangles().size()-1).x;
		tmpY = this.model.getRectangleByIndex(this.model.getRectangles().size()-1).y;
	} else {
		tmpX = this.model.getRectangleByIndex(this.model.getRectangles().size()-10).x;
		tmpY = this.model.getRectangleByIndex(this.model.getRectangles().size()-10).y;
	}
	double autreX = AngleX( tmpX, dx);
	double autreY = AngleY( tmpY, dy);

	//---------------------------------------------------------
	//System.out.println(autreX/autreY);
	//---------------------------------------------------------
	
	int posX = (int) (dx+((autreX*3)%15));
	
	//---------------------------------------------------------
	//System.out.println(""+autreX+" || "+(int)((double)40*arcX));
	//--------------------------------------------------------
	
	int posY = (int) (dy+((autreY*3)%15));
	
	//----------------------------------------------------------
	//System.out.println(""+autreY+" || "+(int)((double)40*arcY));
	//----------------------------------------------------------
	//si dify = 0, 160 (180-20)|| si difx = 0,(90-20) || si difx = 0.5 et dify = 0.5, (135-20)
	//g.fillArc(posX,posY,50,50,(int)(360-(180*arcX)-(270*arcY))-20,40);
	
	g.fillArc(posX- model().getOiseauTaille()[0] / 2 + 20,posY - model().getOiseauTaille()[1] / 2 ,25,25,160,40);
	}
}
