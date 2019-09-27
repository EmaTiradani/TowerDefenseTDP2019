package entidades;

import GUI.Gui;
import juego.Juego;
import visitor.Visitor;
import visitor.VisitorEnemigo;

public abstract class Enemigo extends Personaje {
	
	protected int velocidad;
	protected int puntaje;

	protected Enemigo(int x, int y, int vida, int vel, int cooldown, int puntaje) {
		super(x, y, vida, cooldown);
		velocidad = vel;
		this.puntaje = puntaje;
		setVisitor();
	}
	
	protected void setVisitor() {
		miVisitor = new VisitorEnemigo(this);
	}

	public void accept(Visitor v) {
		v.visit(this);
	}	
	
	public void morir() {
		super.morir();
		Juego.getJuego().sumarPuntos(puntaje);
	}

	public abstract void atacar(Atacable entidad);

	public void mover() {
		if ((x-velocidad)/Gui.spriteSize<x/Gui.spriteSize) {
			//Cambio de celda en el mapa
			Juego.getJuego().setEntidad(x/Gui.spriteSize, y/Gui.spriteSize, null);
			Juego.getJuego().setEntidad((x-velocidad)/Gui.spriteSize, y/Gui.spriteSize, this);
		}
		x-= velocidad;
		sprite.setBounds(x, y, Gui.spriteSize, Gui.spriteSize);
	}
}
