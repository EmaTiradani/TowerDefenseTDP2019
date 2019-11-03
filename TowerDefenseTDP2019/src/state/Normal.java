package state;

/**
 * Tipo de estado normal. Es utilizado cuando la entida no tiene ning�n estado.
 *
 */
public class Normal extends Estado {
	
	/**
	 * Crea un estado Normal.
	 */
	public Normal() {		
	}

	public float getDa�o(float da�oBase) {
		return da�oBase;
	}

	public int getVelocidad(int velBase) {
		return velBase;
	}
	
	public float recibirDa�o(float da�oBase) {
		return da�oBase;
	}

}
