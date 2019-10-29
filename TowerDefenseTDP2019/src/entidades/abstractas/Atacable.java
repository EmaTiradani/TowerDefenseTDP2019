package entidades.abstractas;

/**
 * Intefaz que se utiliza para determina si un objeto puede recibir un ataque.
 * Toda clase que puede recibir da�o a partir de un ataque debe implementar esta interfaz.
 *
 */
public interface Atacable {

	/**
	 * Recibe da�o, el cual se refleja en la p�rdida de puntos de vida.
	 * @param da�o - El da�o recibido
	 */
	public void recibirDa�o(float da�o);
	
}
