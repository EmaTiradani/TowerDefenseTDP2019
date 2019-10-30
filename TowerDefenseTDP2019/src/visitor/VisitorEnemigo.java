package visitor;

import entidades.abstractas.Aliado;
import entidades.abstractas.Enemigo;
import entidades.abstractas.ObjetoVida;
import entidades.concretas.BarricadaConPinches;

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
	
	public void visit(BarricadaConPinches entidad) {
		en.recibirDaño(50);
	}

}
