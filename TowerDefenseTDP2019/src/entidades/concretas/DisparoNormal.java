package entidades.concretas;

import entidades.abstractas.DisparoAliado;
import state.Estado;

public class DisparoNormal extends DisparoAliado {

	public DisparoNormal(int x, int y, int alcance, Estado estado) {
		super(x, y, 10, 15, alcance, estado);
	}

}
