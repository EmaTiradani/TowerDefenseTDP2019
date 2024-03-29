package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import entidades.abstractas.Entidad;
import juego.Juego;
import listeners.ReiniciarJuegoListener;
import listeners.comprables.ComprableBarricada;
import listeners.comprables.ComprableBomba;
import listeners.comprables.ComprableDa�o;
import listeners.comprables.ComprableFortaleza;
import listeners.comprables.ComprableHielo;
import listeners.comprables.ComprableTorreBasica;
import listeners.comprables.ComprableTorreDoble;
import listeners.comprables.ComprableTorreNormal;
import listeners.comprables.ComprableTorreRapida;

/**
 * Clase central que maneja la interfaz gr�fica
 *
 */
public class Gui extends JFrame{
	protected JLabel mapa;	
	
	public static int spriteSize = 90;
	
	protected JLabel score;
	protected JLabel monedas;
	
	//Botones torres
	protected JButton btnTorreBasica;
	protected JButton btnTorreNormal;
	protected JButton btnTorreRapida;
	protected JButton btnFortaleza;
	protected JButton btnTorreDoble;
	
	//Botones objetos comprables
	protected JButton btnBarricada;
	protected JButton btnBomba;
	protected JButton btnDa�o;
	protected JButton btnHielo;
	
	protected JLabel mensajeFinal;
	
	/**
	 * Crea la interfaz gr�fica del juego.
	 */
	public Gui() {		
		//Inicializaci�n del frame
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		this.pack();
		Insets in = this.getInsets();
		
		int altura = Gui.spriteSize*6+in.top+in.bottom+220;
		int ancho = Gui.spriteSize*10+in.left+in.right;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) screenSize.getWidth()/2-ancho/2;
		int y = (int) screenSize.getHeight()/2-altura/2;
		
		this.setBounds(x, y, ancho, altura);
		this.setLayout(null);
		
		//Mapa
		mapa = new JLabel();
		mapa.setBounds(-Gui.spriteSize*Juego.COMIENZO_MAPA,0, Gui.spriteSize*20, Gui.spriteSize*6);
		this.getContentPane().add(mapa);
		
		//Puntaje y monedas
		score = new JLabel("Puntaje: " + 0);
		score.setBounds(0, mapa.getHeight(), 200, 32);
		this.getContentPane().add(score);
		monedas = new JLabel();
		monedas.setBounds(score.getWidth(), mapa.getHeight(), 200, 32);
		this.getContentPane().add(monedas);
		
		//Mensaje victoria/derrota
		mensajeFinal = new JLabel();
		mensajeFinal.setBounds(ancho/2-200, altura/3, 400, 75);
		mensajeFinal.setVisible(false);
		mensajeFinal.setFont(new Font("Arial", Font.BOLD, 32));
		mensajeFinal.setHorizontalAlignment(SwingConstants.CENTER);
		mensajeFinal.setVerticalAlignment(SwingConstants.CENTER);
		mensajeFinal.addMouseListener(new ReiniciarJuegoListener());
		this.getContentPane().add(mensajeFinal, 0);
		
		this.agregarBotonesComprables();

		this.repaint();
	}
	
	/**
	 * Agrega gr�ficamente una entidad al mapa del juego.
	 * @param e - La entidad a agregar.
	 */
	public void agregarEntidad(Entidad e) {
		mapa.add(e.getSprite(), 0);	
		mapa.repaint();
	}
	
	/**
	 * Actualiza el componente gr�fico que notifica al usuario del puntaje actual.
	 * @param puntaje - Puntaje actual
	 */
	public void actualizarPuntaje(int puntaje) {
		score.setText("Puntaje: " + puntaje);
		score.repaint();
	}
	
	/**
	 * Actualiza el componente gr�fico que notifica al usuario de las monedas actuales.
	 * @param monedas - Monedas actuales
	 */
	public void actualizarMonedas(int monedas) {
		this.monedas.setText("Monedas: " + monedas);
		this.monedas.repaint();
	}
	
	/**
	 * Cambia gr�ficamente de nivel, es decir, cambia el fondo del mapa.
	 * @param i - El n�mero de nivel a cargar
	 */
	public void cambiarNivel(int i) {
		mapa.setIcon(new ImageIcon(this.getClass().getResource("/recursos/nivel_" + i + ".jpg")));
	}

	/**
	 * Elimina gr�ficamente una entidad del mapa.
	 * @param entidad - Entidad a eliminar
	 */
	public void remove(Entidad entidad) {
		mapa.remove(entidad.getSprite());
		mapa.repaint();
	}
	
	/**
	 * Eliminar el mensaje de fin de juego, permitiendo que el jugador pueda volver a intentar el juegp.
	 */
	public void reinciarJuego() {
		mensajeFinal.setVisible(false);
		mensajeFinal.repaint();
	}
	
	/**
	 * Muestra el mensaje de derrota.
	 */
	public void perder() {
		mensajeFinal.setText("<html>PERDISTE<br>Click aca para reiniciar</html>");
		mensajeFinal.setForeground(Color.RED);
		mensajeFinal.setVisible(true);
		mensajeFinal.repaint();
	}
	
	/**
	 * Muestra el mensaje de victoria.
	 */
	public void ganar() {
		mensajeFinal.setText("GANASTE");
		mensajeFinal.setForeground(Color.BLUE);
		mensajeFinal.setVisible(true);
		mensajeFinal.repaint();
	}
	
	/**
	 * Agrega todos los botones necesarios para comprar los personajes, objetos y power ups.
	 */
	protected void agregarBotonesComprables() {
		MouseAdapter ma;
		
		//Boton crear TorreBasica
		btnTorreBasica = new JButton();
		btnTorreBasica.setBounds(Gui.spriteSize*0, mapa.getHeight() + score.getHeight(), Gui.spriteSize, Gui.spriteSize);
		btnTorreBasica.setIcon(new ImageIcon(this.getClass().getResource("/recursos/aliados/aliado02.png")));
		this.getContentPane().add(btnTorreBasica);		
		ma = new ComprableTorreBasica(this);
		btnTorreBasica.addMouseListener(ma);
		btnTorreBasica.addMouseMotionListener(ma);
		
		//Boton crear TorreNormal
		btnTorreNormal = new JButton();
		btnTorreNormal.setBounds(Gui.spriteSize*1, mapa.getHeight() + score.getHeight(), Gui.spriteSize, Gui.spriteSize);
		btnTorreNormal.setIcon(new ImageIcon(this.getClass().getResource("/recursos/aliados/aliado01.png")));
		this.getContentPane().add(btnTorreNormal);		
		ma = new ComprableTorreNormal(this);
		btnTorreNormal.addMouseListener(ma);
		btnTorreNormal.addMouseMotionListener(ma);
		
		//Boton crear TorreRapida
		btnTorreRapida = new JButton();
		btnTorreRapida.setBounds(Gui.spriteSize*2, mapa.getHeight() + score.getHeight(), Gui.spriteSize, Gui.spriteSize);
		btnTorreRapida.setIcon(new ImageIcon(this.getClass().getResource("/recursos/aliados/aliado03.png")));
		this.getContentPane().add(btnTorreRapida);		
		ma = new ComprableTorreRapida(this);
		btnTorreRapida.addMouseListener(ma);
		btnTorreRapida.addMouseMotionListener(ma);
		
		//Boton crear Fortaleza
		btnFortaleza = new JButton();
		btnFortaleza.setBounds(Gui.spriteSize*3, mapa.getHeight() + score.getHeight(), Gui.spriteSize, Gui.spriteSize);
		btnFortaleza.setIcon(new ImageIcon(this.getClass().getResource("/recursos/aliados/aliado04.png")));
		this.getContentPane().add(btnFortaleza);		
		ma = new ComprableFortaleza(this);
		btnFortaleza.addMouseListener(ma);
		btnFortaleza.addMouseMotionListener(ma);
		
		//Boton crear TorreDoble
		btnTorreDoble = new JButton();
		btnTorreDoble.setBounds(Gui.spriteSize*4, mapa.getHeight() + score.getHeight(), Gui.spriteSize, Gui.spriteSize*2);
		btnTorreDoble.setIcon(new ImageIcon(this.getClass().getResource("/recursos/aliados/aliado_doble01.png")));
		this.getContentPane().add(btnTorreDoble);		
		ma = new ComprableTorreDoble(this);
		btnTorreDoble.addMouseListener(ma);
		btnTorreDoble.addMouseMotionListener(ma);
		
		//Boton crear Barricada
		btnBarricada = new JButton();
		btnBarricada.setBounds(Gui.spriteSize*5, mapa.getHeight() + score.getHeight() + btnTorreBasica.getHeight(), Gui.spriteSize, Gui.spriteSize);
		btnBarricada.setIcon(new ImageIcon(this.getClass().getResource("/recursos/objetos/muro.png")));
		this.getContentPane().add(btnBarricada);		
		ma = new ComprableBarricada(this);
		btnBarricada.addMouseListener(ma);
		btnBarricada.addMouseMotionListener(ma);
		
		//Boton crear Bomba
		btnBomba = new JButton();
		btnBomba.setBounds(Gui.spriteSize*6, mapa.getHeight() + score.getHeight() + btnTorreBasica.getHeight(), Gui.spriteSize, Gui.spriteSize);
		btnBomba.setIcon(new ImageIcon(this.getClass().getResource("/recursos/objetos/bomba.png")));
		this.getContentPane().add(btnBomba);		
		ma = new ComprableBomba(this);
		btnBomba.addMouseListener(ma);
		btnBomba.addMouseMotionListener(ma);
		
		//Boton crear power up: mas da�o
		btnDa�o = new JButton();
		btnDa�o.setBounds(Gui.spriteSize*7, mapa.getHeight() + score.getHeight() + btnTorreBasica.getHeight(), Gui.spriteSize, Gui.spriteSize);
		btnDa�o.setIcon(new ImageIcon(this.getClass().getResource("/recursos/objetos/ataque.png")));
		this.getContentPane().add(btnDa�o);		
		ma = new ComprableDa�o(this);
		btnDa�o.addMouseListener(ma);
		
		//Boton crear power up: reducir velocidad a enemigos
		btnHielo = new JButton();
		btnHielo.setBounds(Gui.spriteSize*8, mapa.getHeight() + score.getHeight() + btnTorreBasica.getHeight(), Gui.spriteSize, Gui.spriteSize);
		btnHielo.setIcon(new ImageIcon(this.getClass().getResource("/recursos/objetos/hielo.png")));
		this.getContentPane().add(btnHielo);		
		ma = new ComprableHielo(this);
		btnHielo.addMouseListener(ma);
	}	
}
