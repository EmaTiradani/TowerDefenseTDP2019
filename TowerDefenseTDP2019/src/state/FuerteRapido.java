package state;

public class FuerteRapido extends Estado {

	public float getDaño(float dañoBase) {
		return dañoBase*2;
	}

	public int getVelocidad(int velBase) {
		return velBase*2;
	}

	public float recibirDaño(float dañoBase) {
		return dañoBase;
	}

}
