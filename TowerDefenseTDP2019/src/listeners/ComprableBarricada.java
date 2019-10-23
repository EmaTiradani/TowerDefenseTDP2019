package listeners;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.Entidad;
import personajes.Barricada;

public class ComprableBarricada extends ComprableMotionListener {

	public ComprableBarricada(Gui gui) {
		super(gui);
		sprite = new JLabel(new ImageIcon(this.getClass().getResource("/recursos/objetos/barricada.png")));
		sprite.setVisible(false);
		gui.getContentPane().add(sprite, 0);
	}

	protected Entidad crearPersonaje(int x, int y) {
		return new Barricada(x, y);
	}
	
}
