package visitor;

import entidades.abstractas.Aliado;
import entidades.abstractas.Enemigo;
import entidades.abstractas.ObjetoVida;

public class VisitorRestaurador extends Visitor {

	public void visit(Aliado entidad) {
		entidad.recuperarVida();
	}

	public void visit(Enemigo entidad) {
	}

	public void visit(ObjetoVida entidad) {
	}

}
