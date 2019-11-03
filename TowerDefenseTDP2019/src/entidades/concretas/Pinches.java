package entidades.concretas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.abstractas.Atacable;
import entidades.abstractas.Entidad;
import entidades.abstractas.ObjetoTemporal;
import juego.Juego;
import visitor.VisitorPinche;

/**
 * Tipo de objeto que realiza da�o al enemigo que est� encima de este.
 *
 */
public class Pinches extends ObjetoTemporal {

	protected float da�o;
	protected float cooldownAtaque;
	protected float cooldownActual;

	public Pinches(int x, int y) {
		super(x, y, 20);
		
		da�o = 15;
		cooldownAtaque = 0.5f;
		cooldownActual = 0;
		
		sprite = new JLabel();
		sprite.setIcon(new ImageIcon(this.getClass().getResource("/recursos/objetos/pinches.png")));
		sprite.setBounds(this.x, this.y, Gui.spriteSize, Gui.spriteSize);
		
		setVisitor();
	}
	
	/**
	 * Inicializa el Visitor de los pinches. Usado durante la creaci�n del objeto.
	 */
	protected void setVisitor() {
		miVisitor = new VisitorPinche(this);
	}
	
	public void accion(float estimatedTime) {
		super.accion(estimatedTime);
		cooldownActual -= estimatedTime;
		
		Entidad e = Juego.getJuego().getEntidad(x/Gui.spriteSize, y/Gui.spriteSize);
		if (e!=null) {
			e.accept(miVisitor);
		}
	}

	/**
	 * Realiza un ataque contra una entidad.
	 * @param entidad - La entidad que ser� atacada
	 */
	public void atacar(Atacable entidad) {
		if (cooldownActual<=0) {
			entidad.recibirDa�o(da�o);		
			cooldownActual = cooldownAtaque;		
		}
	}

}
