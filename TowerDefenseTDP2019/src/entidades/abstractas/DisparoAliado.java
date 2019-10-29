package entidades.abstractas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import juego.Juego;
import state.Estado;
import visitor.VisitorDisparoAliado;

public abstract class DisparoAliado extends Disparo{
	
	protected DisparoAliado(int x, int y, int daño, int vel, int alcance, Estado estado) {
		super(x, y, daño, vel, estado);		
		target = this.x + alcance*Gui.spriteSize + Gui.spriteSize/2;
		setVisitor();
		this.x += Gui.spriteSize/2; //Ubica el inicio del disparo en el centro de la celda
		
		sprite = new JLabel();
		sprite.setIcon(new ImageIcon(this.getClass().getResource("/recursos/arrow.png")));
		sprite.setBounds(this.x, this.y, Gui.spriteSize, Gui.spriteSize);
	}
	
	protected void setVisitor() {
		miVisitor = new VisitorDisparoAliado(this);
	}

	public void mover() {
		x+= estado.getVelocidad(velocidad);
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
