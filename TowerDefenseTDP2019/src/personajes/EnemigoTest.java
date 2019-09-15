package personajes;

import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import entidades.EnemigoCerca;
import entidades.Entidad;
import juego.Juego;
import visitor.Visitor;

public class EnemigoTest extends EnemigoCerca {

	public EnemigoTest(int x, int y) {
		super(x, y, 50, 4, 2, 5);
		
		sprite = new JLabel();
		sprite.setIcon(new ImageIcon(this.getClass().getResource("/recursos/goblin.png")));
		sprite.setBounds(this.x, this.y, 128, 128);		
		
	}
		
}
