package entidades.concretas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.abstractas.Entidad;
import entidades.abstractas.ObjetoTemporal;
import juego.Juego;
import visitor.VisitorArena;

/**
 * Tipo de objeto que disminuye la velocidad de los enemigos que caminan por encima suyo.
 */
public class ArenaMovediza extends ObjetoTemporal {

	/**
	 * Crea la arena movediza en una posición
	 * @param x - La columna donde se crea el objeto
	 * @param y - La fila donde se crea el objeto
	 */
	public ArenaMovediza(int x, int y) {
		super(x, y, 20);

		sprite = new JLabel();
		sprite.setIcon(new ImageIcon(this.getClass().getResource("/recursos/objetos/barro.png")));
		sprite.setBounds(this.x, this.y, Gui.spriteSize, Gui.spriteSize);
		
		miVisitor = new VisitorArena();
	}
	
	public void accion(float estimatedTime) {
		super.accion(estimatedTime);
		
		Entidad e = Juego.getJuego().getEntidad(x/Gui.spriteSize, y/Gui.spriteSize);
		if (e!=null) {
			e.accept(miVisitor);
		}
	}

}
