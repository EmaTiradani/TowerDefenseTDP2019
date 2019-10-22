package entidades;

import GUI.Gui;
import juego.Juego;

public abstract class EnemigoCerca extends Enemigo {
	
	protected int da�o;

	protected EnemigoCerca(int x, int y, int vida, int vel, int cooldown, int da�o, int puntaje) {
		super(x, y, vida, vel, cooldown, puntaje);
		this.da�o = da�o;
	}
	
	public void atacar(Atacable a) {
		if (!sprite.getIcon().equals(spriteAtaque)) {
			sprite.setIcon(spriteAtaque);
		}
		
		if (cooldownActual<=0) {
			cooldownActual = cooldownAtaque;	
			a.recibirDa�o(estado.getDa�o(da�o));
		}
	}

	public void accion(float estimatedTime) {
		cooldownActual -= estimatedTime;	
		actualizarEstado(estimatedTime);
		if ((x-velocidad)/Gui.spriteSize<x/Gui.spriteSize) {
			//Intento ir a la siguiente celda
			Entidad e = Juego.getJuego().getEntidad((x-velocidad)/Gui.spriteSize, y/Gui.spriteSize);
			if (e!=null) {
				e.accept(miVisitor);				
			}
			else {
				mover();
			}
		}	
		else {
			mover();
		}
	}
}
