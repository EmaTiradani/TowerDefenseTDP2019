package entidades.abstractas;

import GUI.Gui;
import juego.Juego;
import state.Estado;
import visitor.VisitorDisparoEnemigo;

/**
 * Tipo de disparo utilizado por los enemigos.
 *
 */
public abstract class DisparoEnemigo extends Disparo {

	/**
	 * Crea un disparo en una posición.
	 * @param x - La columna donde se crea el disparo
	 * @param y - La fila donde se crea el disparo
	 * @param dmg - El daño que realiza el disparo cuando impacta contra su objetivo
	 * @param velocidad - La velocida de movimiento del disparo
	 * @param alcance - El alcance del disparo
	 * @param estado - El estado del disparo. Esto puede afectar su velocidad y/o daño.
	 */
	protected DisparoEnemigo(int x, int y, int dmg, int velocidad, int alcance, Estado estado) {
		super(x, y, dmg, velocidad, estado);		
		target = this.x - (alcance*Gui.spriteSize - Gui.spriteSize/2);
		this.x -= Gui.spriteSize/2; //Ubica el inicio del disparo en el centro de la celda
		setVisitor();
	}

	/**
	 * Inicializa el Visitor del disparo. Usado durante la creación del objeto.
	 */
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
