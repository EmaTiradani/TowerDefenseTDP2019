package listeners.comprables;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.abstractas.Entidad;
import entidades.concretas.TorreNormal;

/**
 * Listener asociado con el aliado TorreNormal
 *
 */
public class ComprableTorreNormal extends ComprableMotionListener {

	/**
	 * Crea un listener.
	 * @param gui - La interfaz gráfica
	 */
	public ComprableTorreNormal(Gui gui) {
		super(gui);
		sprite = new JLabel(new ImageIcon(this.getClass().getResource("/recursos/aliados/aliado01.png")));
		sprite.setVisible(false);
		gui.getContentPane().add(sprite, 0);
	}

	protected Entidad crearEntidad(int x, int y) {
		return new TorreNormal(x, y);
	}

}
