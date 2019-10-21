package GUI;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import entidades.Aliado;
import entidades.Entidad;
import personajes.TorreNormal;

public class ComprableTorreNormal extends ComprableMotionListener {

	protected ComprableTorreNormal(Gui gui) {
		super(gui);
		sprite = new JLabel(new ImageIcon(this.getClass().getResource("/recursos/aliados/aliado01.png")));
		sprite.setVisible(false);
		gui.getContentPane().add(sprite, 0);
	}

	protected Entidad crearPersonaje(int x, int y) {
		return new TorreNormal(x, y);
	}

}
