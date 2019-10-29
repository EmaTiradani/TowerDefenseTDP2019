package entidades.concretas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.abstractas.DisparoAliado;
import state.Estado;

public class DisparoAliadoTest extends DisparoAliado {

	public DisparoAliadoTest(int x, int y, int alcance, Estado estado) {
		super(x, y, 10, 15, alcance, estado);
		
		sprite = new JLabel();
		sprite.setIcon(new ImageIcon(this.getClass().getResource("/recursos/arrow.png")));
		sprite.setBounds(this.x, this.y, Gui.spriteSize, Gui.spriteSize);
	}

}
