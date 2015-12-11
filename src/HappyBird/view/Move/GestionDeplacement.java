package HappyBird.view.Move;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import HappyBird.Object.Element.Oiseau;
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
	Oiseau oi;
	JFrame frame;
	ElementView view;
	
	/**
	 * Ajoute les elements necessaire a la construction du drag n drop
	 * @param oi : l'oiseau
	 * @param frame : la frame
	 * @param view : la vue
	 */
	public void addOiseau(Oiseau oi, JFrame frame, ElementView view) {
		this.oi = oi;
		this.frame = frame;
		this.view = view;
		frame.addMouseMotionListener(this);
		frame.addMouseListener(this);
		frame.setVisible(true);
		frame.paintComponents(view.getGraphics());
	}
	
	

	public void mouseDragged(MouseEvent e) {
		//oi.bonjour = true;
		// TODO Auto-generated method stub
		oi.setX(e.getPoint().getX());
		oi.setY(e.getPoint().getY());
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
		//try {Thread.sleep(200);}catch(InterruptedException e2){}
		view.repaint();
		
		
		
		
		
		
		
	}

}
