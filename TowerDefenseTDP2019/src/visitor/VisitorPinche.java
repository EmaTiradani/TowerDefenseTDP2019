package visitor;

import entidades.Enemigo;
import entidades.ObjetoVida;
import entidades.Personaje;
import personajes.Pinches;

public class VisitorPinche extends Visitor {
	
	protected Pinches pinches;

	public VisitorPinche(Pinches p) {
		pinches = p;
	}

	public void visit(Personaje entidad) {
	}

	public void visit(Enemigo entidad) {
		pinches.atacar(entidad);
	}

	public void visit(ObjetoVida entidad) {
	}

}
