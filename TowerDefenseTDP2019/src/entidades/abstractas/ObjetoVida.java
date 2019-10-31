package entidades.abstractas;

import visitor.Visitor;

/**
 * Tipo de objeto que tiene puntos de vida, y por lo tanto puede ser atacado por los personajes enemigos.
 *
 */
public abstract class ObjetoVida extends Entidad implements Atacable {
	
	protected int vidaMaxima;
	protected float vidaActual;

	/**
	 * Crea un objeto en una posici�n.
	 * @param x - La columna donde se crea el objeto
	 * @param y - La fila donde se crea el objeto
	 * @param vida - La vida con la que comienza el objeto
	 */
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
	
	public int getValor() {
		return 0;
	}

}
