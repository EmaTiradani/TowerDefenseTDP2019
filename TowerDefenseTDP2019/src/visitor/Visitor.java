package visitor;

import entidades.abstractas.Aliado;
import entidades.abstractas.Enemigo;
import entidades.abstractas.ObjetoVida;

/**
 * Clase utilziada por entidades para interactuar con otras.
 * En particular, el Visitor permite interactuar con aliados, enemigos y objetos con vida.
 * Cada implementación de Visitor permite una interacción diferente con cada tipo de entidad.
 *
 */
public abstract class Visitor {

	/**
	 * Visita una entidad de tipo Aliado.
	 * @param entidad - La entidad visitada
	 */
	public abstract void visit(Aliado entidad);
	
	/**
	 * Visita una entidad de tipo Enemigo.
	 * @param entidad - La entidad visitada
	 */
	public abstract void visit(Enemigo entidad);

	/**
	 * Visita una entidad de tipo ObjetoVida.
	 * @param entidad - La entidad visitada
	 */
	public abstract void visit(ObjetoVida entidad);

}
