package state;

public class Lento extends Estado {
	
	public Lento() {		
	}

	public float getDaño(float dañoBase) {
		return dañoBase;
	}

	public int getVelocidad(int velBase) {
		return velBase/2;
	}

	public float recibirDaño(float dañoBase) {
		return dañoBase;
	}

}
