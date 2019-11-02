package entidades.concretas;

import entidades.abstractas.DisparoEnemigo;
import state.Estado;

/**
 * Disparo asociado con el enemigo Arquero
 *
 */
public class DisparoArquero extends DisparoEnemigo {

	/**
	 * Crea un disparo de arquero en una posición.
	 * @param x - La columna donde se crea el disparo
	 * @param y - La fila donde se crea el disparo
	 * @param alcance - El alcance del disparo
	 * @param estado - El estado del disparo
	 */
	public DisparoArquero(int x, int y, int alcance, Estado estado) {
		super(x, y, 30, 20, alcance, estado);
	}

}
