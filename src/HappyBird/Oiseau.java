package HappyBird;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Oiseau{

	/* Variables */

	// Coordonnee de l'oiseau.
	private Coordonnee position;


	//Vitesse de deplacement de l
	private int speed = 1;

	//Les couleurs de l'oiseau.
                
        //Constantes.
        public static final Color BIRD_BODY_COLOR = Color.RED;
        public static final Color BIRD_BEAK_COLOR = Color.BLACK;
	
        public static final int BIRD_BODY_RADIUS = 25;
        private int height;
	/* Constructeur */

	public Oiseau(int height) {
                this.height = height;
		resetPosition();
	}

	/* Fonction */

	/**
	 * Fonction qui repositionne l'oiseau à sa position initiale et orienté vers
	 * le haut avec une vitesse de 1.
	 */
	public void resetPosition() {
		this.position = new Coordonnee(10, this.height-(BIRD_BODY_RADIUS*3));
                this.speed = 1;
	}

	/**
	 * Fonctionne qui met àà jour la position de l'oiseau suivant sa vitesse 
	 */
	public void bougerBalle() {
		this.position.ajout(speed, speed);
	}
        
        public Coordonnee getPosition(){
            return this.position;
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