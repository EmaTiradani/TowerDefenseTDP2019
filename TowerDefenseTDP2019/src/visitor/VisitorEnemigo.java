package visitor;

import entidades.Aliado;
import entidades.Enemigo;

public class VisitorEnemigo extends Visitor {

	public boolean visit(Aliado entidad) {
		return true;
	}

	public boolean visit(Enemigo entidad) {
		return false;
	}

}
