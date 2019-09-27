package personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.ObjetoVida;

public class Barricada extends ObjetoVida {

	public Barricada(int x, int y) {
		super(x, y, 100);
		
		sprite = new JLabel();
		sprite.setIcon(new ImageIcon(this.getClass().getResource("/recursos/bicho enemigo.jpg")));
		sprite.setBounds(this.x, this.y, Gui.spriteSize, Gui.spriteSize);
	}

	public void accion(float estimatedTime) {
	}

}
