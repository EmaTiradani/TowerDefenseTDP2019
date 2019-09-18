package entidades;

import javax.swing.JLabel;
import visitor.Visitor;

public abstract class Entidad {
	
	protected JLabel sprite;
	protected int x;
	protected int y;
	protected Visitor miVisitor;
	
	protected Entidad(int x, int y, Visitor vis) {
		this.x = x*128;
		this.y = y*128;
		miVisitor = vis;
		
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

	public abstract void accion(float estimatedTime);
	
	public abstract boolean accept(Visitor v);
	
}