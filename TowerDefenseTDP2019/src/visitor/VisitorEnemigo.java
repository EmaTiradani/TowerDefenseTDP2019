package visitor;

import entidades.Aliado;
import entidades.Enemigo;
import entidades.ObjetoVida;

public class VisitorEnemigo extends Visitor {
	
	protected Enemigo en;
	
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
