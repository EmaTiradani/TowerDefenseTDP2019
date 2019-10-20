package GUI;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import entidades.Aliado;
import personajes.TorreRapida;

public class ComprableTorreRapida extends ComprableMotionListener {

	protected ComprableTorreRapida(Gui gui) {
		super(gui);
		sprite = new JLabel(new ImageIcon(this.getClass().getResource("/recursos/aliados/aliado03.png")));
		sprite.setVisible(false);
		gui.getContentPane().add(sprite, 0);
	}

	protected Aliado crearPersonaje(int x, int y) {
		return new TorreRapida(x, y);
	}

}
