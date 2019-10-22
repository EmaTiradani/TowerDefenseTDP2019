package personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.Premio;
import juego.Juego;

public class PremioOro extends Premio {

	public PremioOro(int x, int y) {
		super(x, y);
		
		sprite = new JLabel();
		sprite.setIcon(new ImageIcon(this.getClass().getResource("/recursos/objetos/moneda.png")));
		sprite.setBounds(this.x, this.y, Gui.spriteSize, Gui.spriteSize);
		agregarListener();
	}

	protected void activarEffecto() {
		Juego.getJuego().sumarMonedas(100);
	}

}
