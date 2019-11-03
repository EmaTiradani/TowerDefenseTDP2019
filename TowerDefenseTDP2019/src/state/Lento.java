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

	public float getDa�o(float da�oBase) {
		return da�oBase;
	}

	public int getVelocidad(int velBase) {
		return velBase/2;
	}

	public float recibirDa�o(float da�oBase) {
		return da�oBase;
	}
	
	public int getValor() {
		return 10;
	}

}
