package visitor;

import GUI.Gui;
import entidades.abstractas.Aliado;
import entidades.abstractas.Disparo;
import entidades.abstractas.Enemigo;
import entidades.abstractas.Entidad;
import entidades.abstractas.ObjetoVida;

public class VisitorDisparoAliado extends Visitor{
	
	protected Disparo d;
	
	public VisitorDisparoAliado(Disparo d) {
		this.d = d;
	}
	
	public void visit(Aliado entidad) {
	}

	public void visit(Enemigo entidad) {	
		if (hayColision(entidad)) {
			entidad.recibirDaño(d.getDaño());
			d.morir();
		}
	}

	public void visit(ObjetoVida entidad) {
	}
	
	
	protected boolean hayColision(Entidad e) {
		boolean colision = false;
		if (e.getY()==d.getY()) {
			int delta = Math.abs(d.getX()-e.getX());
			colision = delta<Gui.spriteSize/2;
		}
		
		return colision;
	}
	
}
