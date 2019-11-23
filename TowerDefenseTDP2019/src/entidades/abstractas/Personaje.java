package entidades.abstractas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import state.Estado;
import state.Normal;

/**
 * Los personajes son todos los objetos que representan una unidad de combate.
 * Estas unidades son capaces de atacar y ser atacadas.
 * Otra característica que comparten todos los personajes es la capacidad de tener un Estado que puede cambiar.
 * Estos estados permiten cambiar el poder del personaje, ya sea a la hora de atacar o ser atacado.
 */
public abstract class Personaje extends Entidad implements Atacable {
	
	protected int maxVida;
	protected float vida;
	protected int cooldownAtaque;
	protected float cooldownActual;
	protected Estado estado;
	protected JLabel barraVida;
	protected float cooldownEstado;//0: Estado normal - Positivo: Estado temporal activo - Negativo: el estado debe terminar
	
	/**
	 * Crea un personaje en una posición. El personaje es creado con un estado Normal.
	 * @param x - La columna donde se crea el personaje
	 * @param y - La fila donde se crea el personaje
	 * @param vida - La vida maxima del personaje
	 * @param cooldown - El tiempo que tiene que esperar para poder realizar una ataque.
	 */
	protected Personaje(int x, int y, int vida, int cooldown) {
		super(x, y);
		maxVida = vida;
		this.vida = vida;
		cooldownAtaque = cooldown;
		cooldownActual = 0;
		estado = new Normal();	
		cooldownEstado = 0;
	}
	
	/**
	 * Agrega un componente gráfico al personaje que refleja el estado actual de su vida.
	 * Esto permite al usuario de la aplicación tener una idea aproximada de la vida actual de cada personaje.
	 */
	protected void agregarBarraVida() {
		barraVida = new JLabel(new ImageIcon(this.getClass().getResource("/recursos/barra_vida.png")));
		sprite.add(barraVida);
		barraVida.setBounds(0, Gui.spriteSize-12, Gui.spriteSize, 12);
		sprite.repaint();
	}
	
	/**
	 * Actualiza la barra de vida. Este método debe ser llamado cada vez que hay una modificación en la vida del objeto.
	 */
	protected void actualizarVida() {
		int ancho = (int) ((vida/maxVida) * Gui.spriteSize);
		barraVida.setBounds(0, Gui.spriteSize-12, ancho, 12);
	}
	
	public void recibirDaño(float daño) {
		vida -= estado.recibirDaño(daño);
		actualizarVida();
		if (vida<=0) {
			morir();
		}
	}

	/**
	 * Actualiza el estado. Este método deber ser llamado para mantener un control en los estados,
	 * ya que la mayoria de ellos tiene un tiempo límite, por lo tanto este método debe elminar el estado actual si su tiempo ha terminado.
	 * @param estimatedTime - El tiempo que pasó desde la ultima vez que se llamó a este método.
	 * 	Si es la primera vez que se lo llama, el valor es el tiempo transcurrido desde el inicio de la creación del objeto.
	 */
	protected void actualizarEstado(float estimatedTime) {
		if (cooldownEstado!=0) {
			//El estado no es normal, por lo tanto tiene un limite temporal
			cooldownEstado -= estimatedTime;
			if (cooldownEstado<0) {
				//Si el tiempo del estado termino, se vuelve al estado normal
				estado = new Normal();
				cooldownEstado = 0;
			}
		}
	}

	/**
	 * Cambia el estado del personaje.
	 * @param e - Nuevo estado a asignar.
	 * @param tiempo - El tiempo que dura este estado. Si el tiempo es 0, el estado se mantiene indefinidamente.
	 */
	public void setEstado(Estado e, float tiempo) {
		estado = e;
		cooldownEstado = tiempo;
	}

	/**
	 * Recupera la vida del personaje, haciendo que su vida actual vuelva al valor de cuando fue creado.
	 */
	public void recuperarVida() {
		vida = maxVida;
		actualizarVida();
	}
	
	/**
	 * Retorna verdadero si el personaje tiene su vida al máximo.
	 * @return Verdadero si el personaje tiene su vida al máximo. Falso en otro caso.
	 */
	public boolean estaSano() {
		return vida == maxVida;
	}
}
