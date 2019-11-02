package listeners.comprables;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import GUI.Gui;
import juego.Juego;
import state.Estado;
import visitor.Visitor;
import visitor.VisitorBuff;

/**
 * Listener utilizado para las compras de power ups.
 *
 */
public abstract class ComprablePowerUp extends MouseAdapter {
	
	protected Gui gui;
	protected JLabel sprite;
	
	/**
	 * Crea un listener.
	 * @param gui - La interfaz gráfica
	 */
	protected ComprablePowerUp(Gui gui) {
		this.gui = gui;
	}
	
	public void mousePressed(MouseEvent e) {
		Estado pu = crearPowerUp();
		if (Juego.getJuego().getMonedas()>=pu.getValor()) {
			Visitor v = getVisitor(pu);
			Juego.getJuego().visitarEntidades(v);
			Juego.getJuego().sumarMonedas(-1*pu.getValor());
		}
	}
	
	/**
	 * Retorna el visitor utilizado para asignar el power up.
	 * @param e - El estado que se asginará al visitor
	 * @return El visitor del power up
	 */
	protected Visitor getVisitor(Estado e) {
		return new VisitorBuff(e);
	}
	
	/**
	 * Crea el estado asociado con este power up.
	 * @return El estado asociado con el power up
	 */
	protected abstract Estado crearPowerUp();

}
