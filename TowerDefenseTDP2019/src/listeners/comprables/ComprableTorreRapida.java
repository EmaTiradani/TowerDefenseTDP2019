package listeners.comprables;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.abstractas.Entidad;
import entidades.concretas.TorreRapida;

/**
 * Listener asociado con el aliado TorreRapida
 */
public class ComprableTorreRapida extends ComprableMotionListener {

	public ComprableTorreRapida(Gui gui) {
		super(gui);
		sprite = new JLabel(new ImageIcon(this.getClass().getResource("/recursos/aliados/aliado03.png")));
		sprite.setVisible(false);
		gui.getContentPane().add(sprite, 0);
	}

	protected Entidad crearEntidad(int x, int y) {
		return new TorreRapida(x, y);
	}

}
