package entidades.abstractas;

import GUI.Gui;
import juego.Juego;

/**
 * Tipo de enemigo que solamente puede atacar de cerca, es decir, si si objetivo est� en la siguiente celda del mapa. *
 */
public abstract class EnemigoCerca extends Enemigo {
	
	protected int da�o;

	/**
	 * Crea un enemigo en una posici�n.
	 * @param x - La columna donde se crea el personaje
	 * @param y - La fila donde se crea el personaje
	 * @param vida - La vida maxima del personaje
	 * @param vel - La velocidad de movimiento del personaje
	 * @param cooldown - El tiempo que tiene que esperar para poder realizar una ataque
	 * @param da�o - El da�o que realiza con cada ataque
	 * @param puntaje - El puntaje que otorga al jugador cuando se muere
	 */
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
