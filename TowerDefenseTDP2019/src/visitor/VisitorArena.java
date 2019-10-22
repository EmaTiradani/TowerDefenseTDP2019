package visitor;

import entidades.Aliado;
import entidades.Enemigo;
import entidades.ObjetoVida;
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
