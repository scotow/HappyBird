package HappyBird;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Exceptions.PointCourbeException;
import GUI.GamePanel;
import GUI.MainFrame;

public final class Oiseau extends Bounds{

	/* Variables */

	private final GamePanel gamePanel;
	private final Plateau plateau;

	private Timer flyTimer;


	//Vitesse de deplacement de l
	private double speed;
	private double temps;

	private Courbe courbe;

    private boolean touched = false;

	/* Constructeur */
	public Oiseau(GamePanel gamePanel, Plateau plateau) {
	    super(Constante.BIRD_BODY_RADIUS*2, MainFrame.Y_FRAME-(Constante.BIRD_BODY_RADIUS*3),(int) (Constante.BIRD_BODY_RADIUS),(int) (Constante.BIRD_BODY_RADIUS));
		resetPosition();
		this.gamePanel = gamePanel;
		if (plateau.isModeDeveloper()) {
	      setDeveloper(true);
        }
		this.plateau = plateau;
		this.courbe = new Courbe();
                this.plateau.placerObstacles(10);
                this.genererCourbe();
	}
        
        public void genererCourbe(){
            this.courbe.setRandomCourbe(new Coordonnee(this.getX(), this.getY()));
        }

	/* Fonction */

	/**
	 * Fonction qui repositionne l'oiseau à sa position initiale et orienté vers
	 * le haut avec une vitesse de 1.
	 */
	public void resetPosition() {
	    this.setX(Constante.BIRD_BODY_RADIUS*2);
	    this.setY(MainFrame.Y_FRAME-(Constante.BIRD_BODY_RADIUS*3));
        this.setTouched(false);
		this.speed = 0.02;
		this.temps = 0;
		if(flyTimer != null)
			if(flyTimer.isRunning())
				this.stopFly();
	}

	/**
	 * Fonction qui fait voller l'oiseau en fonction de sa courbe.
	 */
	public void bouger() {
		flyTimer = new Timer((int)(speed*5000), new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				temps += speed;
				try {
					setX(courbe.calculerPoint(temps).getX());
					setY(courbe.calculerPoint(temps).getY());
					plateau.checkForColision();
				}catch (PointCourbeException ex){
				}finally {
					if(temps >= 1) {
						flyTimer.stop();
						plateau.simulationDeVol(false);
					}
					gamePanel.repaint();
				}
			}
		});
		flyTimer.start();
	}

	public void stopFly(){this.flyTimer.stop();}

	public Coordonnee getPosition(){
            return new Coordonnee(getX(), getY());
        }

	public Courbe getCourbe(){
            return this.courbe;
        }

	public double getTemps(){
            return this.temps;
	}

	public double getSpeed(){
            return this.speed;
	}   

    public boolean isTouched() {
        return touched;
    }

    public void setTouched(boolean touched) {
        this.touched = touched;
    }
        
        
        
}