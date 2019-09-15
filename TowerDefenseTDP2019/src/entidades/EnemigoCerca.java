package entidades;

import java.util.Iterator;

import juego.Juego;

public abstract class EnemigoCerca extends Enemigo {
	
	protected int daño;

	protected EnemigoCerca(int x, int y, int vida, int vel, int cooldown, int daño) {
		super(x, y, vida, vel, cooldown);
		this.daño = daño;
	}
	
	public void accion() {
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
					System.out.println("Ataque");
					try {
						Thread.sleep(this.cooldownAtaque*1000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
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
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
