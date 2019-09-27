package visitor;

import entidades.Aliado;
import entidades.Enemigo;
import entidades.ObjetoVida;

public class VisitorMatar extends Visitor {

	public void visit(Aliado entidad) {
	}

	public void visit(Enemigo entidad) {
		entidad.morir();
	}

	public void visit(ObjetoVida entidad) {		
	}

}
