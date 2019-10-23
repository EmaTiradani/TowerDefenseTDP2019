package juego;

import java.util.Random;

import GUI.Gui;
import entidades.Enemigo;
import personajes.Luchador;
import personajes.Minion;
import personajes.Tanque;

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
			//Ganar
		}
		else {
			nivel++;
			gui.cambiarNivel(nivel);
			oleada = 1;
			timerOleada = 30;			
		}
	}
	
	protected void siguienteOleada() {
		if (oleada==3) {
			siguienteNivel();
		}
		else {
			oleada++;
			timerOleada = 30;			
		} 
	}

	public void run() {
		while (!gameOver) {
			try {
				Thread.sleep(3000);
				timerOleada -= 3;
				if (timerOleada<=0) {
					Thread.sleep(5000);
					siguienteOleada();
				}
				crearSiguienteEnemigo();
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
		
		Enemigo e = new Minion(Juego.FINAL_MAPA, 0); //Constructor temporal para testear la oleada en una sola fila
		
		if (value<30) {
			e = new Minion(Juego.FINAL_MAPA, y);
		}
		else if (value<50) {
			e = new Luchador(Juego.FINAL_MAPA, y);
		}
		else if (value<60) {
			e = new Tanque(Juego.FINAL_MAPA, y);
		}
		else if (value<75) {
			//Kamikaze
		}
		else if (value<90) {
			//Arquero
		}
		else {
			//Jefe
		}		
		
		Juego.getJuego().agregarEntidad(e);
		Juego.getJuego().setEntidad(Juego.FINAL_MAPA, 0, e);
	}

}
