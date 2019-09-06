package personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import entidades.Aliado;

public class AliadoTest extends Aliado {
	
	public AliadoTest(int x, int y) {
		sprite = new JLabel();
		sprite.setIcon(new ImageIcon("C:\\Users\\default.LAPTOP-9ASHTB0Q\\Desktop\\marciano.gif"));
		this.x = x*128;
		this.y = y*128;
		sprite.setBounds(this.x, this.y, 128, 128);
	}

}
