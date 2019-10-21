package visitor;

import entidades.Aliado;
import entidades.Enemigo;
import entidades.ObjetoVida;
import entidades.Personaje;

public class VisitorAliado extends Visitor {
	
	protected Aliado a;
	
	public VisitorAliado(Aliado a) {
		this.a = a;
	}

	public void visit(Personaje entidad) {
	}

	public void visit(Enemigo entidad) {
		a.disparar();
	}

	public void visit(ObjetoVida entidad) {		
	}

}
