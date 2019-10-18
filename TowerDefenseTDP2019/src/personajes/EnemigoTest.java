package personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.EnemigoCerca;

public class EnemigoTest extends EnemigoCerca {

	public EnemigoTest(int x, int y) {
		super(x, y, 20, 4, 2, 4, 10);
		sprite = new JLabel();
		sprite.setIcon(new ImageIcon(this.getClass().getResource("/recursos/enemigos/enemigo03_move.gif")));
		sprite.setBounds(this.x, this.y, Gui.spriteSize, Gui.spriteSize);				
	}
		
}
