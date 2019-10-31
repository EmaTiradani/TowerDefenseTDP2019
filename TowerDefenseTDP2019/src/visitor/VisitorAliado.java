package visitor;

import entidades.abstractas.Aliado;
import entidades.abstractas.Enemigo;
import entidades.abstractas.ObjetoVida;

/**
 * Visitor que utilizan las entidades de tipo Aliado.
 * Este visitor es usado para determinar cuándo un aliado puede disparar.
 *
 */
public class VisitorAliado extends Visitor {
	
	protected Aliado a;
	
	/**
	 * Crea un visitor
	 * @param a - El aliado que crea el visitor
	 */
	public VisitorAliado(Aliado a) {
		this.a = a;
	}

	public void visit(Aliado entidad) {
	}

	public void visit(Enemigo entidad) {
		a.disparar();
	}

	public void visit(ObjetoVida entidad) {		
	}

}
