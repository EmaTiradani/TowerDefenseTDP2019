package entidades;

import GUI.Gui;
import visitor.Visitor;

public abstract class Disparo extends Entidad {
	
	protected int dmg;
	protected int velocidad;
	protected int target; //Punto maximo donde puede llegar el disparo
	
	protected Disparo(int x, int y, int dmg, int velocidad) {
		super(x, y);
		this.x += Gui.spriteSize/2; //Ubica el inicio del disparo en el centro de la celda
		this.dmg = dmg;
		this.velocidad = velocidad;
	}	
	
	public void accept(Visitor v) {		
		
	}

	public int getDa�o() {
		return dmg;		
	}
	
	public abstract void mover();

}
