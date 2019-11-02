package visitor;

import entidades.abstractas.Aliado;
import entidades.abstractas.Enemigo;
import entidades.abstractas.ObjetoVida;

/**
 * Visitor utilizado por la clase PremioRestaurador.
 *
 */
public class VisitorRestaurador extends Visitor {

	/**
	 * Crea el visitor.
	 */
	public VisitorRestaurador() {		
	}
	
	public void visit(Aliado entidad) {
		entidad.recuperarVida();
	}

	public void visit(Enemigo entidad) {
	}

	public void visit(ObjetoVida entidad) {
	}

}
