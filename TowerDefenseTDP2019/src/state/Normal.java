package state;

public class Normal extends Estado {
	
	public Normal() {		
	}

	public float getDaño(float dañoBase) {
		return dañoBase;
	}

	public int getVelocidad(int velBase) {
		return velBase;
	}
	
	public float recibirDaño(float dañoBase) {
		return dañoBase;
	}

}
