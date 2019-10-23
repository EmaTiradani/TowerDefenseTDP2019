package entidades;

import java.util.Random;

import javax.swing.Icon;

import GUI.Gui;
import juego.Juego;
import personajes.PremioBomba;
import personajes.PremioOro;
import personajes.PremioProteccion;
import personajes.PremioRestaurar;
import personajes.PremioVelocidad;
import visitor.Visitor;
import visitor.VisitorEnemigo;

public abstract class Enemigo extends Personaje {
	
	protected int velocidad;
	protected int puntaje;
	protected Icon spriteMovimiento;
	protected Icon spriteAtaque;

	protected Enemigo(int x, int y, int vida, int vel, int cooldown, int puntaje) {
		super(x, y, vida, cooldown);
		velocidad = vel;
		this.puntaje = puntaje;
		setVisitor();
	}
	
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
			Juego.getJuego().agregarEntidad(dropPremio(r));
		}
	}

	public abstract void atacar(Atacable entidad);

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
	
	public int getCoste() {
		return puntaje;
	}
	
	protected Objeto dropPremio(Random r) {
		int value = r.nextInt(100);
		Objeto premio = null;
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
