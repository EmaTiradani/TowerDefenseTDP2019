package state;

/**
 * Tipo de estado que reduce el da�o recibido.
 *
 */
public class Proteccion extends Estado {

	/**
	 * Crea un estado Proteccion.
	 */
	public Proteccion() {		
	}
	
	public float getDa�o(float da�oBase) {
		return da�oBase;
	}

	public int getVelocidad(int velBase) {
		return velBase;
	}

	public float recibirDa�o(float da�oBase) {
		return da�oBase/2;
	}

}
