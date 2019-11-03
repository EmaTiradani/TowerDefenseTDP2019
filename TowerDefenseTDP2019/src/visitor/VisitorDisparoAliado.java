package visitor;

import GUI.Gui;
import entidades.abstractas.Aliado;
import entidades.abstractas.Disparo;
import entidades.abstractas.Enemigo;
import entidades.abstractas.Entidad;
import entidades.abstractas.ObjetoVida;

/**
 * Visitor utilizado para la interacción de los disparos realizados por aliados.
 *
 */
public class VisitorDisparoAliado extends Visitor{
	
	protected Disparo d;
	
	/**
	 * Crea el visitor.
	 * @param d - El disparo que crea el visitor
	 */
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
