package visitor;

import entidades.Enemigo;
import entidades.ObjetoVida;
import entidades.Personaje;

public class VisitorMatar extends Visitor {

	public void visit(Personaje entidad) {
	}

	public void visit(Enemigo entidad) {
		entidad.morir();
	}

	public void visit(ObjetoVida entidad) {		
	}

}
