package entidades;

import visitor.Visitor;

public abstract class ObjetoVida extends Objeto implements Atacable {
	
	protected int vidaMaxima;
	protected float vidaActual;

	protected ObjetoVida(int x, int y, int vida) {
		super(x, y);
		vidaMaxima = vida;
		vidaActual = vida;		
	}

	public void accept(Visitor v) {
		v.visit(this);
	}

	public void recibirDaño(float daño) {
		vidaActual -= daño;
		if (vidaActual<=0) {
			morir();
		}
	}
	public void hacerDaño(float daño) {
		
	}

}
