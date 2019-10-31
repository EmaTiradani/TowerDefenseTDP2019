package entidades.abstractas;

import state.Estado;
import visitor.Visitor;

/**
 * Clase que representa los disparos que realizan los personajes.
 * Por cada clase concreta que hereda de Personaje que pueda atacar a distancia, debe haber una clase concreta que herede de Disparo asociada a ese persoaje.
 */
public abstract class Disparo extends Entidad {
	
	protected float dmg;
	protected int velocidad;
	protected int target; //Punto maximo donde puede llegar el disparo
	protected Estado estado;
	
	/**
	 * Crea un disparo en una posici�n.
	 * @param x - La columna donde se crea el disparo
	 * @param y - La fila donde se crea el disparo
	 * @param dmg - El da�o que realiza el disparo cuando impacta contra su objetivo
	 * @param velocidad - La velocida de movimiento del disparo
	 * @param estado - El estado del disparo. Esto puede afectar su velocidad y/o da�o.
	 */
	protected Disparo(int x, int y, int dmg, int velocidad, Estado estado) {
		super(x, y);		
		this.dmg = dmg;
		this.velocidad = velocidad;
		this.estado = estado;
	}	
	
	public void accept(Visitor v) {		
		
	}

	/**
	 * Retorna el da�o que realiza el disparo.
	 * @return El da�o del disparo
	 */
	public float getDa�o() {
		return estado.getDa�o(dmg);		
	}
	
	/**
	 * Este m�todo se encarga de mover al disparo. Debe ser llamado continuamente hasta que impacte contra un objetivo o llegue a su l�mite de alcance.
	 */
	public abstract void mover();
	
	public int getValor() {
		return 0;
	}

}
