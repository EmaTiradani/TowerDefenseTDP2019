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

	public void recibirDa�o(float da�o) {
		vidaActual -= da�o;
		if (vidaActual<=0) {
			morir();
		}
	}
	public void hacerDa�o(float da�o) {
		
	}

}
