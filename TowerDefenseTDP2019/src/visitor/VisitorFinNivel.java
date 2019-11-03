package visitor;

import entidades.abstractas.Aliado;
import entidades.abstractas.Enemigo;
import entidades.abstractas.ObjetoVida;

/**
 * Visitor que determina cuántos enemigos hay en el mapa actualemente.
 * Una vez que este visitor visita todas las entidades, se puede utilizar getCantidad() para determinar
 * cuántos enemigos hay. Una vez realizado este procedimiento, si se quiere realizar otra visita a las mismas entidades
 * para volver a contar a los enemigos, se deber usar resetCantidad() para reiniciar el contador.
 *
 */
public class VisitorFinNivel extends Visitor {
	
	protected int cantidad;
	
	/**
	 * Crea el visitor.
	 */
	public VisitorFinNivel() {
		cantidad = 0;
	}

	public void visit(Aliado entidad) {		
	}

	public void visit(Enemigo entidad) {
		cantidad++;
	}

	public void visit(ObjetoVida entidad) {
	}
	
	/**
	 * Retorna la cantidad de enemigos que se contaron hasta ahora.
	 * @return Enemigos contados
	 */
	public int getCantidad() {
		return cantidad;
	}
	
	/**
	 * Reincia el contador de enemigos a cero.
	 */
	public void resetCantidad() {
		cantidad = 0;
	}

}
