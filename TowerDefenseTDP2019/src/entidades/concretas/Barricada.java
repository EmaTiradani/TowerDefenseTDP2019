package entidades.concretas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.abstractas.ObjetoVida;

public class Barricada extends ObjetoVida {
	
	public Barricada(int x, int y) {
		super(x, y, 120);
		
		sprite = new JLabel();
		sprite.setIcon(new ImageIcon(this.getClass().getResource("/recursos/objetos/muro.png")));
		sprite.setBounds(this.x, this.y, Gui.spriteSize, Gui.spriteSize);
	}

	public void accion(float estimatedTime) {
	}
	
	public int getValor() {
		return 35;
	}

}
