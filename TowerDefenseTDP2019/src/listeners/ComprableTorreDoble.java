package listeners;

import java.awt.MouseInfo;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import GUI.Gui;
import entidades.Entidad;
import personajes.TorreDoble;

public class ComprableTorreDoble extends ComprableMotionListener {

	public ComprableTorreDoble(Gui gui) {
		super(gui);
		sprite = new JLabel(new ImageIcon(this.getClass().getResource("/recursos/aliados/aliado_doble01.png")));
		sprite.setVisible(false);
		gui.getContentPane().add(sprite, 0);
	}

	protected Entidad crearPersonaje(int x, int y) {
		return new TorreDoble(x, y);
	}
	
	protected void actualizarPosicion(int x, int y) {
		sprite.setBounds(x, y, Gui.spriteSize, Gui.spriteSize*2);
	}
	
	protected void realizarCompra() {
		Point p = MouseInfo.getPointerInfo().getLocation();
		SwingUtilities.convertPointFromScreen(p, gui);
		
		int mouseY = (int)p.getY();		
		int endY = 5 * Gui.spriteSize;
		
		if (mouseY<endY) {
			super.realizarCompra();
		}
	}

}
