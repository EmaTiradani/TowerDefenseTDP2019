package personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.DisparoEnemigo;

public class DisparoEnemigoTest extends DisparoEnemigo {

	public DisparoEnemigoTest(int x, int y, int alcance) {
		super(x, y, 15, 10, alcance);
		
		sprite = new JLabel();
		sprite.setIcon(new ImageIcon(this.getClass().getResource("/recursos/arrow2.png")));
		sprite.setBounds(this.x, this.y, Gui.spriteSize, Gui.spriteSize);
	}

}
