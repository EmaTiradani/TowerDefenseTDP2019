package visitor;

import entidades.Aliado;
import entidades.Enemigo;
import entidades.ObjetoVida;

public class VisitorRestaurador extends Visitor {

	public void visit(Aliado entidad) {
		entidad.recuperarVida();
	}

	public void visit(Enemigo entidad) {
	}

	public void visit(ObjetoVida entidad) {
	}

}
