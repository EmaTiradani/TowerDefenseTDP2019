package entidades.concretas;

import entidades.abstractas.DisparoAliado;
import state.Estado;

public class DisparoDoble extends DisparoAliado {

	public DisparoDoble(int x, int y, int alcance, Estado estado) {
		super(x, y, 30, 10, alcance, estado);
	}

}
