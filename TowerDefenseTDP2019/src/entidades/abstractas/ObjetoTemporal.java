package entidades.abstractas;

import visitor.Visitor;

/**
 * Tipo de entidad que existe por un tiempo finito. Ese tiempo es determinado durante la creación del objeto.
 * Una vez pasado el tiempo límite, el objeto se destruye.
 *
 */
public abstract class ObjetoTemporal extends Entidad {
	
	protected float tiempoVida;
	protected int tiempoLimite;

	/**
	 * Crea un objeto en una posición
	 * @param x - La columna donde se crea el objeto
	 * @param y - La fila donde se crea el objeto
	 * @param tiempo - El tiempo que dura la existencia de este objeto
	 */
	protected ObjetoTemporal(int x, int y, int tiempo) {
		super(x, y);
		tiempoVida = 0;
		tiempoLimite = tiempo;
	}
	
	public void accion(float estimatedTime) {
		tiempoVida += estimatedTime;
		if (tiempoVida>=tiempoLimite) {
			morir();
		}
	}

	public void accept(Visitor v) {
	}
	
	public int getValor() {
		return 0;
	}

}
