package personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import entidades.Aliado;
import visitor.Visitor;

public class AliadoTest extends Aliado {
	
	private int cooldown;
	
	public AliadoTest(int x, int y) {
		sprite = new JLabel();
		sprite.setIcon(new ImageIcon(this.getClass().getResource("/recursos/cannon.png")));
		this.x = x*128;
		this.y = y*128;
		sprite.setBounds(this.x, this.y, 128, 128);
		
		alcance = 4;
		cooldown = 3;
	}
	
	public void accion() {
		
	}

	public void run() {
		try {
			while (true) {
				//System.out.println("Run AliadoTest");
				Thread.sleep(cooldown*1000);
			}
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
	
	public boolean accept(Visitor v) {
		return v.visit(this);
	}

}
