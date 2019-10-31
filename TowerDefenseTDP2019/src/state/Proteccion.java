package state;

/**
 * Tipo de estado que reduce el daño recibido.
 *
 */
public class Proteccion extends Estado {

	/**
	 * Crea un estado Proteccion.
	 */
	public Proteccion() {		
	}
	
	public float getDaño(float dañoBase) {
		return dañoBase;
	}

	public int getVelocidad(int velBase) {
		return velBase;
	}

	public float recibirDaño(float dañoBase) {
		return dañoBase/2;
	}

}
