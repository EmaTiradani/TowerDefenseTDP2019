package personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.EnemigoCerca;

public class EnemigoTest extends EnemigoCerca {

	public EnemigoTest(int x, int y) {
		super(x, y, 50, 4, 2, 5, 10);
		sprite = new JLabel();
		sprite.setIcon(new ImageIcon(this.getClass().getResource("/recursos/goblin.png")));
		sprite.setBounds(this.x, this.y, Gui.spriteSize, Gui.spriteSize);				
	}
		
}
