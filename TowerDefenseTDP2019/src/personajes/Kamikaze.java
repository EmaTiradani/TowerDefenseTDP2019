package personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import entidades.Atacable;
import entidades.EnemigoCerca;
import GUI.Gui;

public class Kamikaze extends EnemigoCerca {
	
	protected boolean exploto;
	
	public Kamikaze(int x, int y) {
		super(x, y, 25, 15, 1, 150, 5);
		
		spriteMovimiento = new ImageIcon(this.getClass().getResource("/recursos/enemigos/Kamikaze.gif"));
		spriteAtaque = new ImageIcon(this.getClass().getResource("/recursos/enemigos/explosion.png"));
		sprite = new JLabel();
		sprite.setIcon(new ImageIcon(this.getClass().getResource("/recursos/goblin.png")));
		sprite.setBounds(this.x, this.y, Gui.spriteSize, Gui.spriteSize);
		agregarBarraVida();
		
		exploto = false;
	}
	
	public void atacar(Atacable a) {
		super.atacar(a);
		exploto = true;
		cooldownActual = 0.25f;
	}
	
	public void accion(float estimatedTime) {
		if (exploto) {
			if (cooldownActual>0) {
				cooldownActual -= estimatedTime;
			}
			else {
				this.morir();
			}
		}
		else {
			super.accion(estimatedTime);
		}
	}
}
