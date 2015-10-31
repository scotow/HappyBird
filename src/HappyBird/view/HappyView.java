package HappyBird.view;

import javax.swing.JFrame;
import HappyBird.Controller.CollisionController;
import HappyBird.Controller.PositionControler;
import HappyBird.Object.Constante;
import HappyBird.model.PlateauModel;

public class HappyView {
	
	protected PlateauModel plateauModel;
	protected CollisionController collisionController;
	protected PositionControler controler;
	private ElementView elementView;
	private JFrame jFrame;
	
	public HappyView(String label, PlateauModel plateauModel, CollisionController collisionController, PositionControler positionControler) {
		this.plateauModel = plateauModel;
		this.collisionController = collisionController;
		this.controler = positionControler;
		this.elementView = new ElementView(plateauModel, collisionController, positionControler);
		jFrame = new JFrame(label);
		jFrame.add(elementView);
		jFrame.setSize(Constante.X_FRAME, Constante.Y_FRAME);
		jFrame.setResizable(false);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setVisible(true);
	  }
	

}
