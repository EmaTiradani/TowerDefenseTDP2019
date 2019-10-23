package listeners;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.Entidad;
import personajes.*;

public class ComprableTorreBasica extends ComprableMotionListener {

	public ComprableTorreBasica(Gui gui) {
		super(gui);
		sprite = new JLabel(new ImageIcon(this.getClass().getResource("/recursos/aliados/aliado02.png")));
		sprite.setVisible(false);
		gui.getContentPane().add(sprite, 0);
	}

	protected Entidad crearPersonaje(int x, int y) {
		return new TorreBasica(x, y);
	}

}
