package visitor;

import entidades.Aliado;
import entidades.Enemigo;
import entidades.ObjetoVida;
import personajes.BarricadaConPinches;

public class VisitorBarricadaPinches extends Visitor {

	protected BarricadaConPinches pinches;

	public VisitorBarricadaPinches(BarricadaConPinches p) {
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
