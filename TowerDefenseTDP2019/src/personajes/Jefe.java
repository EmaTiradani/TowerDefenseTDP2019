package personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.Disparo;
import entidades.EnemigoDistancia;

public class Jefe extends EnemigoDistancia {
	public Jefe(int x, int y) {
		super(x, y, 30, 1, 4, 6, 100);
		
		sprite = new JLabel();
		sprite.setIcon(new ImageIcon(this.getClass().getResource("/recursos/goblin.png")));
		sprite.setBounds(this.x, this.y, Gui.spriteSize, Gui.spriteSize);
	}

	protected Disparo crearDisparo() {
		return new DisparoEnemigoTest(x/Gui.spriteSize, y/Gui.spriteSize, alcance, estado);
	}


}
