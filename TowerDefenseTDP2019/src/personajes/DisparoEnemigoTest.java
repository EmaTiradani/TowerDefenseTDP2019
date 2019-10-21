package personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.DisparoEnemigo;
import state.Estado;

public class DisparoEnemigoTest extends DisparoEnemigo {

	public DisparoEnemigoTest(int x, int y, int alcance, Estado estado) {
		super(x, y, 15, 10, alcance, estado);
		
		sprite = new JLabel();
		sprite.setIcon(new ImageIcon(this.getClass().getResource("/recursos/arrow2.png")));
		sprite.setBounds(this.x, this.y, Gui.spriteSize, Gui.spriteSize);
	}

}
