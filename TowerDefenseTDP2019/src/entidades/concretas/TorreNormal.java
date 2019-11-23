package entidades.concretas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.abstractas.Aliado;
import entidades.abstractas.Disparo;

/**
 * Tipo de aliado normal, tiene daño, vida y alcance promedio.
 * @author Goinza
 *
 */
public class TorreNormal extends Aliado {

	/**
	 * Crea una torre normal en una posición.
	 * @param x - La columna donde se crea el personaje
	 * @param y - La fila donde se crea el personaje
	 */
	public TorreNormal(int x, int y) {
		super(x, y, 100, 2, 4, 20);
		sprite = new JLabel();
		sprite.setIcon(new ImageIcon(this.getClass().getResource("/recursos/aliados/aliado01.png")));
		sprite.setBounds(this.x, this.y, Gui.spriteSize, Gui.spriteSize);
		agregarBarraVida();
		agregarVendibleListener();
	}

	protected Disparo crearDisparo() {
		return new DisparoNormal(x/Gui.spriteSize, y/Gui.spriteSize, alcance, estado);
	}

}
