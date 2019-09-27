package juego;

import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import GUI.Gui;
import entidades.Entidad;
import personajes.AliadoTest;
import personajes.EnemigoTest;
import personajes.Pinches;
import visitor.Visitor;

public class Juego {
	
	protected static Juego INSTANCE = null;
	
	protected Gui gui;
	protected Celda[][] nivel;
	protected Collection<Entidad> entidades;
	protected HiloEntidades hilo;
	protected int puntaje;
		
	protected Juego() {
		entidades = new ConcurrentLinkedQueue<>();
		hilo = new HiloEntidades();
	}	
	
	public static Juego getJuego() {
		if (INSTANCE==null) {
			INSTANCE = new Juego();
		}
		return INSTANCE;
	}
	
	public void comenzarJuego() {
		crearMapa();
		gui = new Gui();
		
		//Aliado y Enemigo de prueba
		Entidad e = new AliadoTest(4, 2);
		this.setEntidad(4, 2, e);
		gui.agregarEntidad(e);	
		entidades.add(e);
		
		Entidad en = new EnemigoTest(9, 2);
		this.setEntidad(9, 2, en);
		gui.agregarEntidad(en);	
		entidades.add(en);
		
		en = new EnemigoTest(9, 3);
		gui.agregarEntidad(en);	
		this.setEntidad(9, 3, en);
		entidades.add(en);
		
		e = new Pinches(7, 3);
		gui.agregarEntidad(e);
		entidades.add(e);

		new Thread(hilo).start();
	}
	
	public boolean celdaEstaOcupada(int x, int y) {
		return nivel[y][x].getEntidad()!=null;
	}
	
	public void setEntidad(int x, int y, Entidad e) {
		nivel[y][x].setEntidad(e);
	}
	
	public Entidad getEntidad(int x, int y) {
		return nivel[y][x].getEntidad();
	}
	
	public void agregarEntidad(Entidad e) {
		gui.agregarEntidad(e);
		entidades.add(e);		
	}
	
	protected void crearMapa() {
		nivel = new Celda[6][20];
		for(int i=0; i<nivel.length; i++) {
			for(int j=0; j<nivel[0].length; j++) {
				nivel[i][j] = new Celda();
			}
		}
	}

	public void moverEntidades(float estimatedTime) {
		for (Entidad e : entidades) {
			e.accion(estimatedTime);
		}		
	}

	public void matar(Entidad entidad) {
		entidades.remove(entidad);		
		gui.remove(entidad);
		Entidad e = nivel[entidad.getY()/Gui.spriteSize][entidad.getX()/Gui.spriteSize].getEntidad();
		if (e==entidad) {
			nivel[entidad.getY()/Gui.spriteSize][entidad.getX()/Gui.spriteSize].setEntidad(null);
		}
		
	}

	public void visitarEntidades(Visitor v) {
		for (Entidad e : entidades) {
			e.accept(v);
		}
		
	}

	public void sumarPuntos(int i) {
		puntaje += i;
		gui.actualizarPuntaje(puntaje);
	}

}
