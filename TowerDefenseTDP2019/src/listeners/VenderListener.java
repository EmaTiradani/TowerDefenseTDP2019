package listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import entidades.abstractas.Aliado;
import juego.Juego;

/**
 * Listener utilizado para vender las torres del jugador.
 * Si el jugador presiona click derecho sobre una torre con este listener, la torre será eliminada y se recuperarán las monedas gastadas,
 * a menos que la torre sea dañada. En ese caso, solo se recuperarán la mitad de las monedas.
 *
 */
public class VenderListener extends MouseAdapter {
	
	protected Aliado torre;
	
	/**
	 * Crea un listener.
	 * @param a - La torre que contiene este listener
	 */
	public VenderListener(Aliado a) {
		torre = a;
	}
	
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON3) {
			int monedas = torre.estaSano() ? torre.getValor() : torre.getValor()/2;
			Juego.getJuego().sumarMonedas(monedas);
			torre.morir();
		}
	}

}
