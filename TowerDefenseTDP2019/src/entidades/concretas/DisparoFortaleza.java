package entidades.concretas;

import entidades.abstractas.DisparoAliado;
import state.Estado;

/**
 * Disparo asociado con el aliado Fortaleza
 *
 */
public class DisparoFortaleza extends DisparoAliado {

	/**
	 * Crea un disparo fortaleza en una posición.
	 * @param x - La columna donde se crea el disparo
	 * @param y - La fila donde se crea el disparo
	 * @param alcance - El alcance del disparo
	 * @param estado - El estado del disparo
	 */
	public DisparoFortaleza(int x, int y, int alcance, Estado estado) {
		super(x, y, 5, 15, alcance, estado);
	}

}
