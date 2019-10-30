package entidades.abstractas;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import state.Estado;
import state.Normal;

public abstract class Personaje extends Entidad implements Atacable {
	
	protected int maxVida;
	protected float vida;
	protected int cooldownAtaque;
	protected float cooldownActual;
	protected Estado estado;
	protected JLabel barraVida;
	protected float cooldownEstado;//0: Estado normal - Positivo: Estado temporal activo - Negativo: el estado debe terminar
	
	protected Personaje(int x, int y, int vida, int cooldown) {
		super(x, y);
		maxVida = vida;
		this.vida = vida;
		cooldownAtaque = cooldown;
		cooldownActual = 0;
		estado = new Normal();	
		cooldownEstado = 0;
	}
	
	protected void agregarBarraVida() {
		barraVida = new JLabel(new ImageIcon(this.getClass().getResource("/recursos/barra_vida.png")));
		sprite.add(barraVida);
		barraVida.setBounds(0, Gui.spriteSize-12, Gui.spriteSize, 12);
		sprite.repaint();
	}
	
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

	public void setEstado(Estado e, float tiempo) {
		estado = e;
		cooldownEstado = tiempo;
	}

	public void recuperarVida() {
		vida = maxVida;
		actualizarVida();
	}
}
