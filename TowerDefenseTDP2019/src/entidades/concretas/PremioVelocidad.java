package entidades.concretas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.abstractas.Premio;
import juego.Juego;
import state.Rapido;
import visitor.VisitorBuff;

public class PremioVelocidad extends Premio {

	public PremioVelocidad(int x, int y) {
		super(x, y);
		
		miVisitor = new VisitorBuff(new Rapido());

		sprite = new JLabel();
		sprite.setIcon(new ImageIcon(this.getClass().getResource("/recursos/objetos/energia.png")));
		sprite.setBounds(this.x, this.y, Gui.spriteSize, Gui.spriteSize);
		agregarListener();
	}

	protected void activarEffecto() {
		Juego.getJuego().visitarEntidades(miVisitor);
	}

}
