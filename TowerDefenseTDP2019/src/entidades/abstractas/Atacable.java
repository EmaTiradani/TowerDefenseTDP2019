package entidades.abstractas;

/**
 * Intefaz que se utiliza para determina si un objeto puede recibir un ataque.
 * Toda clase que puede recibir daño a partir de un ataque debe implementar esta interfaz.
 *
 */
public interface Atacable {

	/**
	 * Recibe daño, el cual se refleja en la pérdida de puntos de vida.
	 * @param daño - El daño recibido
	 */
	public void recibirDaño(float daño);
	
}
