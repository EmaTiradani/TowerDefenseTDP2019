package entidades;

import juego.Juego;
import visitor.Visitor;
import visitor.VisitorEnemigo;

public abstract class Enemigo extends Personaje {
	
	protected int velocidad;
	protected int puntaje;

	protected Enemigo(int x, int y, int vida, int vel, int cooldown, int puntaje) {
		super(x, y, new VisitorEnemigo(), vida, cooldown);
		velocidad = vel;
		this.puntaje = puntaje;
	}

	public boolean accept(Visitor v) {
		return v.visit(this);
	}	
	
	public void morir() {
		super.morir();
		Juego.getJuego().sumarPuntos(puntaje);
	}
}
