/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import Exceptions.PointCourbeException;
import HappyBird.Obstacle;
import HappyBird.Oiseau;
import HappyBird.Plateau;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

/**
 * 
 * @author debaerdm
 */
public class GamePanel extends JPanel implements KeyListener {

	private static final long serialVersionUID = 1L;
	private Plateau plateau;

	public GamePanel() {
		setFocusable(true);
		addKeyListener(this);

		plateau = new Plateau(this);
		// setBackground(Color.BLACK);
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // To change body of generated methods, choose
									// Tools | Templates.
		g.drawImage(new ImageIcon(getClass().getResource("/GUI/images/background.png")).getImage(), 0, 0, null);
		try {
			g.setColor(Color.BLUE);
			for (double i = 0; i < plateau.getOiseau().getTemps(); i += plateau.getOiseau().getSpeed()) {
				g.fillOval((int) plateau.getOiseau().getCourbe().calculerPoint(i).getX(),
						(int) plateau.getOiseau().getCourbe().calculerPoint(i).getY(), 6, 6);
			}
		} catch (PointCourbeException e) {
			e.getMessage();
		}
		g.setColor((plateau.getOiseau().detectionCollision()) ? Oiseau.BIRD_BEAK_COLOR : Oiseau.BIRD_BODY_COLOR);
		g.fillOval((int) plateau.getOiseau().getPosition().getX() - Oiseau.BIRD_BODY_RADIUS / 2,
				(int) plateau.getOiseau().getPosition().getY() - Oiseau.BIRD_BODY_RADIUS / 2, Oiseau.BIRD_BODY_RADIUS,
				Oiseau.BIRD_BODY_RADIUS);
		g.setColor(Color.ORANGE);
		for (int i = 0; i < plateau.getObstacles().size(); i++) {
			g.fillOval((int) plateau.getObstacles().get(i).getX(), (int) plateau.getObstacles().get(i).getY(),
					Obstacle.RADIUS, Obstacle.RADIUS);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyChar() == ' ')
			this.plateau = new Plateau(this);
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	public Plateau getPlateau() {
		return plateau;
	}
}
