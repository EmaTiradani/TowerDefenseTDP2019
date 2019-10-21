package personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import GUI.Gui;
import entidades.Aliado;
import entidades.Disparo;
import entidades.Entidad;
import juego.Juego;

public class TorreDoble extends Aliado {

	public TorreDoble(int x, int y) {
		super(x, y, 50, 3, 6, 50);
		sprite = new JLabel();
		sprite.setIcon(new ImageIcon(this.getClass().getResource("/recursos/aliados/aliado_doble01.png")));
		sprite.setBounds(this.x, this.y, Gui.spriteSize, Gui.spriteSize*2);
	}

	protected Disparo crearDisparo() {
		return new DisparoDoble(x/Gui.spriteSize, y/Gui.spriteSize, alcance, estado);
	}
	
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
	
}
