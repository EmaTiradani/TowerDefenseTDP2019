package state;

public class Proteccion extends Estado {

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
