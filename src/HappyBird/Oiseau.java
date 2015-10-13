package HappyBird;

import java.awt.Color;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Exceptions.PointCourbeException;
import GUI.GamePanel;
import GUI.MainFrame;

/**
 * 
 * @author 
 *L'oiseau, objet essentiel dans le jeu
 */
public class Oiseau{

	/* Variables */

	private final GamePanel gamePanel;
	private final Plateau plateau;

	// Coordonnee de l'oiseau.
	private Coordonnee position;

	private Timer flyTimer;


	//Vitesse de deplacement de l'oiseau
	private double speed;
	private double temps;

	//Les couleurs de l'oiseau.

	private Courbe courbe;

	//Constantes.
	public static final Color BIRD_BODY_COLOR = Color.RED;
	public static final Color BIRD_BEAK_COLOR = Color.BLACK;

	public static final int BIRD_BODY_RADIUS = 25;
	//private int height;
	/* Constructeur */

	public Oiseau(GamePanel gamePanel, Plateau plateau) {
		resetPosition();
		this.gamePanel = gamePanel;
		this.plateau = plateau;
		this.courbe = new Courbe();
		this.courbe.setRandomCourbe(this.position);
	}

	/* Fonction */

	/**
	 * Fonction qui repositionne l'oiseau à sa position initiale et orienté vers
	 * le haut avec une vitesse de 1.
	 */
	public void resetPosition() {
		this.position = new Coordonnee(BIRD_BODY_RADIUS*2, MainFrame.Y_FRAME-(BIRD_BODY_RADIUS*3));
		this.speed = 0.02;
		this.temps = 0;
		if(flyTimer != null)
			if(flyTimer.isRunning())
				flyTimer.stop();
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
					position = courbe.calculerPoint(temps);
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
	/**
	 * Stop l'oiseau
	 */
	public void stopFly(){this.flyTimer.stop();}

	/**
	 * Donne les coordonnees de l'oiseau
	 * @return les coordonnees de l'oiseau
	 */
	public Coordonnee getPosition(){
            return this.position;
        }

	/**
	 * Donne la courbe de l'oiseau
	 * @return la courbe de l'oiseau
	 */
	public Courbe getCourbe(){
            return this.courbe;
        }

	/**
	 * Donne le temps de l'oiseau
	 * @return le temps de l'oiseau
	 */
	public double getTemps(){
		return this.temps;
	}
	/**
	 * Donne la vitesse de l'oiseau
	 * @return la vitesse de l'oiseau
	 */
	public double getSpeed(){
		return this.speed;
	}


        
        
}