package juego;

public class HiloEntidades implements Runnable {
	
	protected long timer;
	protected float estimatedTime;
	protected boolean gameOver;
	
	public HiloEntidades() {
		gameOver = false;
	}
	
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
