package visitor;

import entidades.Aliado;
import entidades.Enemigo;
import entidades.ObjetoVida;
import personajes.Barricada;
import personajes.BarricadaConPinches;

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
		en.recibirDaņo(50);
	}

}
