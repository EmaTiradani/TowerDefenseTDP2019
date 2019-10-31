package state;

/**
 * Tipo de estado normal. Es utilizado cuando la entida no tiene ningún estado.
 *
 */
public class Normal extends Estado {
	
	/**
	 * Crea un estado Normal.
	 */
	public Normal() {		
	}

	public float getDaño(float dañoBase) {
		return dañoBase;
	}

	public int getVelocidad(int velBase) {
		return velBase;
	}
	
	public float recibirDaño(float dañoBase) {
		return dañoBase;
	}

}
