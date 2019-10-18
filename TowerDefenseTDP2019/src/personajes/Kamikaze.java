package personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import entidades.EnemigoCerca;
import GUI.Gui;

public class Kamikaze extends EnemigoCerca {
	public Kamikaze(int x, int y) {
		super(x, y, 1, 40, 2, 60, 5);
		sprite = new JLabel();
		sprite.setIcon(new ImageIcon(this.getClass().getResource("/recursos/goblin.png")));
		sprite.setBounds(this.x, this.y, Gui.spriteSize, Gui.spriteSize);				
	}
}
