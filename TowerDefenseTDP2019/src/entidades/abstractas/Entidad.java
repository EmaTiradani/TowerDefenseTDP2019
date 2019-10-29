package entidades.abstractas;

import javax.swing.JLabel;

import GUI.Gui;
import juego.Juego;
import visitor.Visitor;

/**
 * Clase que representa todos los objetos que aparecen en el juego.
 *
 */
public abstract class Entidad {
	
	protected JLabel sprite;
	protected int x;
	protected int y;
	protected Visitor miVisitor;
	
	/**
	 * Crea una entidad en una posicion. Las coodernadas se refieren a la fila y columan donde se colocar� la entidad a crear.
	 * @param x - La columna donde se crea la entidad
	 * @param y - La fila donde se crea la entidad
	 */
	protected Entidad(int x, int y) {
		this.x = x*Gui.spriteSize;
		this.y = y*Gui.spriteSize;
		
	}
	
	/**
	 * Retorna el componente gr�fico de la entidad
	 * @return El componene gr�fico
	 */
	public JLabel getSprite() {
		return sprite;
	}	

	/**
	 * Retorna la coordenada x (en pixeles) de la entidad
	 * @return La coordenada x de la entidad
	 */
	public int getX() {
		return x;
	}

	/**
	 * Retorna la coordenada y (en pixeles) de la entidad
	 * @return La coordenada y de la entidad
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Retorna el valor de la entidad.
	 * Cada entidad tiene un valor num�rico que, dependiendo del tipo de entidad, puede ser utilizado para ciertas cosas,
	 * como el precio de crear el objeto, o el puntaje al eliminarlo del juego.
	 * @return El valor de la entidad
	 */
	public abstract int getValor();

	/**
	 * Realiza una acci�n.
	 * @param estimatedTime - El tiempo que pas� desde la ultima vez que se llam� a este m�todo.
	 * 	Si es la primera vez que se lo llama, el valor es el tiempo transcurrido desde el inicio de la creaci�n del objeto.
	 */
	public abstract void accion(float estimatedTime);
	
	/**
	 * Aceptar un Visitor de otra entidad y lo visita.
	 * @param v - El visitor de otra entidad.
	 */
	public abstract void accept(Visitor v);
	
	/**
	 * Destruye la entidad, tanto en la l�gica como en la GUI.
	 */
	public void morir() {
		Juego.getJuego().matar(this);
	}
	
}