package visitor;

import entidades.Aliado;
import entidades.Enemigo;

public class VisitorMatar extends Visitor {

	public void visit(Aliado entidad) {
	}

	public void visit(Enemigo entidad) {
		entidad.morir();
	}

}
