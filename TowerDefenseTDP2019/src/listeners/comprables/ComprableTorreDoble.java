package listeners.comprables;

import java.awt.MouseInfo;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import GUI.Gui;
import entidades.abstractas.Entidad;
import entidades.concretas.TorreDoble;
import juego.Juego;

/**
 * Listener asociado con el aliado TorreDoble
 *
 */
public class ComprableTorreDoble extends ComprableMotionListener {

	/**
	 * Crea un listener.
	 * @param gui - La interfaz gráfica
	 */
	public ComprableTorreDoble(Gui gui) {
		super(gui);
		sprite = new JLabel(new ImageIcon(this.getClass().getResource("/recursos/aliados/aliado_doble01.png")));
		sprite.setVisible(false);
		gui.getContentPane().add(sprite, 0);
	}

	protected Entidad crearEntidad(int x, int y) {
		return new TorreDoble(x, y);
	}
	
	protected void actualizarPosicion(int x, int y) {
		sprite.setBounds(x, y, Gui.spriteSize, Gui.spriteSize*2);
	}
	
	protected void realizarCompra() {
		Point p = MouseInfo.getPointerInfo().getLocation();
		SwingUtilities.convertPointFromScreen(p, gui);
		
		int mouseX = (int)p.getX();
		int mouseY = (int)p.getY();
		
		int endX = (Juego.FINAL_MAPA - Juego.COMIENZO_MAPA) * Gui.spriteSize;
		int endY = 5 * Gui.spriteSize;
		
		if (mouseX>=0 && mouseX<endX && mouseY>=0 && mouseY<endY) {
			int mapaX = mouseX/Gui.spriteSize + Juego.COMIENZO_MAPA;
			int mapaY = mouseY/Gui.spriteSize;
			if (Juego.getJuego().getEntidad(mapaX, mapaY)==null && 
					Juego.getJuego().getEntidad(mapaX, mapaY+1)==null) {
				Entidad e = crearEntidad(mapaX, mapaY);
				if (e.getValor()<=Juego.getJuego().getMonedas()) {
					Juego.getJuego().setEntidad(mapaX, mapaY, e);
					Juego.getJuego().setEntidad(mapaX, mapaY+1, e);
					Juego.getJuego().agregarEntidad(e);
					Juego.getJuego().sumarMonedas(-1*e.getValor());
				}				
			}			
		}
	}
	

}
