package visitor;

import entidades.Aliado;
import entidades.Enemigo;

public class VisitorMatar extends Visitor {

	public boolean visit(Aliado entidad) {
		return false;
	}

	public boolean visit(Enemigo entidad) {
		entidad.morir();
		return true;
	}

}
