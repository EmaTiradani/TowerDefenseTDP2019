package listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import GUI.Gui;
import juego.Juego;
import state.Estado;
import visitor.Visitor;
import visitor.VisitorBuff;

public abstract class ComprablePowerUp extends MouseAdapter {
	
	protected Gui gui;
	protected JLabel sprite;
	
	protected ComprablePowerUp(Gui gui) {
		this.gui = gui;
	}
	
	public void mousePressed(MouseEvent e) {
		Estado pu = crearPowerUp();
		if (Juego.getJuego().getMonedas()>=pu.getCoste()) {
			Visitor v = getVisitor(pu);
			Juego.getJuego().visitarEntidades(v);
			Juego.getJuego().sumarMonedas(-1*pu.getCoste());
		}
	}
	
	protected Visitor getVisitor(Estado e) {
		return new VisitorBuff(e);
	}
	
	protected abstract Estado crearPowerUp();

}
