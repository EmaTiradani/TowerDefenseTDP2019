package entidades.concretas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.abstractas.ObjetoVida;

/**
 * Objeto que funciona como una pared, bloqueando el movimiento de los enemigos.
 * Como es un ObjetoVida, eventualmente sera atacado y destruido.
 *
 */
public class Barricada extends ObjetoVida {
	
	/**
	 * Crea una barricada
	 * @param x - La columna donde se crea el objeto
	 * @param y - La fila donde se crea el objeto
	 */
	public Barricada(int x, int y) {
		super(x, y, 120);
		
		sprite = new JLabel();
		sprite.setIcon(new ImageIcon(this.getClass().getResource("/recursos/objetos/muro.png")));
		sprite.setBounds(this.x, this.y, Gui.spriteSize, Gui.spriteSize);
	}

	public void accion(float estimatedTime) {
	}
	
	public int getValor() {
		return 35;
	}

}
