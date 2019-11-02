package visitor;

import entidades.abstractas.Aliado;
import entidades.abstractas.Enemigo;
import entidades.abstractas.ObjetoVida;
import state.Estado;

/**
 * Visitor que asigna un estado temporal a las entidades de tipo Enemigo.
 *
 */
public class VisitorDebuff extends Visitor {
	
	public Estado debuff;
	
	/**
	 * Crea un visitor con un estado que asigna a los enemigos
	 * @param e - El estado
	 */
	public VisitorDebuff(Estado e) {
		debuff = e;
	}

	public void visit(Aliado entidad) {		
	}
	
	public void visit(Enemigo entidad) {
		entidad.setEstado(debuff, 10);		
	}
	
	public void visit(ObjetoVida entidad) {	
	}

}
