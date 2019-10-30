package visitor;

import GUI.Gui;
import entidades.abstractas.Aliado;
import entidades.abstractas.DisparoEnemigo;
import entidades.abstractas.Enemigo;
import entidades.abstractas.Entidad;
import entidades.abstractas.ObjetoVida;

public class VisitorDisparoEnemigo extends Visitor {
	
	DisparoEnemigo d;

	public VisitorDisparoEnemigo(DisparoEnemigo d) {
		this.d = d;
	}

	public void visit(Aliado entidad) {
		if (hayColision(entidad)) {
			entidad.recibirDaño(d.getDaño());
			d.morir();
		}
	}

	public void visit(Enemigo entidad) {
	}

	public void visit(ObjetoVida entidad) {
		if (hayColision(entidad)) {
			entidad.recibirDaño(d.getDaño());
			d.morir();
		}
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
