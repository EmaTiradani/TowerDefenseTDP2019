package personajes;

import javax.swing.JLabel;

import GUI.Gui;
import entidades.Entidad;
import juego.Juego;
import visitor.Visitor;

public class GameOverFlag extends Entidad {

	public GameOverFlag(int x, int y) {
		super(x, y);
		sprite = new JLabel();
	}
	
	public int getCoste() {
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