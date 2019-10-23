package juego;

import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import GUI.Gui;
import entidades.Entidad;
import personajes.*;
import visitor.Visitor;

public class Juego {
	
	protected static Juego INSTANCE = null;
	public static int COMIENZO_MAPA = 10; //Columna inicial del juego.
	public static int FINAL_MAPA = 20; //Columna final del juego. Es aca donde los enemigos empiezan a aparecer
	
	protected Gui gui;
	protected Celda[][] nivel;
	protected Collection<Entidad> entidades;
	protected HiloEntidades hilo;
	protected HiloOleadas oleadas;
	protected int puntaje;
	protected int monedas;
		
	protected Juego() {
	}	
	
	public static Juego getJuego() {
		if (INSTANCE==null) {
			INSTANCE = new Juego();
		}
		return INSTANCE;
	}
	
	public void comenzarJuego() {
		entidades = new ConcurrentLinkedQueue<>();
		hilo = new HiloEntidades();
		new Thread(hilo).start();
		
		crearMapa();
		gui = new Gui();
		
		oleadas = new HiloOleadas(gui);
		new Thread(oleadas).start();
		
		monedas = 5000; 
		gui.actualizarMonedas(monedas);

		
		for (int i=0; i<6; i++) {
			agregarEntidad(new GameOverFlag(Juego.COMIENZO_MAPA-2, i));
		}
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
		nivel = new Celda[6][30];//El juego solo tiene 10 columnas visibles.
		//Las otras 20 son columnas invisibles en ambos lados del juego para que los disparos puedan pasar sin caer del arreglo
		
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

	public int getMonedas() {
		return monedas;
	}
	
	public void sumarPuntos(int i) {
		puntaje += i;
		gui.actualizarPuntaje(puntaje);
		sumarMonedas(i);
	}

	public void sumarMonedas(int i) {
		monedas += i;
		gui.actualizarMonedas(monedas);		
	}
	
	public void perder() {
		hilo.setGameOver(true);
		oleadas.setGameOver(true);
		for (Entidad e : entidades) {
			matar(e);
		}
		gui.perder();
	}

}
