package mapa;

public class Mapa {
	
	private Celda[][] cells;
	
	public Mapa() {
		cells = new Celda[6][10];
		for(int i=0; i<6; i++) {
			for(int j=0; j<10; j++) {
				cells[i][j] = new Celda();
			}
		}
	}
}
