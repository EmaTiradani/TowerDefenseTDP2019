package entidades.concretas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.abstractas.EnemigoCerca;

/**
 * El enemigo más fuerte del juego. Tiene mucha vida y realiza mucho daño.
 *
 */
public class Jefe extends EnemigoCerca {
	
	/**
	 * Crea un jefe en una posición.
	 * @param x - La columna donde se crea el personaje
	 * @param y - La fila donde se crea el personaje
	 */
	public Jefe(int x, int y) {
		super(x, y, 400, 10, 4, 50, 150);
		
		spriteMovimiento = new ImageIcon(this.getClass().getResource("/recursos/enemigos/jeve_move.gif"));
		spriteAtaque = new ImageIcon(this.getClass().getResource("/recursos/enemigos/jefeattack.gif"));
		sprite = new JLabel();
		sprite.setIcon(spriteMovimiento);
		sprite.setBounds(this.x, this.y, Gui.spriteSize, Gui.spriteSize);	
		agregarBarraVida();
	}
}