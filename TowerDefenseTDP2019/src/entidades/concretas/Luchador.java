package entidades.concretas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.abstractas.EnemigoCerca;

/**
 * Crea un enemigo normal con daño y vida promedio.
 *
 */
public class Luchador extends EnemigoCerca {
	
	/**
	 * Crea un luchador en una posición.
	 * @param x - La columna donde se crea el personaje
	 * @param y - La fila donde se crea el personaje
	 */
	public Luchador(int x, int y) {
		super(x, y, 150, 2, 2, 10, 10);
		
		spriteMovimiento = new ImageIcon(this.getClass().getResource("/recursos/enemigos/enemigo02_move.gif"));
		spriteAtaque = new ImageIcon(this.getClass().getResource("/recursos/enemigos/enemigo02_attack.gif"));
		sprite = new JLabel();
		sprite.setIcon(spriteMovimiento);
		sprite.setBounds(this.x, this.y, Gui.spriteSize, Gui.spriteSize);	
		agregarBarraVida();
	}
}
