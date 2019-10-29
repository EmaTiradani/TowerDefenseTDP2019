package entidades.abstractas;

public abstract class Objeto extends Entidad {

	protected Objeto(int x, int y) {
		super(x, y);
	}

	public int getCoste() {
		return 0;
	}
	
}
