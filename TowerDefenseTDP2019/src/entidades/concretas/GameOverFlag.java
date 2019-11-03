package entidades.concretas;

import javax.swing.JLabel;

import GUI.Gui;
import entidades.abstractas.Entidad;
import juego.Juego;
import visitor.Visitor;

/**
 * Objeto utilizado para marcar el fin del juego.
 * Considerando que el objetivo de de los enemigos es ir hacia la izquierda, mas allá de la pantalla,
 * entonces cada fila tiene fuera de la pantalla un objeto de estos. Cuando entran en contacto con alguna entidad, el juego termina en derrota.
 *
 */
public class GameOverFlag extends Entidad {

	/**
	 * Crea un objeto en una posición.
	 * @param x - La columna donde se crea el objeto
	 * @param y - La fila donde se crea el objeto
	 */
	public GameOverFlag(int x, int y) {
		super(x, y);
		sprite = new JLabel();
	}
	
	public int getValor() {
		return 0;
	}

	public void accion(float estimatedTime) {
		Entidad e = Juego.getJuego().getEntidad(x/Gui.spriteSize, y/Gui.spriteSize);
		if (e!=null) {
			Juego.getJuego().perder();
		}
	}
	public void accept(Visitor v) {
	}

}
