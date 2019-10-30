package entidades.concretas;

import entidades.abstractas.DisparoAliado;
import state.Estado;

public class DisparoRapido extends DisparoAliado {

	protected DisparoRapido(int x, int y, int alcance, Estado estado) {
		super(x, y, 20, 20, alcance, estado);
	}

}
