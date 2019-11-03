package listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import juego.Juego;

/**
 * Listener utilizado para reinicar el juego.
 *
 */
public class ReiniciarJuegoListener extends MouseAdapter {
	
	/**
	 * Crea un listener
	 */
	public ReiniciarJuegoListener() {		
	}
	
	public void mousePressed(MouseEvent e) {
		Juego.getJuego().reinciarJuego();
	}

}
