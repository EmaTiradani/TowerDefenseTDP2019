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

	public float getDa�o(float da�oBase) {
		return da�oBase;
	}

	public int getVelocidad(int velBase) {
		return velBase*2;
	}

	public float recibirDa�o(float da�oBase) {
		return da�oBase;
	}

}
