package personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import GUI.Gui;
import entidades.Entidad;
import entidades.ObjetoVida;
import juego.Juego;

public class Bomba extends ObjetoVida {

	public Bomba(int x, int y, int vida) {
		super(x, y, vida);
		
		sprite = new JLabel();
		sprite.setIcon(new ImageIcon(this.getClass().getResource("/recursos/bicho enemigo.jpg")));
		sprite.setBounds(this.x, this.y, Gui.spriteSize, Gui.spriteSize);
	}
	
	public void accion(float estimatedTime) {
	}
	
	public void morir() {
		super.morir();
		matarEntidadesAdyacentes();
	}

	protected void matarEntidadesAdyacentes() {
		int n = x/Gui.spriteSize;
		int m = y/Gui.spriteSize;
		Entidad e;
		for (int i=-1; i<=1; i++) {
			for (int j=-1; j<=1; j++) {
				if (i!=0 || j!=0) {
					e = Juego.getJuego().getEntidad(n+i, m+j);
					if (e!=null) {
						System.out.println("Hola");
						e.morir();					
					}
				}				
			}
		}
	}
	
}
