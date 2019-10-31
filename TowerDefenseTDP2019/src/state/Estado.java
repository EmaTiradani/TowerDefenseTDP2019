package state;

/**
 * Clase que representa un estado que se puede asignar a una entidad.
 * En particular, los estado son utilizados en personajes y disparos.
 * El efecto del estado puede ser positivo o negativo, afectando el da�o, velocidad y/o la resistencia al da�o de otras entidades.
 */
public abstract class Estado {
	
	/**
	 * Dado el da�o base de una entidad, retorna el da�o total agregando el efecto del estado.
	 * @param da�oBase - El da�o base de la entidad
	 * @return El da�o total
	 */
	public abstract float getDa�o(float da�oBase);
	
	/**
	 * Dada la velocida base de una entidad, retorna la velocidad total agregando el efecto del estado.
	 * @param velBase - La velocidad base de la entidad
	 * @return La velocidad total
	 */
	public abstract int getVelocidad(int velBase);
	
	/**
	 * Dado un da�o base que recibe una entidad, retorna el da�o final que recibir� la entidad.
	 * @param da�oBase - El da�o base que recibir�a la entidad
	 * @return El da�o total que recibir� la entidad
	 */
	public abstract float recibirDa�o(float da�oBase);
	
	/**
	 * Retorna el valor del estado.
	 * @return El valor
	 */
	public int getValor() {
		return 0;
	}

}
