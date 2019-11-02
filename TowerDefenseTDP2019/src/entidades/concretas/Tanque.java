package entidades.concretas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.abstractas.EnemigoCerca;

/**
 * Tipo de enemigo que se caracteriza por su gran cantidad de vida.
 *
 */
public class Tanque extends EnemigoCerca {
	
	/**
	 * Crea un tanque en una posición.
	 * @param x - La columna donde se crea el personaje
	 * @param y - La fila donde se crea el personaje
	 */
	public Tanque(int x, int y) {
		super(x, y, 200, 2, 1, 20, 20);
		
		spriteMovimiento = new ImageIcon(this.getClass().getResource("/recursos/enemigos/enemigo03_move.gif"));
		spriteAtaque = new ImageIcon(this.getClass().getResource("/recursos/enemigos/enemigo03_attack.gif"));
		sprite = new JLabel();
		sprite.setIcon(spriteMovimiento);
		sprite.setBounds(this.x, this.y, Gui.spriteSize, Gui.spriteSize);	
		agregarBarraVida();
	}
}
