package entidades.concretas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.abstractas.Disparo;
import entidades.abstractas.EnemigoDistancia;

/**
 * Representa un arquero que puede atacar a distancia.
 *
 */
public class Arquero extends EnemigoDistancia {

	/**
	 * Crea un arquero en una posición.
	 * @param x - La columna donde se crea el personaje
	 * @param y - La fila donde se crea el personaje
	 */
	public Arquero(int x, int y) {
		super(x, y, 50, 2, 10, 3, 15);
		
		spriteMovimiento = new ImageIcon(this.getClass().getResource("/recursos/enemigos/arquero.gif"));
		spriteAtaque = new ImageIcon(this.getClass().getResource("/recursos/enemigos/disparoarquero.gif"));
		sprite = new JLabel();
		sprite.setIcon(spriteMovimiento);
		sprite.setBounds(this.x, this.y, Gui.spriteSize, Gui.spriteSize);
		agregarBarraVida();
	}

	protected Disparo crearDisparo() {
		return new DisparoArquero(x/Gui.spriteSize, y/Gui.spriteSize, alcance, estado);
	}

}
