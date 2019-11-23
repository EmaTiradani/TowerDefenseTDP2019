package listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import entidades.abstractas.Aliado;
import juego.Juego;

public class VenderListener extends MouseAdapter {
	
	protected Aliado torre;
	
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
