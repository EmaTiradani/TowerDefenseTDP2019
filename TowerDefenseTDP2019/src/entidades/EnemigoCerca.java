package entidades;

public abstract class EnemigoCerca extends Enemigo {
	
	protected int daño;

	protected EnemigoCerca(int x, int y, int vida, int vel, int cooldown, int daño, int puntaje) {
		super(x, y, vida, vel, cooldown, puntaje);
		this.daño = daño;
	}
	
	public void atacar(Atacable a) {
		if (cooldownActual<=0) {
			cooldownActual = cooldownAtaque;	
			a.recibirDaño(daño);
		}
	}
}
