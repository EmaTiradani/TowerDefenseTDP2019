package state;

/**
 * Tipo de estado que incrementa el daño realizado.
 */
public class Fuerte extends Estado {

	/**
	 * Crea un estado Fuerte.
	 */
	public Fuerte() {		
	}
	
	public float getDaño(float dañoBase) {
		return dañoBase*1.5f;
	}

	public int getVelocidad(int velBase) {
		return velBase;
	}

	public float recibirDaño(float dañoBase) {
		return dañoBase;
	}
	
	public int getValor() {
		return 20;
	}

}
