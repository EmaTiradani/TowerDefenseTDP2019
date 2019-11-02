package juego;

import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import GUI.Gui;
import entidades.abstractas.Entidad;
import entidades.concretas.GameOverFlag;
import visitor.Visitor;

/**
 * Clase central de la lógica.
 * Contiene los aspectos principales del juego, que son la colección de las entidades activas y las celdas del mapa.
 * También contiene otros aspectos, como la conexión con la clase principal de la interfaz gráfica, y otros detalles menores como el puntaje y las monedas del jugador.
 *
 */
public class Juego {
	
	protected static Juego INSTANCE = null;
	public static int COMIENZO_MAPA = 10; //Columna inicial del juego.
	public static int FINAL_MAPA = 20; //Columna final del juego. Es aca donde los enemigos empiezan a aparecer
	public static int FILAS_MAPA = 6;
	protected static int MONEDAS_INCIAL = 200;
	
	protected Gui gui;
	protected Celda[][] nivel;
	protected Collection<Entidad> entidades;
	protected HiloEntidades hilo;
	protected HiloOleadas oleadas;
	protected int puntaje;
	protected int monedas;
		
	/**
	 * Crea el juego
	 */
	protected Juego() {
	}	
	
	/**
	 * Método que se utiliza para acceder al objeto juego.
	 * Implementa el diseño Singleton, por lo tanto siempre retorna la misma instancia y esta es la única manera de crear un objeto de tipo Juego.
	 * @return El objeto de tipo Juego
	 */
	public static Juego getJuego() {
		if (INSTANCE==null) {
			INSTANCE = new Juego();
		}
		return INSTANCE;
	}
	
	/**
	 * Comienza el juego, este método solo se utiliza cuando la aplicación iniciar.
	 * Para reiniciar el juego en medio de la apliación, ver el método reiniciarJuego().
	 */
	public void comenzarJuego() {
		entidades = new ConcurrentLinkedQueue<>();
		hilo = new HiloEntidades();
		new Thread(hilo).start();
		
		crearMapa();
		gui = new Gui();
		
		oleadas = new HiloOleadas(gui);
		new Thread(oleadas).start();
		
		monedas = Juego.MONEDAS_INCIAL; 
		gui.actualizarMonedas(monedas);
		
		for (int i=0; i<6; i++) {
			agregarEntidad(new GameOverFlag(Juego.COMIENZO_MAPA-2, i));
		}
	}
	
	/**
	 * Reinicia el juego. Utilizado cuando el juego termina, ya sea por derrota o victoria.
	 * Este método no se utiliza durante la creación del juego, para comenzar el juego por primera vez ver el método comenzarJuego().
	 */
	public void reinciarJuego() {
		hilo = new HiloEntidades();
		new Thread(hilo).start();
		oleadas = new HiloOleadas(gui);
		new Thread(oleadas).start();
		
		gui.reinciarJuego();
		monedas = Juego.MONEDAS_INCIAL;
		gui.actualizarMonedas(monedas);
		
		for (int i=0; i<6; i++) {
			agregarEntidad(new GameOverFlag(Juego.COMIENZO_MAPA-2, i));
		}
	}
	
	/**
	 * Retorna verdadero si la celda está ocupada y falso en otro caso.
	 * @param x - La columna de la celda
	 * @param y - La fila de la celda
	 * @return Verdadero si la celda está ocupada. Falso en otro caso
	 */
	public boolean celdaEstaOcupada(int x, int y) {
		return nivel[y][x].getEntidad()!=null;
	}
	
	/**
	 * Establece una entidad en la celda.
	 * @param x - La columna de la celda
	 * @param y - La fila de la celda
	 * @param e - La entidad que ocupará la celda
	 */
	public void setEntidad(int x, int y, Entidad e) {
		nivel[y][x].setEntidad(e);
	}
	
	/**
	 * Retorna la entidad que ocupa la celda.
	 * @param x - La columna de la celda
	 * @param y - La fila de la celda
	 * @return La entidad que ocupa la celda
	 */
	public Entidad getEntidad(int x, int y) {
		return nivel[y][x].getEntidad();
	}
	
	/**
	 * Agrega una entidad al juego, tanto en la lógica como en la gráfica.
	 * Este método no agrega la entidad al mapa, eso debe realizarse con el método setEntidad
	 * @param e - La entidad a agregar
	 */
	public void agregarEntidad(Entidad e) {
		gui.agregarEntidad(e);
		entidades.add(e);		
	}
	
	/**
	 * Crea el mapa, inicializando todas las celdas.
	 */
	protected void crearMapa() {
		nivel = new Celda[6][30];//El juego solo tiene 10 columnas visibles.
		//Las otras 20 son columnas invisibles en ambos lados del juego para que los disparos puedan pasar sin caer del arreglo
		
		for(int i=0; i<nivel.length; i++) {
			for(int j=0; j<nivel[0].length; j++) {
				nivel[i][j] = new Celda();
			}
		}
	}

	/**
	 * Realiza una acción a todas las entidades
	 * @param estimatedTime - El tiempo que pasó desde la ultima vez que se llamó a este método.
	 * 	Si es la primera vez que se lo llama, el valor es el tiempo transcurrido desde el inicio de la creación del juego.
	 */
	public void moverEntidades(float estimatedTime) {
		for (Entidad e : entidades) {
			e.accion(estimatedTime);
		}		
	}

	/**
	 * Remueve una entidad, tanto de la lógica como de la gráfica. Esto también la elimina del mapa.
	 * @param entidad - Entidad a eliminar
	 */
	public void matar(Entidad entidad) {
		entidades.remove(entidad);		
		gui.remove(entidad);
		Entidad e = nivel[entidad.getY()/Gui.spriteSize][entidad.getX()/Gui.spriteSize].getEntidad();
		if (e==entidad) {
			nivel[entidad.getY()/Gui.spriteSize][entidad.getX()/Gui.spriteSize].setEntidad(null);
		}
		
	}

	/**
	 * Dado un objeto Visitor, hace que todas las entidades acepten dicho visitor.
	 * @param v - El visitor
	 */
	public void visitarEntidades(Visitor v) {
		for (Entidad e : entidades) {
			e.accept(v);
		}
		
	}

	/**
	 * Retorna las monedas disponibles para el jugador.
	 * @return - Las monedas del jugador
	 */
	public int getMonedas() {
		return monedas;
	}
	
	/**
	 * Suma una cantidad de puntos al puntaje.
	 * @param i - Puntos a sumar. Si el número es negativo, se realiza un resta.
	 */
	public void sumarPuntos(int i) {
		puntaje += i;
		gui.actualizarPuntaje(puntaje);
		sumarMonedas(i);
	}

	/**
	 * Suma una cantidad de monedas.
	 * @param i - Monedas a sumar. Si el número es negativo, se realiza un resta.
	 */
	public void sumarMonedas(int i) {
		monedas += i;
		gui.actualizarMonedas(monedas);		
	}
	
	/**
	 * El juego terminó en derrota, por lo tanto se elmina todos las entidades, se terminan los hilos y se muestra por pantalla un mensaje de derrota.
	 */
	public void perder() {
		hilo.setGameOver(true);
		oleadas.setGameOver(true);
		for (Entidad e : entidades) {
			matar(e);
		}
		gui.perder();
	}

	/**
	 * El juego terminó en derrota, por lo tanto se elmina todos las entidades, se terminan los hilos y se muestra por pantalla un mensaje de victoria.
	 */
	public void ganar() {
		hilo.setGameOver(true);
		oleadas.setGameOver(true);
		for (Entidad e : entidades) {
			matar(e);
		}
		gui.ganar();
	}

	/**
	 * Crea un nuevo nivel, por lo tanto se eliminan todas las entidades activas y se reinician las monedas al valor por defecto.
	 */
	public void nuevoNivel() {
		for (Entidad e : entidades) {
			matar(e);
		}
		monedas = Juego.MONEDAS_INCIAL;
		gui.actualizarMonedas(monedas);
	}

}
