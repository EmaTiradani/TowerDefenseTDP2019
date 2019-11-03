package listeners.comprables;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.abstractas.Entidad;
import entidades.concretas.Bomba;

/**
 * Listener asociado con la entidad Bomba.
 *
 */
public class ComprableBomba extends ComprableMotionListener {

	/**
	 * Crea un listener.
	 * @param gui - La interfaz gráfica
	 */
	public ComprableBomba(Gui gui) {
		super(gui);
		sprite = new JLabel(new ImageIcon(this.getClass().getResource("/recursos/objetos/bomba.png")));
		sprite.setVisible(false);
		gui.getContentPane().add(sprite, 0);
	}

	protected Entidad crearEntidad(int x, int y) {
		return new Bomba(x, y);
	}

}
