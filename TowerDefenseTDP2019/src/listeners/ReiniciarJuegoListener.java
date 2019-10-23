package listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import juego.Juego;

public class ReiniciarJuegoListener extends MouseAdapter {
	
	public ReiniciarJuegoListener() {		
	}
	
	public void mousePressed(MouseEvent e) {
		Juego.getJuego().reinciarJuego();
	}

}
