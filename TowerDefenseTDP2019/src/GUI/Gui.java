package GUI;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import entidades.Entidad;
import juego.Juego;
import visitor.VisitorMatar;

public class Gui extends JFrame{
	protected JLabel mapa;	
	
	public static int spriteSize = 90;
	
	protected JLabel score;
	
	public Gui() {		
		//Inicialización del frame
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.pack();
		Insets in = this.getInsets();
		this.setBounds(0,0,Gui.spriteSize*10+300+in.left+in.right,Gui.spriteSize*6+in.top+in.bottom);
		this.setLayout(null);
		
		//Mapa
		mapa = new JLabel();
		mapa.setBounds(0,0, Gui.spriteSize*10, Gui.spriteSize*6);
		mapa.setIcon(new ImageIcon(this.getClass().getResource("/recursos/game ground.jpg")));	
		this.getContentPane().add(mapa);
		
		//Boton Eliminar
		JButton eliminar = new JButton("EliminarEnemigos");
		this.getContentPane().add(eliminar);
		eliminar.setBounds(mapa.getBounds().width, 0, 200, 32);
		eliminar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				Juego.getJuego().visitarEntidades(new VisitorMatar());				
			}
			
		});
		
		//Puntaje
		score = new JLabel("Puntaje: " + 0);
		score.setBounds(mapa.getBounds().width, eliminar.getBounds().height, 200, 32);
		this.getContentPane().add(score);
		

		this.repaint();
	}
	
	public void agregarEntidad(Entidad e) {
		mapa.add(e.getSprite());	
		this.repaint();
	}
	
	public void actualizarPuntaje(int puntaje) {
		score.setText("Puntaje: " + puntaje);
		this.repaint();
	}

	public void remove(Entidad entidad) {
		mapa.remove(entidad.getSprite());
		this.repaint();
	}
}
