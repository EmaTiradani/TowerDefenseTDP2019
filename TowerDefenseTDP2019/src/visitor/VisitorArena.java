package visitor;

import entidades.abstractas.Aliado;
import entidades.abstractas.Enemigo;
import entidades.abstractas.ObjetoVida;
import state.Lento;

public class VisitorArena extends Visitor {
	
	public VisitorArena() {		
	}

	public void visit(Aliado entidad) {
	}

	public void visit(Enemigo entidad) {
		entidad.setEstado(new Lento(), 2);
	}

	public void visit(ObjetoVida entidad) {
	}

}
