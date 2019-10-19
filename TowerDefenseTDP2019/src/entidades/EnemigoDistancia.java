package entidades;

import GUI.Gui;
import juego.Juego;

public abstract class EnemigoDistancia extends Enemigo {
	
	protected int alcance;

	protected EnemigoDistancia(int x, int y, int vida, int cooldown, int vel, int alcance, int puntaje) {
		super(x, y, vida, vel, cooldown, puntaje);
		this.alcance = alcance;
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

}
