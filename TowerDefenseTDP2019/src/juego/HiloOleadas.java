package juego;

import java.util.Random;

import GUI.Gui;
import entidades.Enemigo;
import entidades.Objeto;
import personajes.ArenaMovediza;
import personajes.Arquero;
import personajes.BarricadaConPinches;
import personajes.Jefe;
import personajes.Kamikaze;
import personajes.Luchador;
import personajes.Minion;
import personajes.Pinches;
import personajes.Tanque;
import state.Proteccion;

public class HiloOleadas implements Runnable {
	
	protected int oleada;
	protected int nivel;
	protected int timerOleada;
	protected Gui gui;
	protected boolean gameOver;
	
	public HiloOleadas(Gui gui) {
		this.gui = gui;
		nivel = 0;
		siguienteNivel();
		gameOver = false;
	}
	
	protected void siguienteNivel() {
		if (nivel==2) {
			Juego.getJuego().ganar();
		}
		else {
			nivel++;
			Juego.getJuego().nuevoNivel();
			gui.cambiarNivel(nivel);
			oleada = 1;
			timerOleada = 9;			
		}
	}
	
	protected void siguienteOleada() {
		if (oleada==3) {
			siguienteNivel();
		}
		else {
			oleada++;
			timerOleada = 15;	
			crearObjetosMapa();
		} 
	}

	public void run() {
		while (!gameOver) {
			try {
				Thread.sleep(3000);
				timerOleada -= 3;
				if (timerOleada<=0) {
					Thread.sleep(15000);
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
	
	public void setGameOver(boolean go) {
		gameOver = go;
	}
	
	public void crearSiguienteEnemigo() {
		Random r = new Random();		
		int y  = r.nextInt(6);
		int value = r.nextInt(100);
		
		//Enemigo e = new Minion(Juego.FINAL_MAPA, y); //Constructor temporal para testear la oleada en una sola fila
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
	
	protected void crearObjetosMapa() {
		Objeto o;
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
