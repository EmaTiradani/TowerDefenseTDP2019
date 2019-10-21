package visitor;

import entidades.Aliado;
import entidades.Enemigo;
import entidades.ObjetoVida;
import personajes.Pinches;

public class VisitorPinche extends Visitor {
	
	protected Pinches pinches;

	public VisitorPinche(Pinches p) {
		pinches = p;
	}

	public void visit(Aliado entidad) {
	}

	public void visit(Enemigo entidad) {
		pinches.atacar(entidad);
	}

	public void visit(ObjetoVida entidad) {
	}

}
