package visitor;

import entidades.abstractas.Aliado;
import entidades.abstractas.Enemigo;
import entidades.abstractas.ObjetoVida;
import state.Estado;

/**
 * Visitor que asigna un estado temporal a las entidades de tipo Aliado.
 *
 */
public class VisitorBuff extends Visitor {
	
	protected Estado buff;
	
	/**
	 * Crea un visitor con un estado que asigna a los aliados
	 * @param estado - El estado
	 */
	public VisitorBuff(Estado estado) {
		buff = estado;
	}

	public void visit(Aliado entidad) {
		entidad.setEstado(buff, 10);
	}

	public void visit(Enemigo entidad) {
	}

	public void visit(ObjetoVida entidad) {
	}

}
