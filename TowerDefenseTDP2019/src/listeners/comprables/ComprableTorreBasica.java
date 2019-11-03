package listeners.comprables;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.abstractas.Entidad;
import entidades.concretas.TorreBasica;

/**
 * Listener asociado con el aliado TorreBasica
 *
 */
public class ComprableTorreBasica extends ComprableMotionListener {

	/**
	 * Crea un listener.
	 * @param gui - La interfaz gráfica
	 */
	public ComprableTorreBasica(Gui gui) {
		super(gui);
		sprite = new JLabel(new ImageIcon(this.getClass().getResource("/recursos/aliados/aliado02.png")));
		sprite.setVisible(false);
		gui.getContentPane().add(sprite, 0);
	}

	protected Entidad crearEntidad(int x, int y) {
		return new TorreBasica(x, y);
	}

}
