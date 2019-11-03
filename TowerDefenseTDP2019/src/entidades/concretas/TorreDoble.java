package entidades.concretas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import GUI.Gui;
import entidades.abstractas.Aliado;
import entidades.abstractas.Disparo;
import entidades.abstractas.Entidad;
import juego.Juego;

/**
 * Torre que ocupa dos espacios en filas adyacentes.
 * Al ocupar dos espacios, tambi�n realiza dos disparos al mismo tiempo.
 *
 */
public class TorreDoble extends Aliado {

	/**
	 * Crea una torre doble en una posici�n.
	 * @param x - La columna donde se crea el personaje
	 * @param y - La fila donde se crea el personaje
	 */
	public TorreDoble(int x, int y) {
		super(x, y, 50, 3, 6, 50);
		sprite = new JLabel();
		sprite.setIcon(new ImageIcon(this.getClass().getResource("/recursos/aliados/aliado_doble01.png")));
		sprite.setBounds(this.x, this.y, Gui.spriteSize, Gui.spriteSize*2);
		agregarBarraVida();
	}

	protected Disparo crearDisparo() {
		return new DisparoDoble(x/Gui.spriteSize, y/Gui.spriteSize, alcance, estado);
	}
	
	/**
	 * Crea y retorna el segundo disparo.
	 * @return el segundo disparo
	 */
	protected Disparo crearSegundoDisparo() {
		return new DisparoDoble(x/Gui.spriteSize, y/Gui.spriteSize + 1, alcance, estado);
	}
	
	public void accion(float estimatedTime) {
		cooldownActual -= estimatedTime;
		Entidad e;
		for (int i=1; i<=alcance; i++) {
			e = Juego.getJuego().getEntidad(x/Gui.spriteSize + i, y/Gui.spriteSize);					
			if (e!=null) {
				e.accept(miVisitor);
			}
			e = Juego.getJuego().getEntidad(x/Gui.spriteSize + i, y/Gui.spriteSize + 1);					
			if (e!=null) {
				e.accept(miVisitor);
			}
		}		
	}
	
	public void disparar() {
		if (cooldownActual<=0) {
			Juego.getJuego().agregarEntidad(this.crearDisparo());
			Juego.getJuego().agregarEntidad(this.crearSegundoDisparo());
			cooldownActual = cooldownAtaque;
		}		
	}
	
	public void morir() {
		super.morir();
		Juego.getJuego().setEntidad(x/Gui.spriteSize, (y/Gui.spriteSize)+1, null);
		
	}
	
}
