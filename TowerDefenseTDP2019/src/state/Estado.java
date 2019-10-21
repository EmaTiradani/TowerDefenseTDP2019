package state;

public abstract class Estado {
	
	public abstract int getDaño(int dañoBase);
	
	public abstract int getVelocidad(int velBase);
	
	public abstract int recibirDaño(int dañoBase);

}
