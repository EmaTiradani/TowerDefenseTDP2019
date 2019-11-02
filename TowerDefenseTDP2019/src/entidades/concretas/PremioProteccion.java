package entidades.concretas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.abstractas.Premio;
import juego.Juego;
import state.Proteccion;
import visitor.VisitorBuff;

/**
 * Tipo de premio que otorga el estado de Proteccion a todos los aliados cuando es activado.
 */
public class PremioProteccion extends Premio {

	/**
	 * Crea el premio en una posici�n
	 * @param x - La columna donde se crea el objeto
	 * @param y - La fila donde se crea el objeto
	 */
	public PremioProteccion(int x, int y) {
		super(x, y);
		
		miVisitor = new VisitorBuff(new Proteccion());

		sprite = new JLabel();
		sprite.setIcon(new ImageIcon(this.getClass().getResource("/recursos/objetos/proteccion.png")));
		sprite.setBounds(this.x, this.y, Gui.spriteSize, Gui.spriteSize);
		agregarListener();
	}

	protected void activarEffecto() {
		Juego.getJuego().visitarEntidades(miVisitor);		
	}

}
