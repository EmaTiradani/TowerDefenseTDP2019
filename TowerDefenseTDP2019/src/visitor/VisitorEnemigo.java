package visitor;

import entidades.Aliado;
import entidades.Personaje;

public class VisitorEnemigo extends Visitor {

	public boolean visit(Aliado entidad) {
		return true;
	}

	public boolean visit(Personaje entidad) {
		return false;
	}

}