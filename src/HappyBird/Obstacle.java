package HappyBird;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;



public class Obstacle extends JPanel{

	/**
	 * 
	 * @author garbey
	 * Il s'agit des trucs bleus qui apparaissent sur l'ecran
	 * 
	 */
	private int x, y, rayon;

	
	/**
	 * Cree un TrucBleu
	 * @param x : la position de x
	 * @param y : la position de y
	 * @param rayon : le rayon du cercle
	 */
	public Obstacle (int x, int y, int rayon) {
		this.x = x;
		this.y = y;
		this.rayon = rayon;
	}

	/**
	 * Affiche le TrucBleu
	 * @param g : le graphique
	 */
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillOval(this.x, this.y, 50, 50);  	
	}
	
	
	
	/*-------------------Les getter-----------------------------*/
	
	/**
	 * Retourne la position x
	 * @return x : la position x du TrucBleu
	 */
	public int getX() {
		return this.x;
	}
	
	/**
	 * Retourne la position y
	 * @return y : la position y du TrucBleu
	 */
	public int getY() {
		return this.y;
	}
	
	/**
	 * Retourne le rayon
	 * @return rayon : le rayon
	 */
	
	public int getRayon() {
		return this.rayon;
	}
}
