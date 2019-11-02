package visitor;

import GUI.Gui;
import entidades.abstractas.Aliado;
import entidades.abstractas.DisparoEnemigo;
import entidades.abstractas.Enemigo;
import entidades.abstractas.Entidad;
import entidades.abstractas.ObjetoVida;

/** 
 * Visitor utilizado para la interacción de los disparos realizados por enemigos. 
 */
public class VisitorDisparoEnemigo extends Visitor {
	
	DisparoEnemigo d;

	/**
	 * Crea el visitor.
	 * @param d - El disparo que crea el visitor
	 */
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

	/**
	 * Determina si hay una colisión entre el disparo y la entidad e
	 * @param e - La entidad con la que se verifica la colisión
	 * @return Verdadero si hay colisión. Falso en cualquier otro caso.
	 */
	protected boolean hayColision(Entidad e) {
		boolean colision = false;
		if (e.getY()==d.getY()) {
			int delta = Math.abs(d.getX()-e.getX());
			colision = delta<Gui.spriteSize/2;
		}
		
		return colision;
	}	
	
}
