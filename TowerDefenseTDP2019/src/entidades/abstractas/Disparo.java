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
	 * Crea un disparo en una posición.
	 * @param x - La columna donde se crea el disparo
	 * @param y - La fila donde se crea el disparo
	 * @param dmg - El daño que realiza el disparo cuando impacta contra su objetivo
	 * @param velocidad - La velocida de movimiento del disparo
	 * @param estado - El estado del disparo. Esto puede afectar su velocidad y/o daño.
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
	 * Retorna el daño que realiza el disparo.
	 * @return El daño del disparo
	 */
	public float getDaño() {
		return estado.getDaño(dmg);		
	}
	
	/**
	 * Este método se encarga de mover al disparo. Debe ser llamado continuamente hasta que impacte contra un objetivo o llegue a su límite de alcance.
	 */
	public abstract void mover();
	
	public int getValor() {
		return 0;
	}

}
