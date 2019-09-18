package personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import entidades.Aliado;
import visitor.Visitor;

public class AliadoTest extends Aliado {
		
	public AliadoTest(int x, int y) {
		super(x, y, 100, 3, 2);
		
		sprite = new JLabel();
		sprite.setIcon(new ImageIcon(this.getClass().getResource("/recursos/cannon.png")));
		sprite.setBounds(this.x, this.y, 128, 128);
	}
	
	public void accion(float estimatedTime) {
		
	}
	
	public boolean accept(Visitor v) {
		return v.visit(this);
	}

}
