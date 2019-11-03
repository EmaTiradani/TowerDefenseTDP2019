package visitor;

import entidades.abstractas.Aliado;
import entidades.abstractas.Enemigo;
import entidades.abstractas.ObjetoVida;
import entidades.concretas.BarricadaConPinches;

/**
 * Visitor utilizado por la clase BarricadaConPinches
 *
 */
public class VisitorBarricadaPinches extends Visitor {

	protected BarricadaConPinches pinches;

	/**
	 * Crea un visitor
	 * @param p - La barricada con pinches que crea el visitor
	 */
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
