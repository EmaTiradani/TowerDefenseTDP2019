package entidades.concretas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.abstractas.Aliado;
import entidades.abstractas.Disparo;

/**
 * Tipo de torre que se caracteriza por la velocidad de sus disparos. *
 */
public class TorreRapida extends Aliado {

	/**
	 * Crea una torre rapida en una posición.
	 * @param x - La columna donde se crea el personaje
	 * @param y - La fila donde se crea el personaje
	 */
	public TorreRapida(int x, int y) {
		super(x, y, 100, 1, 4, 30);
		sprite = new JLabel();
		sprite.setIcon(new ImageIcon(this.getClass().getResource("/recursos/aliados/aliado03.png")));
		sprite.setBounds(this.x, this.y, Gui.spriteSize, Gui.spriteSize);
		agregarBarraVida();
		agregarVendibleListener();
	}

	protected Disparo crearDisparo() {
		return new DisparoRapido(x/Gui.spriteSize, y/Gui.spriteSize, alcance, estado);
	}

}
