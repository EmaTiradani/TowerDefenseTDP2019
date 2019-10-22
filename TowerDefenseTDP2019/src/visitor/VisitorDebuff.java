package visitor;

import entidades.Aliado;
import entidades.Enemigo;
import entidades.ObjetoVida;
import state.Estado;

public class VisitorDebuff extends Visitor {
	
	public Estado debuff;
	
	public VisitorDebuff(Estado e) {
		debuff = e;
	}

	public void visit(Aliado entidad) {		
	}
	
	public void visit(Enemigo entidad) {
		entidad.setEstado(debuff, 10);		
	}
	
	public void visit(ObjetoVida entidad) {	
	}

}
