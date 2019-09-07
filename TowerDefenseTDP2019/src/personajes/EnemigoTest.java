package personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import entidades.Enemigo;

public class EnemigoTest extends Enemigo {

	public EnemigoTest(int x, int y) {
		sprite = new JLabel();
		sprite.setIcon(new ImageIcon(this.getClass().getResource("/recursos/enemigo.png")));
		this.x = x*128;
		this.y = y*128;
		sprite.setBounds(128*x, 128*y, 128, 128);
	}
}
