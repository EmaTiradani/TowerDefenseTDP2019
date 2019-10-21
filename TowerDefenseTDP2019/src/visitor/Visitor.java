package visitor;

import entidades.Enemigo;
import entidades.ObjetoVida;
import entidades.Personaje;

public abstract class Visitor {

	public abstract void visit(Personaje entidad);
	
	public abstract void visit(Enemigo entidad);

	public abstract void visit(ObjetoVida entidad);

}
