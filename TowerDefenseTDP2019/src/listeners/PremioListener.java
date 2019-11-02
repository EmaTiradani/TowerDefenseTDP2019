package listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import entidades.abstractas.Premio;

/**
 * Listener utilizado por los premios.
 *
 */
public class PremioListener extends MouseAdapter {
	
	protected Premio premio;
	
	/**
	 * Crea un listener
	 * @param p - El premio asociado al listener.
	 */
	public PremioListener(Premio p) {
		premio = p;
	}
	
	public void mousePressed(MouseEvent e) {
		premio.morir();
	}

}
