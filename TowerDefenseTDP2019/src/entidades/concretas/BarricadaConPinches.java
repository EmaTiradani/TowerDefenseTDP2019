package entidades.concretas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.abstractas.Atacable;
import entidades.abstractas.Entidad;
import entidades.abstractas.ObjetoVida;
import juego.Juego;
import visitor.VisitorBarricadaPinches;

/**
 * Tipo de objeto que tiene dos funciones: la primera es funcionar como un obstaculo de los enemigos,
 * y la segunda es realizar daño al enemigo que tiene en frente.
 *
 */
public class BarricadaConPinches extends ObjetoVida{
	
	protected float daño;
	protected float cooldownAtaque;
	protected float cooldownActual;

	/**
	 * Crea una barricada con pinches.
	 * @param x - La columna donde se crea el objeto
	 * @param y - La fila donde se crea el objeto
	 */
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
	
	/**
	 * Inicializa el Visitor de la barricada con pinches. Usado durante la creación del objeto.
	 */
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
	
	/**
	 * Realiza un ataque contra una entidad.
	 * @param entidad - La entidad que será atacada
	 */
	public void atacar(Atacable entidad) {
		if (cooldownActual<=0) {
			entidad.recibirDaño(daño);		
			cooldownActual = cooldownAtaque;		
		}
	}
}
