package visitor;

import entidades.abstractas.Aliado;
import entidades.abstractas.Enemigo;
import entidades.abstractas.ObjetoVida;

/**
 * Visitor utilizado para determinar la interacción de los enemigos con otras entidades.
 * Esto visitor solo se utiliza para enemigos que ataquen de cerca.
 *
 */
public class VisitorEnemigo extends Visitor {
	
	protected Enemigo en;
	
	/**
	 * Crea el visitor.
	 * @param e - El enemigo que crea el visitor
	 */
	public VisitorEnemigo(Enemigo e) {
		en = e;
	}
	
	public void visit(Aliado entidad) {
		en.atacar(entidad);
	}

	public void visit(Enemigo entidad) {
	}

	public void visit(ObjetoVida entidad) {
		en.atacar(entidad);
	}

}
