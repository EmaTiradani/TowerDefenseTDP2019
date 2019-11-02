package entidades.concretas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.abstractas.Premio;
import juego.Juego;
import visitor.VisitorRestaurador;

/**
 * Tipo de premio que restaura la vida de todos los aliados cuando es activado.
 *
 */
public class PremioRestaurar extends Premio {

	/**
	 * Crea el premio en una posición
	 * @param x - La columna donde se crea el objeto
	 * @param y - La fila donde se crea el objeto
	 */
	public PremioRestaurar(int x, int y) {
		super(x, y);
		miVisitor = new VisitorRestaurador();

		sprite = new JLabel();
		sprite.setIcon(new ImageIcon(this.getClass().getResource("/recursos/objetos/vida.png")));
		sprite.setBounds(this.x, this.y, Gui.spriteSize, Gui.spriteSize);
		agregarListener();
	}

	protected void activarEffecto() {
		Juego.getJuego().visitarEntidades(miVisitor);
	}

}
