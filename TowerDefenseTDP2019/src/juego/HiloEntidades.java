package juego;

/**
 * Hilo encargado de controlar las acciones de todas las entidades activas.
 *
 */
public class HiloEntidades implements Runnable {
	
	protected long timer;
	protected float estimatedTime;
	protected boolean gameOver;
	
	/**
	 * Crea el hilo.
	 */
	public HiloEntidades() {
		gameOver = false;
	}
	
	/**
	 * Establece si el juego terminó.
	 * @param go - Booleano que, si es verdadero, determina que el juego terminó
	 */
	public void setGameOver(boolean go) {
		gameOver = go;
	}
	
	public void run() {
		while (!gameOver) {
			try {
				timer = System.nanoTime();
				Thread.sleep(100);
				estimatedTime = (System.nanoTime() - timer)/1000000000.0f;
				Juego.getJuego().moverEntidades(estimatedTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
