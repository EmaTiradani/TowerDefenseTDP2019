package listeners.comprables;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.abstractas.Entidad;
import entidades.concretas.TorreNormal;

public class ComprableTorreNormal extends ComprableMotionListener {

	public ComprableTorreNormal(Gui gui) {
		super(gui);
		sprite = new JLabel(new ImageIcon(this.getClass().getResource("/recursos/aliados/aliado01.png")));
		sprite.setVisible(false);
		gui.getContentPane().add(sprite, 0);
	}

	protected Entidad crearPersonaje(int x, int y) {
		return new TorreNormal(x, y);
	}

}
