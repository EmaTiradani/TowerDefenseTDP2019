package state;

public abstract class Estado {
	
	public abstract float getDaño(float dañoBase);
	
	public abstract int getVelocidad(int velBase);
	
	public abstract float recibirDaño(float dañoBase);
	
	public int getCoste() {
		return 0;
	}

}
