package entidades.concretas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.abstractas.Premio;
import juego.Juego;

/**
 * Tipo de premio que otorga oro al jugador cuando es activado.
 *
 */
public class PremioOro extends Premio {

	/**
	 * Crea el premio en una posición
	 * @param x - La columna donde se crea el objeto
	 * @param y - La fila donde se crea el objeto
	 */
	public PremioOro(int x, int y) {
		super(x, y);
		
		sprite = new JLabel();
		sprite.setIcon(new ImageIcon(this.getClass().getResource("/recursos/objetos/moneda.png")));
		sprite.setBounds(this.x, this.y, Gui.spriteSize, Gui.spriteSize);
		agregarListener();
	}

	protected void activarEffecto() {
		Juego.getJuego().sumarMonedas(100);
	}

}
