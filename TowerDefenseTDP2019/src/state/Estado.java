package state;

/**
 * Clase que representa un estado que se puede asignar a una entidad.
 * En particular, los estado son utilizados en personajes y disparos.
 * El efecto del estado puede ser positivo o negativo, afectando el daño, velocidad y/o la resistencia al daño de otras entidades.
 */
public abstract class Estado {
	
	/**
	 * Dado el daño base de una entidad, retorna el daño total agregando el efecto del estado.
	 * @param dañoBase - El daño base de la entidad
	 * @return El daño total
	 */
	public abstract float getDaño(float dañoBase);
	
	/**
	 * Dada la velocida base de una entidad, retorna la velocidad total agregando el efecto del estado.
	 * @param velBase - La velocidad base de la entidad
	 * @return La velocidad total
	 */
	public abstract int getVelocidad(int velBase);
	
	/**
	 * Dado un daño base que recibe una entidad, retorna el daño final que recibirá la entidad.
	 * @param dañoBase - El daño base que recibiría la entidad
	 * @return El daño total que recibirá la entidad
	 */
	public abstract float recibirDaño(float dañoBase);
	
	/**
	 * Retorna el valor del estado.
	 * @return El valor
	 */
	public int getValor() {
		return 0;
	}

}
