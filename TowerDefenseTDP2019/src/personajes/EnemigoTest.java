package personajes;

import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import entidades.Enemigo;
import entidades.Entidad;
import juego.Juego;
import visitor.Visitor;
import visitor.VisitorEnemigo;

public class EnemigoTest extends Enemigo {

	public EnemigoTest(int x, int y) {
		sprite = new JLabel();
		sprite.setIcon(new ImageIcon(this.getClass().getResource("/recursos/goblin.png")));
		this.x = x*128;
		this.y = y*128;
		sprite.setBounds(this.x, this.y, 128, 128);
		
		velocidad = 4;
		
		miVisitor = new VisitorEnemigo();
	}
	
	public void accion() {
		if ((x-velocidad)/128<x/128) {
			//Intento ir a la siguiente celda
			Iterator<Entidad> it = Juego.getJuego().getEntidad((x-velocidad)/128, y/128).iterator();
			Entidad e;
			boolean encontre = false;
			while (!encontre && it.hasNext()) {
				e = it.next();
				if (e.accept(miVisitor)) {
					encontre = true;
					//Atacar
				}
			}
			if (!encontre) {
				mover();
			}			
		}	
		else {
			mover();
		}
	}
	
	protected void mover() {
		if ((x-velocidad)/128<x/128) {
			//Cambio de celda
		}
		x-= velocidad;
		sprite.setBounds(x, y, 128, 128);
	}

	public void run() {
		try {
			while (true) {
				accion();
				Thread.sleep(100);
			}	
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
			
	}
	
	public boolean accept(Visitor v) {
		return v.visit(this);
	}
}
