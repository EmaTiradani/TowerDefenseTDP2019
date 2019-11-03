package entidades.abstractas;

import java.util.Random;
import javax.swing.Icon;
import GUI.Gui;
import entidades.concretas.PremioBomba;
import entidades.concretas.PremioOro;
import entidades.concretas.PremioProteccion;
import entidades.concretas.PremioRestaurar;
import entidades.concretas.PremioVelocidad;
import juego.Juego;
import visitor.Visitor;
import visitor.VisitorEnemigo;

/**
 * Representa a un personaje enemigo. Este se encarga de atacar a los personajes del jugador, y puede causar la derrota del mismo.
 *
 */
public abstract class Enemigo extends Personaje {
	
	protected int velocidad;
	protected int puntaje;
	protected Icon spriteMovimiento;
	protected Icon spriteAtaque;

	/**
	 * Crea un enemigo en una posición.
	 * @param x - La columna donde se crea el personaje
	 * @param y - La fila donde se crea el personaje
	 * @param vida - La vida maxima del personaje
	 * @param vel - La velocidad de movimiento del personaje
	 * @param cooldown - El tiempo que tiene que esperar para poder realizar una ataque
	 * @param puntaje - El puntaje que otorga al jugador cuando se muere
	 */
	protected Enemigo(int x, int y, int vida, int vel, int cooldown, int puntaje) {
		super(x, y, vida, cooldown);
		velocidad = vel;
		this.puntaje = puntaje;
		setVisitor();
	}
	
	/**
	 * Inicializa el Visitor del enemigo. Usado durante la creación del objeto.
	 */
	protected void setVisitor() {
		miVisitor = new VisitorEnemigo(this);
	}

	public void accept(Visitor v) {
		v.visit(this);
	}	
	
	public void morir() {
		super.morir();
		Juego.getJuego().sumarPuntos(puntaje);
		
		Random r = new Random();
		int value = r.nextInt(100);
		if (value<15) {
			Juego.getJuego().agregarEntidad(dropPremio());
		}
	}

	/**
	 * Realiza un ataque contra una entidad.
	 * @param entidad - La entidad que será atacada
	 */
	public abstract void atacar(Atacable entidad);

	/**
	 * Mueve el enemigo por el mapa.
	 * Solo se moverá si no tiene a nadie para atacar y el espacio siguiente hacia donde se moverá está desocupado.
	 */
	public void mover() {
		if (!sprite.getIcon().equals(spriteMovimiento)) {
			sprite.setIcon(spriteMovimiento);
		}
		
		int velActual = estado.getVelocidad(velocidad);
		
		if ((x-velActual)/Gui.spriteSize<x/Gui.spriteSize) {
			//Cambio de celda en el mapa
			if (Juego.getJuego().getEntidad((x-velActual)/Gui.spriteSize, y/Gui.spriteSize)==null) {//No hay entidad en la siguiente celda
				Juego.getJuego().setEntidad(x/Gui.spriteSize, y/Gui.spriteSize, null);
				Juego.getJuego().setEntidad((x-velActual)/Gui.spriteSize, y/Gui.spriteSize, this);
				x-= velActual;
				sprite.setBounds(x, y, Gui.spriteSize, Gui.spriteSize);
			}			
		}
		else { //Movimiento normal
			x-= velActual;
			sprite.setBounds(x, y, Gui.spriteSize, Gui.spriteSize);
		}
		
	}
	
	public int getValor() {
		return puntaje;
	}
	
	/**
	 * Crea un premio al azar y lo ubica en la posición del enemigo.
	 * Este método se debe llamar cuando el enemigo muere.
	 * @return El premio creado.
	 */
	protected Premio dropPremio() {
		Random r = new Random();
		int value = r.nextInt(100);
		Premio premio = null;
		if (value<20) {
			premio = new PremioBomba(x/Gui.spriteSize, y/Gui.spriteSize);
		}
		else if (value<40) {
			premio = new PremioOro(x/Gui.spriteSize, y/Gui.spriteSize);
		}
		else if (value<60) {
			premio = new PremioProteccion(x/Gui.spriteSize, y/Gui.spriteSize);
		}
		else if (value<80) {
			premio = new PremioRestaurar(x/Gui.spriteSize, y/Gui.spriteSize);
		}
		else {
			premio = new PremioVelocidad(x/Gui.spriteSize, y/Gui.spriteSize);
		}
		
		return premio;
	}
}
