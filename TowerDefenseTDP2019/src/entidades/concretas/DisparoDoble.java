package entidades.concretas;

import entidades.abstractas.DisparoAliado;
import state.Estado;

/**
 * Disparo asociado con el aliado TorreDoble
 *
 */
public class DisparoDoble extends DisparoAliado {

	/**
	 * Crea un disparo doble en una posición.
	 * @param x - La columna donde se crea el disparo
	 * @param y - La fila donde se crea el disparo
	 * @param alcance - El alcance del disparo
	 * @param estado - El estado del disparo
	 */
	public DisparoDoble(int x, int y, int alcance, Estado estado) {
		super(x, y, 30, 10, alcance, estado);
	}

}
