package entidades.concretas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.abstractas.Entidad;
import entidades.abstractas.ObjetoTemporal;
import juego.Juego;
import visitor.VisitorArena;

public class ArenaMovediza extends ObjetoTemporal {

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
