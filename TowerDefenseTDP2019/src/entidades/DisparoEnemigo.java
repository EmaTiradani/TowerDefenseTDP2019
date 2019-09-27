package entidades;

import GUI.Gui;
import juego.Juego;
import visitor.VisitorDisparoEnemigo;

public abstract class DisparoEnemigo extends Disparo {

	protected DisparoEnemigo(int x, int y, int dmg, int velocidad, int alcance) {
		super(x, y, dmg, velocidad);		
		target = this.x - alcance*Gui.spriteSize;
		setVisitor();
	}

	protected void setVisitor() {
		miVisitor = new VisitorDisparoEnemigo(this);
	}

	public void mover() {
		x-= velocidad;
		sprite.setBounds(x, y, Gui.spriteSize, Gui.spriteSize);
		if (x<=target) {
			morir();
		}		
	}

	public void accion(float estimatedTime) {
		Juego.getJuego().visitarEntidades(miVisitor);		
		mover();		
	}
	
	

}
