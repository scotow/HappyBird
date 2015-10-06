package HappyBird;

import java.awt.Color;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Exceptions.PointCourbeException;
import GUI.GamePanel;

public class Oiseau{

	/* Variables */

	GamePanel gamePanel;

	// Coordonnee de l'oiseau.
	private Coordonnee position;


	//Vitesse de deplacement de l
	private double speed = 0.02;
	private double temps = 0;

	//Les couleurs de l'oiseau.
        
        private Courbe courbe;
                
        //Constantes.
        public static final Color BIRD_BODY_COLOR = Color.RED;
        public static final Color BIRD_BEAK_COLOR = Color.BLACK;
	
        public static final int BIRD_BODY_RADIUS = 25;
        //private int height;
	/* Constructeur */

	public Oiseau(GamePanel gamePanel) {
		resetPosition();
		this.gamePanel = gamePanel;
		this.courbe = new Courbe();
		this.courbe.setRandomCourbe(this.position);
	}

	/* Fonction */

	/**
	 * Fonction qui repositionne l'oiseau à sa position initiale et orienté vers
	 * le haut avec une vitesse de 1.
	 */
	public void resetPosition() {
		this.position = new Coordonnee(10, 600-(BIRD_BODY_RADIUS*3));
		this.speed = 0.02;
		this.temps = 0;
	}

	/**
	 * Fonction qui fait voller l'oiseau en fonction de sa courbe.
	 */
	public void bougerOiseau() {
		Timer refreshTimer = new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				temps += speed;
				try {
					position = courbe.calculerPoint(temps);
				}catch (PointCourbeException ex){
				}finally {
					if(temps >= 1)
						((Timer)e.getSource()).stop();
					gamePanel.repaint();
				}
			}
		});

		refreshTimer.start();
	}

	public Coordonnee getPosition(){
            return this.position;
        }

	public Courbe getCourbe(){
            return this.courbe;
        }

	/**
	 * Fonction qui dessine l'oiseau sur l ecran
	 * 
	 * @param g
	 *            le moteur graphique
	 */
//	public void paintComponent(Graphics g) {
//		g.setColor(Color.RED);
//		//g2d.fillRect(posX, posY, 8, 8);
//		g.fillOval(position.getX(), position.getY(), 25, 25);
//		g.setColor(Color.BLACK);
//		g.fillArc(this.x+20,this.y-5,20,35,170,20);  /*Fonction du fillArc (position X, position Y, */
//	}
        
        
}