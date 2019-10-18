package personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.EnemigoCerca;

public class Tanque extends EnemigoCerca {
	public Tanque(int x, int y) {
		super(x, y, 200, 2, 2, 2, 20);
		sprite = new JLabel();
		sprite.setIcon(new ImageIcon(this.getClass().getResource("/recursos/golem.gif")));
		sprite.setBounds(this.x, this.y, Gui.spriteSize, Gui.spriteSize);				
	}
}
