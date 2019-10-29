package entidades.abstractas;

import GUI.Gui;
import juego.Juego;
import visitor.Visitor;
import visitor.VisitorAliado;

public abstract class Aliado extends Personaje {
	
	protected int alcance;
	protected int coste;

	protected Aliado(int x, int y, int vida, int cooldown, int alcance, int coste) {
		super(x, y, vida, cooldown);
		this.alcance = alcance;
		this.coste = coste;
		setVisitor();
	}
	
	public int getValor() {
		return coste;
	}
	
	protected void setVisitor() {
		miVisitor = new VisitorAliado(this);
	}
	
	public void accept(Visitor v) {
		v.visit(this);
	}

	public void accion(float estimatedTime) {
		cooldownActual -= estimatedTime;
		actualizarEstado(estimatedTime);
		Entidad e;
		for (int i=1; i<=alcance; i++) {
			e = Juego.getJuego().getEntidad(x/Gui.spriteSize + i, y/Gui.spriteSize);					
			if (e!=null) {
				e.accept(miVisitor);
			}
		}		
	}

	public void disparar() {
		if (cooldownActual<=0) {
			Juego.getJuego().agregarEntidad(this.crearDisparo());
			cooldownActual = cooldownAtaque;
		}		
	}
	
	protected abstract Disparo crearDisparo();
}
