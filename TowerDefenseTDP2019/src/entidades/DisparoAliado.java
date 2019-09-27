package entidades;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import juego.Juego;
import visitor.VisitorDisparoAliado;

public abstract class DisparoAliado extends Disparo{
	
	protected DisparoAliado(int x, int y, int da�o, int vel, int alcance) {
		super(x, y, da�o, vel);
		
		sprite = new JLabel();
		sprite.setIcon(new ImageIcon(this.getClass().getResource("/recursos/arrow.png")));
		sprite.setBounds(this.x, this.y, Gui.spriteSize, Gui.spriteSize);
		
		target = this.x + alcance*Gui.spriteSize;
		setVisitor();
	}
	
	protected void setVisitor() {
		miVisitor = new VisitorDisparoAliado(this);
	}

	public int getDa�o() {
		return dmg;
		
	}
	
	public void mover() {
		x+= velocidad;
		sprite.setBounds(x, y, Gui.spriteSize, Gui.spriteSize);
		if (x>=target) {
			morir();
		}
	}
	
	public void accion(float estimatedTime) {		
		Juego.getJuego().visitarEntidades(miVisitor);		
		mover();				
	}
	
}
