package entidades.abstractas;

import GUI.Gui;
import juego.Juego;
import state.Estado;
import visitor.VisitorDisparoEnemigo;

public abstract class DisparoEnemigo extends Disparo {

	protected DisparoEnemigo(int x, int y, int dmg, int velocidad, int alcance, Estado estado) {
		super(x, y, dmg, velocidad, estado);		
		target = this.x - (alcance*Gui.spriteSize - Gui.spriteSize/2);
		this.x -= Gui.spriteSize/2; //Ubica el inicio del disparo en el centro de la celda
		setVisitor();
	}

	protected void setVisitor() {
		miVisitor = new VisitorDisparoEnemigo(this);
	}

	public void mover() {
		x-= estado.getVelocidad(velocidad);
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
