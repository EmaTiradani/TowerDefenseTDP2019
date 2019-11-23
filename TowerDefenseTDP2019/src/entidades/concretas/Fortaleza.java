package entidades.concretas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.abstractas.Aliado;
import entidades.abstractas.Disparo;

/**
 * Tipo de aliado con poco alcance y mucha defensa.
 *
 */
public class Fortaleza extends Aliado {

	/**
	 * Crea una fortaleza en una posición.
	 * @param x - La columna donde se crea el personaje
	 * @param y - La fila donde se crea el personaje
	 */
	public Fortaleza(int x, int y) {
		super(x, y, 150, 2, 2, 30);
		sprite = new JLabel();
		sprite.setIcon(new ImageIcon(this.getClass().getResource("/recursos/aliados/aliado04.png")));
		sprite.setBounds(this.x, this.y, Gui.spriteSize, Gui.spriteSize);
		agregarBarraVida();
		agregarVendibleListener();
	}

	protected Disparo crearDisparo() {
		return new DisparoFortaleza(x/Gui.spriteSize, y/Gui.spriteSize, alcance, estado);
	}

}
