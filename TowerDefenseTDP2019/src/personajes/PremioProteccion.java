package personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.Premio;
import juego.Juego;
import state.Proteccion;
import visitor.VisitorBuff;

public class PremioProteccion extends Premio {

	public PremioProteccion(int x, int y) {
		super(x, y);
		
		miVisitor = new VisitorBuff(new Proteccion());

		sprite = new JLabel();
		sprite.setIcon(new ImageIcon(this.getClass().getResource("/recursos/objetos/proteccion.png")));
		sprite.setBounds(this.x, this.y, Gui.spriteSize, Gui.spriteSize);
		agregarListener();
	}

	protected void activarEffecto() {
		Juego.getJuego().visitarEntidades(miVisitor);		
	}

}
