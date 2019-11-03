package entidades.abstractas;

import GUI.Gui;
import juego.Juego;
import visitor.VisitorEnemigoDistancia;

/**
 * Tipo de enemigo que ataca a distancia utilizando proyectiles.
 *
 */
public abstract class EnemigoDistancia extends Enemigo {
	
	protected int alcance;

	/**
	 * Crea un enemigo en una posición.
	 * @param x - La columna donde se crea el personaje
	 * @param y - La fila donde se crea el personaje
	 * @param vida - La vida maxima del personaje
	 * @param cooldown - El tiempo que tiene que esperar para poder realizar una ataque
	 * @param vel - La velocidad de movimiento del personaje
	 * @param alcance - El alcance del personaje. Esto determina qué tan lejos puede disparar
	 * @param puntaje - El puntaje que otorga al jugador cuando se muere
	 */
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
	
	/**
	 * Crea y retorna el disparo. Cada clase concreta que herede de EnemigoDistancia deber definir qué tipo de disparo creará.
	 * @return El disparo
	 */
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
	
	/**
	 * Retorna el alcance del disparo de este enemigo
	 * @return El alcance del disparo
	 */
	public int getAlcance() {
		return alcance;
	}

}
