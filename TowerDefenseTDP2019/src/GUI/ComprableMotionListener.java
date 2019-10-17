package GUI;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import entidades.Entidad;
import juego.Juego;
import personajes.AliadoTest;
import personajes.EnemigoTest;

public class ComprableMotionListener extends MouseAdapter {
	
	protected JLabel sprite;
	protected Gui gui;
	
	public ComprableMotionListener(JLabel sprite, Gui gui) {
		this.gui = gui;
		this.sprite = sprite;
	}
	
	public void mousePressed(MouseEvent e) {
		Point p = MouseInfo.getPointerInfo().getLocation();
		int newX = (int)p.getX() - (gui.getX() + Gui.spriteSize/2);
		int newY = (int)p.getY() - (gui.getY() + Gui.spriteSize/2);
		sprite.setBounds(newX, newY, Gui.spriteSize, Gui.spriteSize);
		
		sprite.setVisible(true);
	}
	
	public void mouseDragged(MouseEvent e) {
		Point p = MouseInfo.getPointerInfo().getLocation();
		int newX = (int)p.getX() - (gui.getX() + Gui.spriteSize/2);
		int newY = (int)p.getY() - (gui.getY() + Gui.spriteSize/2);
		sprite.setBounds(newX, newY, Gui.spriteSize, Gui.spriteSize);
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
			System.out.println("Adentro Mapa");
			
			int mapaX = mouseX/Gui.spriteSize + Juego.COMIENZO_MAPA;
			int mapaY = mouseY/Gui.spriteSize;
			Entidad e = new AliadoTest(mapaX, mapaY);
			Juego.getJuego().setEntidad(mapaX, mapaY, e);
			Juego.getJuego().agregarEntidad(e);
		}
	}

}
