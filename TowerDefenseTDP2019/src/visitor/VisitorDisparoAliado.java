package visitor;

import GUI.Gui;
import entidades.Aliado;
import entidades.DisparoAliado;
import entidades.Enemigo;
import entidades.ObjetoVida;

public class VisitorDisparoAliado extends Visitor{
	
	protected DisparoAliado d;
	
	public VisitorDisparoAliado(DisparoAliado d) {
		this.d = d;
	}
	
	public void visit(Aliado entidad) {
	}

	public void visit(Enemigo entidad) {
		if (entidad.getY()==d.getY()) {
			int delta = Math.abs(d.getX()-entidad.getX());
			if (delta<Gui.spriteSize) {
				entidad.recibirDaño(d.getDaño());
				d.morir();
			}
		}
	}

	public void visit(ObjetoVida entidad) {
	}
	
	
}
