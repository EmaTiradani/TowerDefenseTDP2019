package personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import entidades.EnemigoDistancia;
import GUI.Gui;
import entidades.Disparo;

public class Arquero extends EnemigoDistancia {

	public Arquero(int x, int y) {
		super(x, y, 50, 3, 10, 2, 15);
		
		spriteMovimiento = new ImageIcon(this.getClass().getResource("/recursos/enemigos/arquero.gif"));
		spriteAtaque = new ImageIcon(this.getClass().getResource("/recursos/enemigos/disparoarquero.gif"));
		sprite = new JLabel();
		sprite.setIcon(spriteMovimiento);
		sprite.setBounds(this.x, this.y, Gui.spriteSize, Gui.spriteSize);
		agregarBarraVida();
	}

	protected Disparo crearDisparo() {
		return new DisparoEnemigoTest(x/Gui.spriteSize, y/Gui.spriteSize, alcance, estado);
	}

}
