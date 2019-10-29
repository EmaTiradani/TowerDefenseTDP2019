package entidades.abstractas;

import GUI.Gui;
import juego.Juego;
import visitor.VisitorEnemigoDistancia;

public abstract class EnemigoDistancia extends Enemigo {
	
	protected int alcance;

	protected EnemigoDistancia(int x, int y, int vida, int cooldown, int vel, int alcance, int puntaje) {
		super(x, y, vida, vel, cooldown, puntaje);
		this.alcance = alcance;
	}
	
	protected void setVisitor() {
		miVisitor = new VisitorEnemigoDistancia(this);
	}
	
	public void atacar(Atacable a) {
		if (!sprite.getIcon().equals(spriteAtaque)) {
			sprite.setIcon(spriteAtaque);
		}
		
		if (cooldownActual<=0) {
			cooldownActual = cooldownAtaque;	
			Juego.getJuego().agregarEntidad(this.crearDisparo());
		}
	}
	
	protected abstract Disparo crearDisparo();

	public void accion(float estimatedTime) {
		cooldownActual -= estimatedTime;
		actualizarEstado(estimatedTime);
		Entidad e;
		if (x/Gui.spriteSize<Juego.FINAL_MAPA) {
			for (int i=1; i<=alcance; i++) {
				e = Juego.getJuego().getEntidad(x/Gui.spriteSize - i, y/Gui.spriteSize);					
				if (e!=null) {
					e.accept(miVisitor);
				}
			}
		}
		if (cooldownActual<=0) {
			mover();
		}		
	}
	
	public int getAlcance() {
		return alcance;
	}

}
