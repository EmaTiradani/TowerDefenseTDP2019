package visitor;

import entidades.Aliado;
import entidades.Enemigo;
import entidades.ObjetoVida;

public abstract class Visitor {

	public abstract void visit(Aliado entidad);
	
	public abstract void visit(Enemigo entidad);

	public abstract void visit(ObjetoVida entidad);

}
