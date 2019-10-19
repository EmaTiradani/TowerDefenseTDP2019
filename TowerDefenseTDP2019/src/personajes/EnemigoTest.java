package personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.EnemigoCerca;

public class EnemigoTest extends EnemigoCerca {

	public EnemigoTest(int x, int y) {
		super(x, y, 200, 4, 2, 4, 10);
		
		spriteMovimiento = new ImageIcon(this.getClass().getResource("/recursos/enemigos/enemigo03_move.gif"));
		spriteAtaque = new ImageIcon(this.getClass().getResource("/recursos/enemigos/enemigo03_attack.gif"));
		sprite = new JLabel();
		sprite.setIcon(spriteMovimiento);
		sprite.setBounds(this.x, this.y, Gui.spriteSize, Gui.spriteSize);				
	}
		
}
