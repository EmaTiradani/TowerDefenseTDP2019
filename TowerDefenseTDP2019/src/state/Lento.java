package state;

public class Lento extends Estado {
	
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

}
