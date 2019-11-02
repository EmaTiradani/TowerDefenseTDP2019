package entidades.concretas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.abstractas.Atacable;
import entidades.abstractas.EnemigoCerca;

/**
 * Enemigo que se destruye al realizar un ataque. Debido a esto, solo puede realizar un ataque,
 * y por lo tanto está diseñado para realizar suficiente daño para destruir casi cualquier obstáculo con un solo ataque.
 *
 */
public class Kamikaze extends EnemigoCerca {
	
	protected boolean exploto;
	
	/**
	 * Crea un kamikaze en una posición.
	 * @param x - La columna donde se crea el personaje
	 * @param y - La fila donde se crea el personaje
	 */
	public Kamikaze(int x, int y) {
		super(x, y, 25, 15, 1, 150, 5);
		
		spriteMovimiento = new ImageIcon(this.getClass().getResource("/recursos/enemigos/Kamikaze.gif"));
		spriteAtaque = new ImageIcon(this.getClass().getResource("/recursos/enemigos/explosion.png"));
		sprite = new JLabel();
		sprite.setIcon(spriteMovimiento);
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
