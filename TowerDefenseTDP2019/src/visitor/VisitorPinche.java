package visitor;

import entidades.abstractas.Aliado;
import entidades.abstractas.Enemigo;
import entidades.abstractas.ObjetoVida;
import entidades.concretas.Pinches;

/**
 * Visitor utilizado por la clase Pinches
 *
 */
public class VisitorPinche extends Visitor {
	
	protected Pinches pinches;

	/**
	 * Crea el visitor.
	 * @param p - Los pinches que crean el visitor
	 */
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
