package entidades.concretas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.abstractas.Aliado;
import entidades.abstractas.Disparo;

/**
 * El aliado más simple y barato. Tiene alcance infinito.
 *
 */
public class TorreBasica extends Aliado {
	
	/**
	 * Crea una torre básica en una posición.
	 * @param x - La columna donde se crea el personaje
	 * @param y - La fila donde se crea el personaje
	 */
	public TorreBasica(int x, int y) {
		super(x, y, 100, 2, 10, 10);
		sprite = new JLabel();
		sprite.setIcon(new ImageIcon(this.getClass().getResource("/recursos/aliados/aliado02.png")));
		sprite.setBounds(this.x, this.y, Gui.spriteSize, Gui.spriteSize);
		agregarBarraVida();
	}

	protected Disparo crearDisparo() {
		return new DisparoBasico(x/Gui.spriteSize, y/Gui.spriteSize, alcance, estado);
	}

}
