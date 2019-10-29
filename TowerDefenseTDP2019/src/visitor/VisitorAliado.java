package visitor;

import entidades.abstractas.Aliado;
import entidades.abstractas.Enemigo;
import entidades.abstractas.ObjetoVida;

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

	public void visit(ObjetoVida entidad) {		
	}

}
