package entidades;

import visitor.Visitor;

public abstract class Disparo extends Entidad {
	
	protected int dmg;
	protected int velocidad;
	protected int target; //Punto maximo donde puede llegar el disparo
	
	protected Disparo(int x, int y, int dmg, int velocidad) {
		super(x, y);
		this.dmg = dmg;
		this.velocidad = velocidad;
	}	
	
	public void accept(Visitor v) {		
		
	}

	public int getDaño() {
		return dmg;		
	}
	
	public abstract void mover();

}
