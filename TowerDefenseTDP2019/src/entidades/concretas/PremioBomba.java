package entidades.concretas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.abstractas.Entidad;
import entidades.abstractas.Premio;
import juego.Juego;

/**
 * Tipo de premio que explota cuando se activa, destruyendo las entidades adyacentes.
 *
 */
public class PremioBomba extends Premio {

	/**
	 * Crea el premio en una posici�n
	 * @param x - La columna donde se crea el objeto
	 * @param y - La fila donde se crea el objeto
	 */
	public PremioBomba(int x, int y) {
		super(x, y);
		
		sprite = new JLabel();
		sprite.setIcon(new ImageIcon(this.getClass().getResource("/recursos/objetos/fuego.png")));
		sprite.setBounds(this.x, this.y, Gui.spriteSize, Gui.spriteSize);
		agregarListener();
	}

	protected void activarEffecto() {
		int mapaX = x/Gui.spriteSize;
		int mapaY = y/Gui.spriteSize;
		
		Entidad e;
		for (int i=-1; i<=1; i++) {
			for (int j=-1; j<=1; j++) {
				if (mapaY+j>=0 && mapaY+j<6) {
					e = Juego.getJuego().getEntidad(mapaX + i, mapaY + j); 
					if (e!=null) {
						e.morir();
					}
				}
				
			}
		}
	}

}
