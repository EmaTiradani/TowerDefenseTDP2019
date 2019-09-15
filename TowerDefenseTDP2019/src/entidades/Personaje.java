package entidades;

import visitor.Visitor;

public abstract class Personaje extends Entidad {
	
	protected int maxVida;
	protected float vida;
	protected int cooldownAtaque;
	
	protected Personaje(int x, int y, Visitor vis, int vida, int cooldown) {
		super(x, y, vis);
		maxVida = vida;
		this.vida = vida;
		cooldownAtaque = cooldown;
	}
	
}
