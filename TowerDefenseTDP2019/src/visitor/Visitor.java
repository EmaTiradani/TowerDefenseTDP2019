package visitor;

import entidades.Aliado;
import entidades.Personaje;

public abstract class Visitor {

	public abstract boolean visit(Aliado entidad);
	
	public abstract boolean visit(Personaje entidad);

}
