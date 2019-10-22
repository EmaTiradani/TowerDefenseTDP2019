package personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.EnemigoCerca;

public class Minion extends EnemigoCerca {
	public Minion(int x, int y) {
		super(x, y, 25, 12, 1, 10, 5);
		
		spriteMovimiento = new ImageIcon(this.getClass().getResource("/recursos/enemigos/enemigo01_move.gif"));
		spriteAtaque = new ImageIcon(this.getClass().getResource("/recursos/enemigos/enemigo01_attack.gif"));
		sprite = new JLabel();
		sprite.setIcon(spriteMovimiento);
		sprite.setBounds(this.x, this.y, Gui.spriteSize, Gui.spriteSize);		
		agregarBarraVida();
	}
}
