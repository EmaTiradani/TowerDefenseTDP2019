package state;

public class Normal extends Estado {
	
	public Normal() {		
	}

	public int getDa�o(int da�oBase) {
		return da�oBase;
	}

	public int getVelocidad(int velBase) {
		return velBase;
	}
	
	public int recibirDa�o(int da�oBase) {
		return da�oBase;
	}

}
