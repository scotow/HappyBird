package HappyBird.view.Move;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import HappyBird.Object.Element.Oiseau;
import HappyBird.model.PlateauModel;
import HappyBird.view.ElementView;

/**
 * 
 * @author YannGarbe
 * Gere les deplacements de l'oiseau (drag n drop)
 */

public class GestionDeplacement extends JComponent implements MouseMotionListener, MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PlateauModel model;
	JFrame frame;
	ElementView view;
	
	
	private int deplX;
	private int deplY;
	/**
	 * Ajoute les elements necessaire a la construction du drag n drop
	 * @param oi : l'oiseau
	 * @param frame : la frame
	 * @param view : la vue
	 */
	public void addOiseau(PlateauModel model, JFrame frame, ElementView view) {
		this.model = model;
		this.frame = frame;
		this.view = view;
		frame.addMouseMotionListener(this);
		frame.addMouseListener(this);
		frame.setVisible(true);
		frame.paintComponents(view.getGraphics());
	}
	
	

	public void mouseDragged(MouseEvent e) {
		
		model.getOiseau().detacheoiseau();
		model.getOiseau().setPosition(e.getPoint().getX(), e.getPoint().getY());
		deplX = (int) e.getPoint().getX();
		deplY = (int) e.getPoint().getY();
		view.repaint();
		
		
		
		
		
	}

	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	public void mouseReleased(MouseEvent e) {
		System.out.println(deplX+"()()"+deplY);
		model.repaint();
		
		
		view.getPC().getMouvement().setMouvement(0, 0, 50-deplX, -350+deplY);
		model.getOiseau().LancerOiseau();
		view.getPC().fixeCourbe();
		//view.getPC().fixeOiseau();
		model.setOiseauPosition(50.0, 350.0);
		
		
		view.bouger();
	
		
		
		
		
		
		
	}

}
