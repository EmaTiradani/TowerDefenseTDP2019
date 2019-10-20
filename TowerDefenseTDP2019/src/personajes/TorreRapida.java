package personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.Aliado;
import entidades.Disparo;

public class TorreRapida extends Aliado {

	public TorreRapida(int x, int y) {
		super(x, y, 100, 1, 4, 30);
		sprite = new JLabel();
		sprite.setIcon(new ImageIcon(this.getClass().getResource("/recursos/aliados/aliado03.png")));
		sprite.setBounds(this.x, this.y, Gui.spriteSize, Gui.spriteSize);
	}

	protected Disparo crearDisparo() {
		return new DisparoRapido(x/Gui.spriteSize, y/Gui.spriteSize, alcance);
	}

}
