package state;

public class Normal extends Estado {
	
	public Normal() {		
	}

	public float getDa�o(float da�oBase) {
		return da�oBase;
	}

	public int getVelocidad(int velBase) {
		return velBase;
	}
	
	public float recibirDa�o(float da�oBase) {
		return da�oBase;
	}

}
