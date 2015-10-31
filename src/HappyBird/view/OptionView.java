package HappyBird.view;

import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JDialog;

import HappyBird.Controller.CollisionController;
import HappyBird.Controller.PositionControler;
import HappyBird.model.PlateauModel;

public class OptionView extends ElementView implements Observer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JDialog jDialog;
	private JCheckBox checkBox = new JCheckBox("Configure"); 
	private JCheckBox randomBox = new JCheckBox("Random");
	
	public OptionView(PlateauModel plateauModel, CollisionController collisionController, PositionControler positionControler) {
		super(plateauModel, collisionController, positionControler);
		plateauModel.addObserver(OptionView.this);
		initComponent();
	}
	
	public void initComponent(){
		jDialog = new JDialog();
		jDialog.setSize(new Dimension(450, 300));
		jDialog.setResizable(false);
		jDialog.setModal(true);
		jDialog.setLocationRelativeTo(null);
		checkBox.setMnemonic(KeyEvent.VK_C);
		randomBox.setMnemonic(KeyEvent.VK_E);
		checkBox.setBorder(BorderFactory.createBevelBorder(2));
		checkBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					randomBox.setEnabled(true);
					if (randomBox.isSelected()) {
						random = true;
					}
					else {
						random = false;
					}
				}
				else {
					randomBox.setSelected(false);
					randomBox.setEnabled(false);
				}
			}
		});
		jDialog.add(checkBox);
		jDialog.add(randomBox);
		jDialog.setVisible(true);
	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}
	
	
}