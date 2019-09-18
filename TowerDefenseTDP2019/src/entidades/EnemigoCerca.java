package entidades;

import java.util.Iterator;

import juego.Juego;

public abstract class EnemigoCerca extends Enemigo {
	
	protected int da�o;

	protected EnemigoCerca(int x, int y, int vida, int vel, int cooldown, int da�o) {
		super(x, y, vida, vel, cooldown);
		this.da�o = da�o;
	}
	
	public void accion(float estimatedTime) {
		cooldownActual -= estimatedTime;
		
		if ((x-velocidad)/128<x/128) {
			//Intento ir a la siguiente celda
			Iterator<Entidad> it = Juego.getJuego().getEntidad((x-velocidad)/128, y/128).iterator();
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
		if ((x-velocidad)/128<x/128) {
			//Cambio de celda
		}
		x-= velocidad;
		sprite.setBounds(x, y, 128, 128);
	}
}
