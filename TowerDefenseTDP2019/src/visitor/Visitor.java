package visitor;

import entidades.abstractas.Aliado;
import entidades.abstractas.Enemigo;
import entidades.abstractas.ObjetoVida;

public abstract class Visitor {

	public abstract void visit(Aliado entidad);
	
	public abstract void visit(Enemigo entidad);

	public abstract void visit(ObjetoVida entidad);

}
