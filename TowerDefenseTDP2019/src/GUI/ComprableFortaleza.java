package GUI;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import entidades.Aliado;
import entidades.Entidad;
import personajes.Fortaleza;

public class ComprableFortaleza extends ComprableMotionListener {

	protected ComprableFortaleza(Gui gui) {
		super(gui);
		sprite = new JLabel(new ImageIcon(this.getClass().getResource("/recursos/aliados/aliado04.png")));
		sprite.setVisible(false);
		gui.getContentPane().add(sprite, 0);
	}

	protected Entidad crearPersonaje(int x, int y) {
		return new Fortaleza(x, y);
	}

}
