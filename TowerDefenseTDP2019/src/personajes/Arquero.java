package personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import entidades.EnemigoDistancia;
import GUI.Gui;
import entidades.Disparo;

public class Arquero extends EnemigoDistancia {

	public Arquero(int x, int y) {
		super(x, y, 10, 5, 5, 20, 15);
		
		sprite = new JLabel();
		sprite.setIcon(new ImageIcon(this.getClass().getResource("/recursos/goblin.png")));
		sprite.setBounds(this.x, this.y, Gui.spriteSize, Gui.spriteSize);
	}

	protected Disparo crearDisparo() {
		return new DisparoEnemigoTest(x/Gui.spriteSize, y/Gui.spriteSize, alcance);
	}

}
