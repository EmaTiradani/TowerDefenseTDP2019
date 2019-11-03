package state;

/**
 * Tipo de estado que incrementa el da�o realizado.
 */
public class Fuerte extends Estado {

	/**
	 * Crea un estado Fuerte.
	 */
	public Fuerte() {		
	}
	
	public float getDa�o(float da�oBase) {
		return da�oBase*1.5f;
	}

	public int getVelocidad(int velBase) {
		return velBase;
	}

	public float recibirDa�o(float da�oBase) {
		return da�oBase;
	}
	
	public int getValor() {
		return 20;
	}

}
