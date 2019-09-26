package entidades;

import GUI.Gui;
import juego.Juego;
import visitor.Visitor;
import visitor.VisitorAliado;

public abstract class Aliado extends Personaje {
	
	protected int alcance;

	protected Aliado(int x, int y, int vida, int cooldown, int alcance) {
		super(x, y, vida, cooldown);
		this.alcance = alcance;
		setVisitor();
	}
	
	protected void setVisitor() {
		miVisitor = new VisitorAliado(this);
	}
	
	public void accept(Visitor v) {
		v.visit(this);
	}

	public void accion(float estimatedTime) {
		cooldownActual -= estimatedTime;
		if (cooldownActual<=0) {
			Entidad e;
			for (int i=1; i<=alcance; i++) {
				e = Juego.getJuego().getEntidad(x/Gui.spriteSize + i, y/Gui.spriteSize);				
				if (e!=null) {
					e.accept(miVisitor);
				}
			}
		}
		
	}

	public abstract void disparar();
}
