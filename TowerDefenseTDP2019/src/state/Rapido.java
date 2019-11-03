package state;

/**
 * Tipo de estado que incrementa la velocidad de movimiento.
 *
 */
public class Rapido extends Estado {
	
	/**
	 * Crea un estado Rapido
	 */
	public Rapido() {		
	}

	public float getDaño(float dañoBase) {
		return dañoBase;
	}

	public int getVelocidad(int velBase) {
		return velBase*2;
	}

	public float recibirDaño(float dañoBase) {
		return dañoBase;
	}

}
