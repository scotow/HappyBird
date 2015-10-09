package HappyBird;

import java.awt.Color;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Exceptions.PointCourbeException;
import GUI.GamePanel;
import GUI.MainFrame;

public class Oiseau extends Bounds{

	/* Variables */

	GamePanel gamePanel;

	// Coordonnee de l'oiseau.
	private Coordonnee position;


	//Vitesse de deplacement de l
	private double speed = 0.02;
	private double temps = 0;
	private boolean collision = false;

	//Les couleurs de l'oiseau.
        
        private Courbe courbe;
                
        //Constantes.
        public static final Color BIRD_BODY_COLOR = Color.RED;
        public static final Color BIRD_BEAK_COLOR = Color.BLACK;
	
        public static final int BIRD_BODY_RADIUS = 25;
        public static final Coordonnee POSITION_INITIAL = new Coordonnee(10, MainFrame.Y_FRAME-(BIRD_BODY_RADIUS*3));
        //private int height;
	/* Constructeur */

	public Oiseau(GamePanel gamePanel) {
		super(POSITION_INITIAL.getX(), POSITION_INITIAL.getY(), BIRD_BODY_RADIUS);
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
		this.position = POSITION_INITIAL;
		this.speed = 0.01;
		this.temps = 0;
		collision = false;
	}

	/**
	 * Fonction qui fait voller l'oiseau en fonction de sa courbe.
	 */
	public void bouger() {
		Timer refreshTimer = new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				temps += speed;
				try {
					position = courbe.calculerPoint(temps);
					detectionCollision();
				}catch (PointCourbeException ex){
				}finally {
					if(temps >= 3)
						((Timer)e.getSource()).stop();
					gamePanel.repaint();
				}
			}
		});

		refreshTimer.start();
	}
	
	public boolean detectionCollision(){
		if (position.getX() > MainFrame.X_FRAME-300) {
			System.out.println(gamePanel.getPlateau().getObstacles().size());
			for (Obstacle obstacle : gamePanel.getPlateau().getObstacles()) {
				if (obstacle.collision(Oiseau.this)) {
					collision = true;
					try {
						Thread.sleep(200);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					resetPosition();
					courbe.clear();
					courbe.setRandomCourbe(position);
				}
			}
		}
		return collision;
	}
	
	public Coordonnee getPosition(){
            return this.position;
        }

	public Courbe getCourbe(){
            return this.courbe;
        }

	public double getTemps(){
		return this.temps;
	}
	
	public double getSpeed() {
		return speed;
	}

	/**
	 * Fonction qui dessine l'oiseau sur l'écran.
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