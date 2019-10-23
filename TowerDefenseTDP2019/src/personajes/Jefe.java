package personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.EnemigoCerca;

public class Jefe extends EnemigoCerca {
	public Jefe(int x, int y) {
		super(x, y, 700, 12, 2, 100, 100);
		
		spriteMovimiento = new ImageIcon(this.getClass().getResource("/recursos/enemigos/jeve_move.gif"));
		spriteAtaque = new ImageIcon(this.getClass().getResource("/recursos/enemigos/jefeattack.gif"));
		sprite = new JLabel();
		sprite.setIcon(spriteMovimiento);
		sprite.setBounds(this.x, this.y, Gui.spriteSize, Gui.spriteSize);	
		agregarBarraVida();
	}
}