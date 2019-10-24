package listeners;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.Entidad;
import personajes.BarricadaConPinches;

public class ComprableBarricadaPinches extends ComprableMotionListener {

	public ComprableBarricadaPinches(Gui gui) {
		super(gui);
		sprite = new JLabel(new ImageIcon(this.getClass().getResource("/recursos/objetos/barricada.png")));
		sprite.setVisible(false);
		gui.getContentPane().add(sprite, 0);
	}
	protected Entidad crearPersonaje(int x, int y) {
		return new BarricadaConPinches(x, y);
	}
	
}


