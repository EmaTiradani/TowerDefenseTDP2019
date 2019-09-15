package entidades;

import visitor.Visitor;
import visitor.VisitorEnemigo;

public abstract class Enemigo extends Personaje{
	
	protected int velocidad;

	protected Enemigo(int x, int y, int vida, int vel, int cooldown) {
		super(x, y, new VisitorEnemigo(), vida, cooldown);
		velocidad = vel;
	}

	public boolean accept(Visitor v) {
		return v.visit(this);
	}	
}
