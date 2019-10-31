package state;

/**
 * Tipo de estado que decrece la velocidad de movimiento.
 *
 */
public class Lento extends Estado {
	
	/**
	 * Crea un estado Lento.
	 */
	public Lento() {		
	}

	public float getDaño(float dañoBase) {
		return dañoBase;
	}

	public int getVelocidad(int velBase) {
		return velBase/2;
	}

	public float recibirDaño(float dañoBase) {
		return dañoBase;
	}
	
	public int getValor() {
		return 10;
	}

}
