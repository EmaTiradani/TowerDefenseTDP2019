package entidades;

import javax.swing.JLabel;

import juego.Celda;
import visitor.Visitor;

public abstract class Disparo extends Entidad {
	
	protected JLabel sprite;
	protected int x;
	protected int y;
	protected int dmg;
	protected int velocidad;
	protected Celda estaCelda;
	
	protected Disparo(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accion(float estimatedTime) {
		// TODO Auto-generated method stub

	}

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub

	}

}
