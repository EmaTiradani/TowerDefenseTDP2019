package listeners.comprables;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import GUI.Gui;
import entidades.abstractas.Entidad;
import juego.Juego;

/**
 * Listener utilizado para las compras de aliados y objetos.
 *
 */
public abstract class ComprableMotionListener extends MouseAdapter {
	
	protected JLabel sprite;
	protected Gui gui;
	
	/**
	 * Crea un listener.
	 * @param gui - La interfaz gráfica
	 */
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
	
	/**
	 * Si el jugador tiene suficientes monedas, realiza la compra y sitúa la entidad comprada en el lugar marcado por el jugador.
	 */
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
				Entidad e = crearEntidad(mapaX, mapaY);
				if (e.getValor()<=Juego.getJuego().getMonedas()) {
					Juego.getJuego().setEntidad(mapaX, mapaY, e);
					Juego.getJuego().agregarEntidad(e);
					Juego.getJuego().sumarMonedas(-1*e.getValor());
				}				
			}			
		}
	}
	
	/**
	 * Actualiza la posición del componente gráfico para que esté en la misma posición que el cursor.
	 * @param x - La posición horizontal en pixeles del cursor
	 * @param y - La posición vertical en pixeles del cursor
	 */
	protected void actualizarPosicion(int x, int y) {
		sprite.setBounds(x, y, Gui.spriteSize, Gui.spriteSize);
	}
	
	/**
	 * Crea la entidad asociada con este listener
	 * @param x - La columna del mapa donde será insertada
	 * @param y - La fila del mapa donde será insertada
	 * @return La entidad creada
	 */
	protected abstract Entidad crearEntidad(int x, int y);

}
