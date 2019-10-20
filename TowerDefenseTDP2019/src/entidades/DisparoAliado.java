package entidades;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import juego.Juego;
import visitor.VisitorDisparoAliado;

public abstract class DisparoAliado extends Disparo{
	
	protected DisparoAliado(int x, int y, int daño, int vel, int alcance) {
		super(x, y, daño, vel);		
		target = this.x + alcance*Gui.spriteSize + Gui.spriteSize/2;
		setVisitor();
		
		sprite = new JLabel();
		sprite.setIcon(new ImageIcon(this.getClass().getResource("/recursos/arrow.png")));
		sprite.setBounds(this.x, this.y, Gui.spriteSize, Gui.spriteSize);
	}
	
	protected void setVisitor() {
		miVisitor = new VisitorDisparoAliado(this);
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
