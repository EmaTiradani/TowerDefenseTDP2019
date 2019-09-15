package entidades;

import visitor.Visitor;
import visitor.VisitorAliado;

public abstract class Aliado extends Personaje {
	
	protected int alcance;

	protected Aliado(int x, int y, int vida, int cooldown, int alcance) {
		super(x, y, new VisitorAliado(), vida, cooldown);
		this.alcance = alcance;
	}
	
	public boolean accept(Visitor v) {
		return v.visit(this);
	}
}
