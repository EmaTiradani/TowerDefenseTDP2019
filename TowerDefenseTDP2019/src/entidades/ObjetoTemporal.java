package entidades;

import visitor.Visitor;

public abstract class ObjetoTemporal extends Objeto {
	
	protected float tiempoVida;
	protected int tiempoLimite;

	protected ObjetoTemporal(int x, int y, int tiempo) {
		super(x, y);
		tiempoVida = 0;
		tiempoLimite = tiempo;
	}
	
	public void accion(float estimatedTime) {
		tiempoVida += estimatedTime;
		if (tiempoVida>=tiempoLimite) {
			morir();
		}
	}

	public void accept(Visitor v) {
	}

}
