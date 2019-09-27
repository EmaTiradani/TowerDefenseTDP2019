package personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.Aliado;
import entidades.Disparo;

public class AliadoTest extends Aliado {
		
	public AliadoTest(int x, int y) {
		super(x, y, 10, 1, 8);
		
		sprite = new JLabel();
		sprite.setIcon(new ImageIcon(this.getClass().getResource("/recursos/cannon.png")));
		sprite.setBounds(this.x, this.y, Gui.spriteSize, Gui.spriteSize);
	}
	
	public Disparo crearDisparo() {
		return new DisparoAliadoTest(this.x/Gui.spriteSize, this.y/Gui.spriteSize, alcance);
	}

}
