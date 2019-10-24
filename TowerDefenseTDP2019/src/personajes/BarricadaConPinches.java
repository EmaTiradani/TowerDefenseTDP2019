package personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.Enemigo;
import entidades.ObjetoVida;

public class BarricadaConPinches extends ObjetoVida{
	
	protected float daño;
	protected float cooldownAtaque;
	protected float cooldownActual;

	public BarricadaConPinches(int x, int y) {
		super(x, y, 100);
		
		daño = 15;
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
			entidad.recibirDaño(daño);		
			cooldownActual = cooldownAtaque;		
		}
	}
	
	public int getCoste() {
		return 35;
	}
}
