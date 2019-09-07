package GUI;

import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import entidades.Entidad;
import personajes.AliadoTest;
import personajes.EnemigoTest;

public class Gui extends JFrame{
	private JLabel mapa;
	
	public static void main(String[]args) {
		Gui g = new Gui();
		g.setVisible(true);
		
	}
	public Gui() {
		//Inicialización del frame
		this.pack();
		Insets in = this.getInsets();
		this.setBounds(0,0,1280+in.left+in.right,768+in.top+in.bottom);
		this.setLayout(null);
		
		//Mapa
		mapa = new JLabel();
		mapa.setBounds(0,0, 1280, 768);
		mapa.setIcon(new ImageIcon(this.getClass().getResource("/recursos/aseeseseeeeee.jpg")));	
		this.getContentPane().add(mapa);	
		
		//Aliado y Enemigo de prueba
		Entidad e = new AliadoTest(9, 5);
		mapa.add(e.getSprite());		
		e = new EnemigoTest(0, 3);
		mapa.add(e.getSprite());
	}
}
