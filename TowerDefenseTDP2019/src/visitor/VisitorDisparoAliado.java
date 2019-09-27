package visitor;

import entidades.Aliado;
import entidades.DisparoAliado;
import entidades.Enemigo;

public class VisitorDisparoAliado extends Visitor{
	
	protected DisparoAliado d;
	

	@Override
	public void visit(Aliado entidad) {
		d.mover();
	}

	@Override
	public void visit(Enemigo entidad) {
		entidad.recibirDaño(d.getDaño());
		d.morir();
	}
	
	
}
