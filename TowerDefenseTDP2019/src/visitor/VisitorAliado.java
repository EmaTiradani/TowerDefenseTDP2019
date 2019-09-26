package visitor;

import entidades.Aliado;
import entidades.Enemigo;

public class VisitorAliado extends Visitor {
	
	protected Aliado a;
	
	public VisitorAliado(Aliado a) {
		this.a = a;
	}

	public void visit(Aliado entidad) {
	}

	public void visit(Enemigo entidad) {
		a.disparar();
	}

}
