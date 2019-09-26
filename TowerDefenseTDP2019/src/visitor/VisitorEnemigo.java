package visitor;

import entidades.Aliado;
import entidades.Enemigo;

public class VisitorEnemigo extends Visitor {
	
	protected Enemigo en;
	
	public VisitorEnemigo(Enemigo e) {
		en = e;
	}
	
	public void visit(Aliado entidad) {
		en.atacar(entidad);
	}

	public void visit(Enemigo entidad) {
		en.mover();
	}

}
