package GUI;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import entidades.Aliado;
import entidades.Entidad;
import juego.Juego;

public abstract class ComprableMotionListener extends MouseAdapter {
	
	protected JLabel sprite;
	protected Gui gui;
	
	protected ComprableMotionListener(Gui gui) {
		this.gui = gui;
	}
	
	public void mousePressed(MouseEvent e) {
		Point p = MouseInfo.getPointerInfo().getLocation();
		int newX = (int)p.getX() - (gui.getX() + Gui.spriteSize/2);
		int newY = (int)p.getY() - (gui.getY() + Gui.spriteSize/2);
		actualizarPosicion(newX, newY);
		
		sprite.setVisible(true);
	}
	
	public void mouseDragged(MouseEvent e) {
		Point p = MouseInfo.getPointerInfo().getLocation();
		int newX = (int)p.getX() - (gui.getX() + Gui.spriteSize/2);
		int newY = (int)p.getY() - (gui.getY() + Gui.spriteSize/2);
		actualizarPosicion(newX, newY);
    }
	
	public void mouseReleased(MouseEvent e) {
		sprite.setVisible(false);
		
		this.realizarCompra();
	}
	
	protected void realizarCompra() {
		Point p = MouseInfo.getPointerInfo().getLocation();
		SwingUtilities.convertPointFromScreen(p, gui);
		
		int mouseX = (int)p.getX();
		int mouseY = (int)p.getY();
		
		int endX = (Juego.FINAL_MAPA - Juego.COMIENZO_MAPA) * Gui.spriteSize;
		int endY = 6 * Gui.spriteSize;
		
		if (mouseX>=0 && mouseX<endX && mouseY>=0 && mouseY<endY) {
			int mapaX = mouseX/Gui.spriteSize + Juego.COMIENZO_MAPA;
			int mapaY = mouseY/Gui.spriteSize;
			if (Juego.getJuego().getEntidad(mapaX, mapaY)==null) {
				Entidad e = crearPersonaje(mapaX, mapaY);
				if (e.getCoste()<=Juego.getJuego().getMonedas()) {
					Juego.getJuego().setEntidad(mapaX, mapaY, e);
					Juego.getJuego().agregarEntidad(e);
					Juego.getJuego().sumarMonedas(-1*e.getCoste());
				}				
			}			
		}
	}
	
	protected void actualizarPosicion(int x, int y) {
		sprite.setBounds(x, y, Gui.spriteSize, Gui.spriteSize);
	}
	
	protected abstract Entidad crearPersonaje(int x, int y);

}
