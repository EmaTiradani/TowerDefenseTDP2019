package state;

public class Rapido extends Estado {
	
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
