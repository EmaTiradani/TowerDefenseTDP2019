package listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import entidades.Premio;

public class PremioListener extends MouseAdapter {
	
	protected Premio premio;
	
	public PremioListener(Premio p) {
		premio = p;
	}
	
	public void mousePressed(MouseEvent e) {
		premio.morir();
	}

}
