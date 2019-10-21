package visitor;

import GUI.Gui;
import entidades.Disparo;
import entidades.Enemigo;
import entidades.Entidad;
import entidades.ObjetoVida;
import entidades.Personaje;

public class VisitorDisparoAliado extends Visitor{
	
	protected Disparo d;
	
	public VisitorDisparoAliado(Disparo d) {
		this.d = d;
	}
	
	public void visit(Personaje entidad) {
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
