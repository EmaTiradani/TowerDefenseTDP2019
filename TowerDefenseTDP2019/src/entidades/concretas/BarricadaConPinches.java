package entidades.concretas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.abstractas.Atacable;
import entidades.abstractas.Entidad;
import entidades.abstractas.ObjetoVida;
import juego.Juego;
import visitor.VisitorBarricadaPinches;

public class BarricadaConPinches extends ObjetoVida{
	
	protected float daño;
	protected float cooldownAtaque;
	protected float cooldownActual;

	public BarricadaConPinches(int x, int y) {
		super(x, y, 100);
		
		daño = 20;
		cooldownAtaque = 0.2f;
		cooldownActual = 0;
		
		sprite = new JLabel();
		sprite.setIcon(new ImageIcon(this.getClass().getResource("/recursos/objetos/barricada.png")));
		sprite.setBounds(this.x, this.y, Gui.spriteSize, Gui.spriteSize);
		
		setVisitor();
	}
	
	protected void setVisitor() {
		miVisitor = new VisitorBarricadaPinches(this);
	}

	public void accion(float estimatedTime) {
		cooldownActual -= estimatedTime;
		Entidad e = Juego.getJuego().getEntidad(x/Gui.spriteSize+1, y/Gui.spriteSize);
		if (e!=null) {
			e.accept(miVisitor);
		}
	}
	
	public void atacar(Atacable entidad) {
		if (cooldownActual<=0) {
			entidad.recibirDaño(daño);		
			cooldownActual = cooldownAtaque;		
		}
	}
}
