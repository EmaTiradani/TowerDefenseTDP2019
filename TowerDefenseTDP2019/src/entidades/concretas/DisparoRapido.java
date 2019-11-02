package entidades.concretas;

import entidades.abstractas.DisparoAliado;
import state.Estado;

/**
 * Disparo asociado con el aliado TorreRapida *
 */
public class DisparoRapido extends DisparoAliado {

	/**
	 * Crea un disparo básico en una posición.
	 * @param x - La columna donde se crea el disparo
	 * @param y - La fila donde se crea el disparo
	 * @param alcance - El alcance del disparo
	 * @param estado - El estado del disparo
	 */
	protected DisparoRapido(int x, int y, int alcance, Estado estado) {
		super(x, y, 20, 20, alcance, estado);
	}

}
