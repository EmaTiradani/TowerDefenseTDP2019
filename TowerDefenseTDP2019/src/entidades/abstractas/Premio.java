package entidades.abstractas;

import java.awt.event.MouseListener;

import listeners.PremioListener;
import visitor.Visitor;

public abstract class Premio extends Objeto {

	protected Premio(int x, int y) {
		super(x, y);
	}

	public void accion(float estimatedTime) {
	}

	public void accept(Visitor v) {
	}
	
	public void morir() {
		super.morir();
		activarEffecto();
	}
	
	protected abstract void activarEffecto();
	
	protected void agregarListener() {
		MouseListener ml = new PremioListener(this);
		sprite.addMouseListener(ml);
	}

}
