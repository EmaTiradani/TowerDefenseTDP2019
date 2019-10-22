package state;

public class FuerteRapido extends Estado {

	public float getDa�o(float da�oBase) {
		return da�oBase*2;
	}

	public int getVelocidad(int velBase) {
		return velBase*2;
	}

	public float recibirDa�o(float da�oBase) {
		return da�oBase;
	}

}
