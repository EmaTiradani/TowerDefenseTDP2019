package GUI;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import entidades.Entidad;
import personajes.Bomba;

public class ComprableBomba extends ComprableMotionListener {

	protected ComprableBomba(Gui gui) {
		super(gui);
		sprite = new JLabel(new ImageIcon(this.getClass().getResource("/recursos/objetos/bomba.png")));
		sprite.setVisible(false);
		gui.getContentPane().add(sprite, 0);
	}

	protected Entidad crearPersonaje(int x, int y) {
		return new Bomba(x, y);
	}

}
