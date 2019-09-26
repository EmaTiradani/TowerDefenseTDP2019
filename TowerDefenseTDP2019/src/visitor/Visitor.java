package visitor;

import entidades.Aliado;
import entidades.Enemigo;

public abstract class Visitor {

	public abstract void visit(Aliado entidad);
	
	public abstract void visit(Enemigo entidad);

}
