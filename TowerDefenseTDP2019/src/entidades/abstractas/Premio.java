package entidades.abstractas;

import java.awt.event.MouseListener;

import listeners.PremioListener;
import visitor.Visitor;

/**
 * Tipo de entidad que el jugador puede obtener, otorgando algun beneficio.
 * Es posible su aparición cuando un enemigo muere. 
 *
 */
public abstract class Premio extends Entidad {

	/**
	 * Crea un premio en una posición.
	 * @param x - La columna donde se crea el premio
	 * @param y - La fila donde se crea el objeto
	 */
	protected Premio(int x, int y) {
		super(x, y);
	}

	public void accion(float estimatedTime) {
	}

	public void accept(Visitor v) {
	}
	
	public void morir() {
		super.morir();
		activarEffecto();
	}
	
	/**
	 * Activa el efecto del premio. Este efecto puede ser temporal o inmediato.
	 */
	protected abstract void activarEffecto();
	
	/**
	 * Debido a que el premio solo se activa si el jugador realiza un click en el,
	 * en la creación del objeto se debe llamar a este método, que agrega un MouseListener al
	 * componente gráfico que representa el premio.
	 */
	protected void agregarListener() {
		MouseListener ml = new PremioListener(this);
		sprite.addMouseListener(ml);
	}
	
	public int getValor() {
		return 0;
	}

}
