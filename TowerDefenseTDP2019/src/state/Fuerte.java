package state;

public class Fuerte extends Estado {

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

}
