package entidades;

import javax.swing.JLabel;

import GUI.Gui;
import juego.Juego;
import visitor.Visitor;

public abstract class Entidad {
	
	protected JLabel sprite;
	protected int x;
	protected int y;
	protected Visitor miVisitor;
	
	protected Entidad(int x, int y) {
		this.x = x*Gui.spriteSize;
		this.y = y*Gui.spriteSize;
		
	}
	
	public JLabel getSprite() {
		return sprite;
	}	

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public abstract int getCoste();

	public abstract void accion(float estimatedTime);
	
	public abstract void accept(Visitor v);
	
	public void morir() {
		Juego.getJuego().matar(this);
	}
	
}