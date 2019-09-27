package visitor;

import entidades.Aliado;
import entidades.DisparoAliado;
import entidades.Enemigo;
import entidades.ObjetoVida;

public class VisitorDisparoAliado extends Visitor{
	
	protected DisparoAliado d;
	
	public void visit(Aliado entidad) {
		d.mover();
	}

	public void visit(Enemigo entidad) {
		entidad.recibirDa�o(d.getDa�o());
		d.morir();
	}

	public void visit(ObjetoVida entidad) {
	}
	
	
}
