package state;

public class Proteccion extends Estado {

	public Proteccion() {		
	}
	
	public float getDaño(float dañoBase) {
		return dañoBase;
	}

	public int getVelocidad(int velBase) {
		return velBase;
	}

	public float recibirDaño(float dañoBase) {
		return dañoBase/2;
	}

}
