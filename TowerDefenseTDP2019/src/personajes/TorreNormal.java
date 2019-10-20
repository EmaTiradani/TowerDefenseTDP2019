package personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.Aliado;
import entidades.Disparo;

public class TorreNormal extends Aliado {

	public TorreNormal(int x, int y) {
		super(x, y, 100, 2, 4, 20);
		sprite = new JLabel();
		sprite.setIcon(new ImageIcon(this.getClass().getResource("/recursos/aliados/aliado01.png")));
		sprite.setBounds(this.x, this.y, Gui.spriteSize, Gui.spriteSize);
	}

	@Override
	protected Disparo crearDisparo() {
		return new DisparoNormal(x/Gui.spriteSize, y/Gui.spriteSize, alcance);
	}

}
