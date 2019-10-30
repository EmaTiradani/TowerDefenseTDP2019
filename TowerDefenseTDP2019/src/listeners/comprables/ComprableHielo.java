package listeners.comprables;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import state.Estado;
import state.Lento;
import visitor.Visitor;
import visitor.VisitorDebuff;

public class ComprableHielo extends ComprablePowerUp {

	public ComprableHielo(Gui gui) {
		super(gui);
		sprite = new JLabel(new ImageIcon(this.getClass().getResource("/recursos/objetos/hielo.png")));
		sprite.setVisible(false);
		gui.getContentPane().add(sprite, 0);
	}
	
	protected Visitor getVisitor(Estado e) {
		return new VisitorDebuff(e);
	}

	protected Estado crearPowerUp() {
		return new Lento();
	}

}
