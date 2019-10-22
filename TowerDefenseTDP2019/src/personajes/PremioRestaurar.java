package personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.Premio;
import juego.Juego;
import visitor.VisitorRestaurador;

public class PremioRestaurar extends Premio {

	public PremioRestaurar(int x, int y) {
		super(x, y);
		miVisitor = new VisitorRestaurador();

		sprite = new JLabel();
		sprite.setIcon(new ImageIcon(this.getClass().getResource("/recursos/objetos/vida.png")));
		sprite.setBounds(this.x, this.y, Gui.spriteSize, Gui.spriteSize);
		agregarListener();
	}

	protected void activarEffecto() {
		Juego.getJuego().visitarEntidades(miVisitor);
	}

}
