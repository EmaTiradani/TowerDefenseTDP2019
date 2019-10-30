package visitor;

import entidades.abstractas.Aliado;
import entidades.abstractas.Enemigo;
import entidades.abstractas.ObjetoVida;

public class VisitorFinNivel extends Visitor {
	
	protected int cantidad;
	
	public VisitorFinNivel() {
		cantidad = 0;
	}

	public void visit(Aliado entidad) {		
	}

	public void visit(Enemigo entidad) {
		cantidad++;
	}

	public void visit(ObjetoVida entidad) {
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cant) {
		cantidad = cant;
	}

}
