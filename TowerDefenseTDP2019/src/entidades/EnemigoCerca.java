package entidades;

import java.util.Iterator;

import GUI.Gui;
import juego.Juego;

public abstract class EnemigoCerca extends Enemigo {
	
	protected int da�o;

	protected EnemigoCerca(int x, int y, int vida, int vel, int cooldown, int da�o, int puntaje) {
		super(x, y, vida, vel, cooldown, puntaje);
		this.da�o = da�o;
	}
	
	public void accion(float estimatedTime) {
		cooldownActual -= estimatedTime;		
		if ((x-velocidad)/Gui.spriteSize<x/Gui.spriteSize) {
			//Intento ir a la siguiente celda
			Iterator<Entidad> it = Juego.getJuego().getEntidad((x-velocidad)/Gui.spriteSize, y/Gui.spriteSize).iterator();
			Entidad e;
			boolean encontre = false;
			while (!encontre && it.hasNext()) {
				e = it.next();
				if (e.accept(miVisitor)) {
					encontre = true;
					//Atacar
					if (cooldownActual<=0) {
						System.out.println("Ataque");
						cooldownActual = cooldownAtaque;						
					}
				}
			}
			if (!encontre) {
				mover();
			}			
		}	
		else {
			mover();
		}
	}
	
	protected void mover() {
		if ((x-velocidad)/Gui.spriteSize<x/Gui.spriteSize) {
			//Cambio de celda
		}
		x-= velocidad;
		sprite.setBounds(x, y, Gui.spriteSize, Gui.spriteSize);
	}
}
