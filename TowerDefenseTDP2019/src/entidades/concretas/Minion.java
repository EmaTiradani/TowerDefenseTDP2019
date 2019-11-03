package entidades.concretas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.abstractas.EnemigoCerca;

/**
 * El tipo de enemigo m�s d�bil, pero tambi�n el m�s r�pido.
 *
 */
public class Minion extends EnemigoCerca {
	
	/**
	 * Crea un minion en una posici�n.
	 * @param x - La columna donde se crea el personaje
	 * @param y - La fila donde se crea el personaje
	 */
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
