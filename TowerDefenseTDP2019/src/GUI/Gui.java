package GUI;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.TransferHandler;

import entidades.Entidad;
import juego.Juego;
import visitor.VisitorMatar;

public class Gui extends JFrame{
	protected JLabel mapa;	
	
	public static int spriteSize = 90;
	
	protected JLabel score;
	
	protected JButton at;
	
	public Gui() {		
		//Inicialización del frame
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		this.pack();
		Insets in = this.getInsets();
		
		int altura = Gui.spriteSize*6+in.top+in.bottom+200;
		int ancho = Gui.spriteSize*10+in.left+in.right;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) screenSize.getWidth()/2-ancho/2;
		int y = (int) screenSize.getHeight()/2-altura/2;
		
		this.setBounds(x, y, ancho, altura);
		this.setLayout(null);
		
		//Mapa
		mapa = new JLabel();
		mapa.setBounds(-Gui.spriteSize*Juego.COMIENZO_MAPA,0, Gui.spriteSize*20, Gui.spriteSize*6);
		mapa.setIcon(new ImageIcon(this.getClass().getResource("/recursos/game ground2.jpg")));	
		this.getContentPane().add(mapa);
		
		//Puntaje
		score = new JLabel("Puntaje: " + 0);
		score.setBounds(0, mapa.getHeight(), 200, 32);
		this.getContentPane().add(score);
		
		//Boton crear AliadoTest
		at = new JButton("Crear Aliado Test");
		at.setBounds(0, mapa.getHeight() + score.getHeight(), 200, 32);
		this.getContentPane().add(at);
		
		this.agregarBotonesComprables();

		this.repaint();
	}
	
	public void agregarEntidad(Entidad e) {
		mapa.add(e.getSprite(), 0);	
		mapa.repaint();
	}
	
	public void actualizarPuntaje(int puntaje) {
		score.setText("Puntaje: " + puntaje);
		score.repaint();
	}

	public void remove(Entidad entidad) {
		mapa.remove(entidad.getSprite());
		mapa.repaint();
	}
	
	protected void agregarBotonesComprables() {
		JLabel jl = new JLabel(new ImageIcon(this.getClass().getResource("/recursos/cannon.png")));
		//jl.setBounds(0, 0, Gui.spriteSize, Gui.spriteSize);
		this.getContentPane().add(jl, 0);
		MouseAdapter ma = new ComprableMotionListener(jl, this);
		at.addMouseListener(ma);
		at.addMouseMotionListener(ma);
	}
}
