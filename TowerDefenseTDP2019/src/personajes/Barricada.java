package personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.ObjetoVida;

public class Barricada extends ObjetoVida {
	
	public Barricada(int x, int y) {
		super(x, y, 120);
		
		sprite = new JLabel();
		sprite.setIcon(new ImageIcon(this.getClass().getResource("/recursos/objetos/barricada.png")));
		sprite.setBounds(this.x, this.y, Gui.spriteSize, Gui.spriteSize);
	}

	public void accion(float estimatedTime) {
	}
	
	public int getCoste() {
		return 35;
	}

}
