package entidades;

public abstract class EnemigoCerca extends Enemigo {
	
	protected int da�o;

	protected EnemigoCerca(int x, int y, int vida, int vel, int cooldown, int da�o, int puntaje) {
		super(x, y, vida, vel, cooldown, puntaje);
		this.da�o = da�o;
	}
	
	public void atacar(Atacable a) {
		if (cooldownActual<=0) {
			System.out.println("Ataque");
			cooldownActual = cooldownAtaque;	
			a.recibirDa�o(da�o);
		}
	}
}
