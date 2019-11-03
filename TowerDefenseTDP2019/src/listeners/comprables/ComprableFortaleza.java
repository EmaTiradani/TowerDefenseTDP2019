package listeners.comprables;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.abstractas.Entidad;
import entidades.concretas.Fortaleza;

/**
 * Listener asociado con el aliado Fortaleza.
 *
 */
public class ComprableFortaleza extends ComprableMotionListener {

	/**
	 * Crea un listener.
	 * @param gui - La interfaz gráfica
	 */
	public ComprableFortaleza(Gui gui) {
		super(gui);
		sprite = new JLabel(new ImageIcon(this.getClass().getResource("/recursos/aliados/aliado04.png")));
		sprite.setVisible(false);
		gui.getContentPane().add(sprite, 0);
	}

	protected Entidad crearEntidad(int x, int y) {
		return new Fortaleza(x, y);
	}

}
