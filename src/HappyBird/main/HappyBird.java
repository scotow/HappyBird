package HappyBird.main;

import HappyBird.Controller.CollisionController;
import HappyBird.Controller.PositionControler;
import HappyBird.model.PlateauModel;
import HappyBird.view.HappyView;

public class HappyBird {

	public HappyBird() {
		PlateauModel plateauModel = new PlateauModel();
		CollisionController collisionController = new CollisionController(plateauModel);
		PositionControler controler = new PositionControler(plateauModel);
		HappyView happyView = new HappyView("Happy Bird", plateauModel, collisionController, controler);
		collisionController.addView(happyView); 
		controler.addView(happyView);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new HappyBird();
			}
		});
	}

}
