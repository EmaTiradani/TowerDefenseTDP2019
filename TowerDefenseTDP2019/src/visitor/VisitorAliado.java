package visitor;

import entidades.Aliado;
import entidades.Enemigo;
import entidades.Personaje;

public class VisitorAliado extends Visitor {

	@Override
	public boolean visit(Aliado entidad) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visit(Enemigo entidad) {
		// TODO Auto-generated method stub
		return false;
	}

}
