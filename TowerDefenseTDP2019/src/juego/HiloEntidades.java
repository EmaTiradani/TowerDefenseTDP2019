package juego;

public class HiloEntidades implements Runnable {
	
	protected long timer;
	protected float estimatedTime;
	
	public void run() {
		while (true) {
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
