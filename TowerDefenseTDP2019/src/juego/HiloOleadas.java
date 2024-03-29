package juego;

import java.util.Random;

import GUI.Gui;
import entidades.abstractas.Enemigo;
import entidades.abstractas.Entidad;
import entidades.concretas.ArenaMovediza;
import entidades.concretas.Arquero;
import entidades.concretas.BarricadaConPinches;
import entidades.concretas.Jefe;
import entidades.concretas.Kamikaze;
import entidades.concretas.Luchador;
import entidades.concretas.Minion;
import entidades.concretas.Pinches;
import entidades.concretas.Tanque;
import state.Proteccion;
import visitor.VisitorFinNivel;

/**
 * Hilo encargado de controlar las oleadeas y niveles del juego.
 *
 */
public class HiloOleadas implements Runnable {
	
	protected int oleada;
	protected int nivel;
	protected int timerOleada;
	protected Gui gui;
	protected boolean gameOver;
	protected VisitorFinNivel visitor;
	
	/**
	 * Crea el hilo.
	 * @param gui - La interfaz gr�fica del juego. Necesario para realizar el cambio de nivel visualmente.
	 */
	public HiloOleadas(Gui gui) {
		visitor = new VisitorFinNivel();
		this.gui = gui;
		nivel = 0;
		siguienteNivel();
		gameOver = false;
	}
	
	/**
	 * Cambia de nivel. Si este nivel era el �ltimo, el juego termina en victoria.
	 */
	protected void siguienteNivel() {
		if (nivel==2) {
			Juego.getJuego().ganar();
		}
		else {
			Juego.getJuego().visitarEntidades(visitor);
			//El nivel solo puede terminar si no hay enemigos.
			//El bloque while solo terminara cuando el visitor determine que no hay enemigos en el juego.
			while (visitor.getCantidad()!=0) {
				try {
					Thread.sleep(1000);
					visitor.resetCantidad();
					Juego.getJuego().visitarEntidades(visitor);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}			
			nivel++;
			Juego.getJuego().nuevoNivel();
			gui.cambiarNivel(nivel);
			oleada = 1;
			resetTimer();	
		}
	}
	
	/**
	 * Cambia de oleada. Si esta era la �ltima oleada, se realiza un cambio de nivel.
	 */
	protected void siguienteOleada() {
		if (oleada==3) {
			siguienteNivel();
		}
		else {
			oleada++;
			resetTimer();
			crearObjetosMapa();
		} 
	}
	
	/**
	 * Reiniciar el contador de la oleada. Este m�todo es llamado durante los cambios de oleadas y niveles.
	 */
	protected void resetTimer() {
		timerOleada = 15;
	}

	public void run() {
		while (!gameOver) {
			try {
				Thread.sleep(3000);
				timerOleada -= 3;
				if (timerOleada<=0) {
					Thread.sleep(10000);
					siguienteOleada();
				}
				else {
					crearSiguienteEnemigo();					
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Establece si el juego termin�.
	 * @param go - Booleano que, si es verdadero, determina que el juego termin�
	 */
	public void setGameOver(boolean go) {
		gameOver = go;
	}
	
	/**
	 * Crea un enemigo al azar y lo agrega al juego.
	 */
	public void crearSiguienteEnemigo() {
		Random r = new Random();		
		int y  = r.nextInt(6);
		int value = r.nextInt(100);		
		Enemigo e = null;
		
		if (value<30) {
			e = new Minion(Juego.FINAL_MAPA, y);
		}
		else if (value<50) {
			e = new Luchador(Juego.FINAL_MAPA, y);
		}
		else if (value<65) {
			e = new Tanque(Juego.FINAL_MAPA, y);
		}
		else if (value<80) {
			e = new Kamikaze(Juego.FINAL_MAPA, y);
		}
		else if (value<95) {
			 e = new Arquero(Juego.FINAL_MAPA, y);
		}
		else {
			e = new Jefe(Juego.FINAL_MAPA, y); 
		}	
		
		if (r.nextInt(100)<10) {
			//Posibilidad de que el enemigo tenga un escudo de proteccion
			e.setEstado(new Proteccion(), 20);
		}
		
		if (Juego.getJuego().getEntidad(Juego.FINAL_MAPA,  y)==null) {
			Juego.getJuego().agregarEntidad(e);
			Juego.getJuego().setEntidad(Juego.FINAL_MAPA, y, e);
		}
		
	}
	
	/**
	 * Crea varios objetos del mapa aleatoriamente y los agrega al juego.
	 */
	protected void crearObjetosMapa() {
		Entidad o;
		Random r = new Random();
		boolean inserto;
		int x, y, value;
		for (int i=0; i<3; i++) {
			inserto = false;
			while (!inserto) {
				x = r.nextInt(Juego.FINAL_MAPA-Juego.COMIENZO_MAPA) + Juego.COMIENZO_MAPA;
				y = r.nextInt(6);
				if (Juego.getJuego().getEntidad(x, y)==null) {
					value = r.nextInt(100);
					if (value<33) {
						o = new Pinches(x, y);
					}
					else if (value<66) {
						o = new ArenaMovediza(x, y);
					}
					else {
						o = new BarricadaConPinches(x, y);
						Juego.getJuego().setEntidad(x, y, o);
					}
					Juego.getJuego().agregarEntidad(o);
					inserto = true;
				}
			}
		}
	}

}
