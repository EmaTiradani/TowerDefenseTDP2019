package entidades.abstractas;

import GUI.Gui;
import juego.Juego;
import visitor.Visitor;
import visitor.VisitorAliado;

/**
 * Representa a un personaje aliado.
 * Es el elemento primario que utilia el jugador para defenderse de los personajes enemgios. *
 */
public abstract class Aliado extends Personaje {
	
	protected int alcance;
	protected int coste;

	/**
	 * Crea un aliado en una posición.
	 * @param x - La columna donde se crea el personaje
	 * @param y - La fila donde se crea el personaje
	 * @param vida - La vida maxima del personaje
	 * @param cooldown - El tiempo que tiene que esperar para poder realizar una ataque.
	 * @param alcance - El alcance del personaje. Esto determina qué tan lejos puede disparar a los enemgios
	 * @param coste - El coste de compra del personaje
	 */
	protected Aliado(int x, int y, int vida, int cooldown, int alcance, int coste) {
		super(x, y, vida, cooldown);
		this.alcance = alcance;
		this.coste = coste;
		setVisitor();
	}
	
	public int getValor() {
		return coste;
	}
	
	/**
	 * Inicializa el Visitor del aliado. Usado durante la creación del objeto.
	 */
	protected void setVisitor() {
		miVisitor = new VisitorAliado(this);
	}
	
	public void accept(Visitor v) {
		v.visit(this);
	}

	public void accion(float estimatedTime) {
		cooldownActual -= estimatedTime;
		actualizarEstado(estimatedTime);
		Entidad e;
		for (int i=1; i<=alcance; i++) {
			e = Juego.getJuego().getEntidad(x/Gui.spriteSize + i, y/Gui.spriteSize);					
			if (e!=null) {
				e.accept(miVisitor);
			}
		}		
	}

	/**
	 * Si el personaje puede disparar, crea un nuevo disparo
	 */
	public void disparar() {
		if (cooldownActual<=0) {
			Juego.getJuego().agregarEntidad(this.crearDisparo());
			cooldownActual = cooldownAtaque;
		}		
	}
	
	/**
	 * Crea y retorna el disparo. Cada clase concreta que herede de Aliado deber definir qué tipo de disparo creará.
	 * @return El disparo
	 */
	protected abstract Disparo crearDisparo();
}
