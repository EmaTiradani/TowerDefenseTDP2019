package personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.Aliado;
import entidades.Disparo;

public class Fortaleza extends Aliado {

	public Fortaleza(int x, int y) {
		super(x, y, 150, 2, 2, 30);
		sprite = new JLabel();
		sprite.setIcon(new ImageIcon(this.getClass().getResource("/recursos/aliados/aliado04.png")));
		sprite.setBounds(this.x, this.y, Gui.spriteSize, Gui.spriteSize);
		agregarBarraVida();
	}

	protected Disparo crearDisparo() {
		return new DisparoFortaleza(x/Gui.spriteSize, y/Gui.spriteSize, alcance, estado);
	}

}
