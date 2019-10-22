package GUI;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import state.Estado;
import state.Fuerte;

public class ComprableDa�o extends ComprablePowerUp {

	protected ComprableDa�o(Gui gui) {
		super(gui);
		sprite = new JLabel(new ImageIcon(this.getClass().getResource("/recursos/objetos/ataque.png")));
		sprite.setVisible(false);
		gui.getContentPane().add(sprite, 0);
	}

	protected Estado crearPowerUp() {
		return new Fuerte();
	}

}
