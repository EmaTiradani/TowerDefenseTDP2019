package entidades;

import javax.swing.JLabel;

import visitor.Visitor;

public abstract class Entidad implements Runnable {
	
	protected JLabel sprite;
	protected int x;
	protected int y;
	protected Visitor miVisitor;
	
	public JLabel getSprite() {
		return sprite;
	}
	
	public abstract void accion();

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public abstract boolean accept(Visitor v);
}