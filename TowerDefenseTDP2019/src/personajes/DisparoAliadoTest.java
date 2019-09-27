package personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.DisparoAliado;

public class DisparoAliadoTest extends DisparoAliado {

	public DisparoAliadoTest(int x, int y, int alcance) {
		super(x, y, 10, 15, alcance);
		
		sprite = new JLabel();
		sprite.setIcon(new ImageIcon(this.getClass().getResource("/recursos/arrow.png")));
		sprite.setBounds(this.x, this.y, Gui.spriteSize, Gui.spriteSize);
	}

}
