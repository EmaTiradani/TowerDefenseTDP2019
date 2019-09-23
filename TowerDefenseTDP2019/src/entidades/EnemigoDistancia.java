package entidades;

public abstract class EnemigoDistancia extends Enemigo {
	
	protected int alcance;

	protected EnemigoDistancia(int x, int y, int vida, int cooldown, int vel, int alcance, int puntaje) {
		super(x, y, vida, cooldown, vel, puntaje);
		this.alcance = alcance;
	}

}
