package GUI;

import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import entidades.Entidad;

public class Gui extends JFrame{
	private JLabel mapa;	
	
	public Gui() {		
		//Inicialización del frame
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.pack();
		Insets in = this.getInsets();
		this.setBounds(0,0,1280+in.left+in.right,768+in.top+in.bottom);
		this.setLayout(null);
		
		//Mapa
		mapa = new JLabel();
		mapa.setBounds(0,0, 1280, 768);
		mapa.setIcon(new ImageIcon(this.getClass().getResource("/recursos/game ground.jpg")));	
		this.getContentPane().add(mapa);
		this.repaint();
	}
	
	public void agregarEntidad(Entidad e) {
		mapa.add(e.getSprite());	
		this.repaint();
	}
}
