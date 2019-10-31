package entidades.abstractas;

import GUI.Gui;
import juego.Juego;

/**
 * Tipo de enemigo que solamente puede atacar de cerca, es decir, si si objetivo está en la siguiente celda del mapa. *
 */
public abstract class EnemigoCerca extends Enemigo {
	
	protected int daño;

	/**
	 * Crea un enemigo en una posición.
	 * @param x - La columna donde se crea el personaje
	 * @param y - La fila donde se crea el personaje
	 * @param vida - La vida maxima del personaje
	 * @param vel - La velocidad de movimiento del personaje
	 * @param cooldown - El tiempo que tiene que esperar para poder realizar una ataque
	 * @param daño - El daño que realiza con cada ataque
	 * @param puntaje - El puntaje que otorga al jugador cuando se muere
	 */
	protected EnemigoCerca(int x, int y, int vida, int vel, int cooldown, int daño, int puntaje) {
		super(x, y, vida, vel, cooldown, puntaje);
		this.daño = daño;
	}
	
	public void atacar(Atacable a) {
		if (!sprite.getIcon().equals(spriteAtaque)) {
			sprite.setIcon(spriteAtaque);
		}
		
		if (cooldownActual<=0) {
			cooldownActual = cooldownAtaque;	
			a.recibirDaño(estado.getDaño(daño));
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
