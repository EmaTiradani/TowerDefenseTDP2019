package entidades;

import GUI.Gui;
import juego.Juego;
import visitor.VisitorDisparoAliado;

public abstract class DisparoAliado extends Disparo{
	
	protected DisparoAliado(int x, int y, int daño, int vel, int alcance) {
		super(x, y, daño, vel);		
		target = this.x + alcance*Gui.spriteSize;
		setVisitor();
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
