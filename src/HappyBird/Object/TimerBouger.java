package HappyBird.Object;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Timer;

import HappyBird.Controller.CollisionController;
import HappyBird.Controller.PositionControler;
import HappyBird.model.PlateauModel;
import HappyBird.view.ObjectView;

public class TimerBouger implements Observer {
	
	
	protected PlateauModel model;
	protected CollisionController collisionController;
	protected PositionControler positionControler;
	private ObjectView objectView;
	
	public TimerBouger(ObjectView objectView, PlateauModel plateauModel, CollisionController collisionController,
			PositionControler positionControler) {
		this.objectView = objectView;
		this.model = plateauModel;
		this.collisionController = collisionController;
		this.positionControler = positionControler;
		plateauModel.addObserver(TimerBouger.this);
	}

	public void bouger() {
		model.setFlyTimer(new Timer((int) model.getSpeed() * 5000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.setT(model.getT() + model.getSpeed());
				positionControler.fixeOiseau();
				model.addRectangle(new Rectangle((int)model.getOiseauPostion().getX(), (int)model.getOiseauPostion().getY(), 5, 5));
				if(collisionController.Collision()){
					model.stopFly();
					objectView.simulationDeVol();
				}
				if (model.getT() >= 1) {
					model.stopFly();
					objectView.simulationDeVol();
				}
				objectView.repaint();
			}
		}));
		model.getFlyTimer().start();
	}

	@Override
	public void update(Observable o, Object arg) {
		objectView.repaint();
		
	}
	
	
}
