package entidades;

public abstract class Personaje extends Entidad implements Atacable {
	
	protected int maxVida;
	protected float vida;
	protected int cooldownAtaque;
	protected float cooldownActual;
	
	protected Personaje(int x, int y, int vida, int cooldown) {
		super(x, y);
		maxVida = vida;
		this.vida = vida;
		cooldownAtaque = cooldown;
		cooldownActual = 0;
	}
	
	
	public void recibirDaño(float daño) {
		vida -= daño;
		if (vida<=0) {
			morir();
		}
	}
}
