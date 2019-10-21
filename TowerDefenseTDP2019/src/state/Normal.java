package state;

public class Normal extends Estado {
	
	public Normal() {		
	}

	public int getDaño(int dañoBase) {
		return dañoBase;
	}

	public int getVelocidad(int velBase) {
		return velBase;
	}
	
	public int recibirDaño(int dañoBase) {
		return dañoBase;
	}

}
