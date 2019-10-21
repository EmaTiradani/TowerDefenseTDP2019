package visitor;

import entidades.Aliado;
import entidades.Enemigo;
import entidades.ObjetoVida;
import state.Estado;

public class VisitorBuff extends Visitor {
	
	protected Estado buff;
	
	public VisitorBuff(Estado estado) {
		buff = estado;
	}

	public void visit(Aliado entidad) {
		entidad.setEstado(buff);
	}

	public void visit(Enemigo entidad) {
	}

	public void visit(ObjetoVida entidad) {
	}

}
