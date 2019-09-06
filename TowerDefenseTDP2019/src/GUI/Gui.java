package GUI;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import entidades.Entidad;
import personajes.AliadoTest;
import personajes.EnemigoTest;

public class Gui extends JFrame{
	private JLabel l;
	public static void main(String[]args) {
		Gui g = new Gui();
		g.setVisible(true);
		
	}
	public Gui() {
		this.setBounds(0,0,1300,64*12+30);
		l = new JLabel();
		this.setLayout(null);
		l.setBounds(0,0, 640*2, 64*6*2);
		l.setIcon(new ImageIcon("C:\\Users\\default.LAPTOP-9ASHTB0Q\\Documents\\GitHub\\TowerDefenseTDP2019\\TowerDefenseTDP2019\\src\\GUI\\aseeseseeeeee.jpg"));
	
		this.getContentPane().add(l);	
		
		Entidad e = new AliadoTest(9, 5);
		l.add(e.getSprite());
		
		e = new EnemigoTest(0, 3);
		l.add(e.getSprite());

	}
}
