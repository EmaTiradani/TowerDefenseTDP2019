package state;

public abstract class Estado {
	
	public abstract float getDa�o(float da�oBase);
	
	public abstract int getVelocidad(int velBase);
	
	public abstract float recibirDa�o(float da�oBase);
	
	public int getCoste() {
		return 0;
	}

}
