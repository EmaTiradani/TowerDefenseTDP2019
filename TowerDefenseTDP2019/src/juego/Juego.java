package juego;

import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;

import GUI.Gui;
import entidades.Entidad;
import personajes.AliadoTest;
import personajes.EnemigoTest;

public class Juego {
	
	protected static Juego INSTANCE = null;
	
	protected Gui gui;
	protected Celda[][] nivel;
	protected Collection<Entidad> entidades;
	protected HiloEntidades hilo;
		
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
		Entidad e = new AliadoTest(7, 2);
		//new Thread(e).start();
		this.setEntidad(e);
		gui.agregarEntidad(e);		
		Entidad en = new EnemigoTest(9, 2);
		//new Thread(en).start();
		gui.agregarEntidad(en);	
		entidades.add(en);
		en = new EnemigoTest(9, 4);
		gui.agregarEntidad(en);	
		entidades.add(en);	

		new Thread(hilo).start();
	}
	
	public boolean celdaEstaOcupada(int x, int y) {
		return !nivel[y][x].getEntidad().iterator().hasNext();
	}
	
	public void setEntidad(Entidad e) {
		nivel[e.getY()/128][e.getX()/128].setEntidad(e);
	}
	
	public Iterable<Entidad> getEntidad(int x, int y) {
		return nivel[y][x].getEntidad();
	}
	
	protected void crearMapa() {
		nivel = new Celda[6][10];
		for(int i=0; i<6; i++) {
			for(int j=0; j<10; j++) {
				nivel[i][j] = new Celda();
			}
		}
	}

	public void moverEntidades(float estimatedTime) {
		for (Entidad e : entidades) {
			e.accion(estimatedTime);
		}		
	}

}
