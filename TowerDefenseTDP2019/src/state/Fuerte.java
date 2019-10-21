package state;

public class Fuerte extends Estado {

	public Fuerte() {		
	}
	
	public float getDaño(float dañoBase) {
		return dañoBase*1.5f;
	}

	public int getVelocidad(int velBase) {
		return velBase;
	}

	public float recibirDaño(float dañoBase) {
		return dañoBase;
	}

}
