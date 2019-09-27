package entidades;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import juego.Celda;
import visitor.Visitor;

public class DisparoAliado extends Disparo{
	

	
	public DisparoAliado(int x, int y, int daño, int vel) {
		super(x,y);
		this.dmg = daño;
		this.velocidad = vel;
		sprite = new JLabel();
		sprite.setIcon(new ImageIcon(this.getClass().getResource("/recursos/arrow.png")));
		sprite.setBounds(this.x, this.y, Gui.spriteSize, Gui.spriteSize);
	}
	
	public int getDaño() {
		return dmg;
		
	}
	public void mover() {
		if ((x-velocidad)/Gui.spriteSize<x/Gui.spriteSize) {
			//Cambio de celda
		}
		x-= velocidad;
		sprite.setBounds(x, y, Gui.spriteSize, Gui.spriteSize);
	}

	@Override
	public void accion(float estimatedTime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
	}
	
}
