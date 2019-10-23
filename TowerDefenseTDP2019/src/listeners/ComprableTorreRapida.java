package listeners;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.Entidad;
import personajes.TorreRapida;

public class ComprableTorreRapida extends ComprableMotionListener {

	public ComprableTorreRapida(Gui gui) {
		super(gui);
		sprite = new JLabel(new ImageIcon(this.getClass().getResource("/recursos/aliados/aliado03.png")));
		sprite.setVisible(false);
		gui.getContentPane().add(sprite, 0);
	}

	protected Entidad crearPersonaje(int x, int y) {
		return new TorreRapida(x, y);
	}

}
