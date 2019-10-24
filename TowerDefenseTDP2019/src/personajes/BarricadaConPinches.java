package personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.Enemigo;
import entidades.ObjetoVida;

public class BarricadaConPinches extends ObjetoVida{
	
	protected float da�o;
	protected float cooldownAtaque;
	protected float cooldownActual;

	public BarricadaConPinches(int x, int y) {
		super(x, y, 100);
		
		da�o = 15;
		cooldownAtaque = 0.5f;
		cooldownActual = 0;
		
		sprite = new JLabel();
		sprite.setIcon(new ImageIcon(this.getClass().getResource("/recursos/objetos/barricada.png")));
		sprite.setBounds(this.x, this.y, Gui.spriteSize, Gui.spriteSize);
	}

	public void accion(float estimatedTime) {
	}
	
	public void atacar(Enemigo entidad) {
		if (cooldownActual<=0) {
			entidad.recibirDa�o(da�o);		
			cooldownActual = cooldownAtaque;		
		}
	}
	
	public int getCoste() {
		return 35;
	}
}
