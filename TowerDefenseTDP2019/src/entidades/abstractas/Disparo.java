package entidades.abstractas;

import state.Estado;
import visitor.Visitor;

public abstract class Disparo extends Entidad {
	
	protected float dmg;
	protected int velocidad;
	protected int target; //Punto maximo donde puede llegar el disparo
	protected Estado estado;
	
	protected Disparo(int x, int y, int dmg, int velocidad, Estado estado) {
		super(x, y);		
		this.dmg = dmg;
		this.velocidad = velocidad;
		this.estado = estado;
	}	
	
	public void accept(Visitor v) {		
		
	}

	public float getDaño() {
		return estado.getDaño(dmg);		
	}
	
	public abstract void mover();
	
	public int getValor() {
		return 0;
	}
	
	public void setEstado(Estado e) {
		estado = e;
	}

}
