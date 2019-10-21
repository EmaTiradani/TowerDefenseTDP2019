package entidades;

import GUI.Gui;
import state.Estado;
import visitor.Visitor;

public abstract class Disparo extends Entidad {
	
	protected int dmg;
	protected int velocidad;
	protected int target; //Punto maximo donde puede llegar el disparo
	protected Estado estado;
	
	protected Disparo(int x, int y, int dmg, int velocidad, Estado estado) {
		super(x, y);
		this.x += Gui.spriteSize/2; //Ubica el inicio del disparo en el centro de la celda
		this.dmg = dmg;
		this.velocidad = velocidad;
		this.estado = estado;
	}	
	
	public void accept(Visitor v) {		
		
	}

	public int getDaño() {
		return dmg;		
	}
	
	public abstract void mover();
	
	public int getCoste() {
		return 0;
	}

}
