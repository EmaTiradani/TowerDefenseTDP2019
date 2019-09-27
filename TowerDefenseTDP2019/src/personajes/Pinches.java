package personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.Enemigo;
import entidades.Entidad;
import entidades.ObjetoTemporal;
import juego.Juego;
import visitor.VisitorPinche;

public class Pinches extends ObjetoTemporal {

	protected float da�o;
	protected float cooldownAtaque;
	protected float cooldownActual;

	public Pinches(int x, int y) {
		super(x, y, 20);
		
		da�o = 5;
		cooldownAtaque = 0.5f;
		cooldownActual = 0;
		
		sprite = new JLabel();
		sprite.setIcon(new ImageIcon(this.getClass().getResource("/recursos/bicho enemigo.jpg")));
		sprite.setBounds(this.x, this.y, Gui.spriteSize, Gui.spriteSize);
		
		setVisitor();
	}
	
	protected void setVisitor() {
		miVisitor = new VisitorPinche(this);
	}
	
	public void accion(float estimatedTime) {
		super.accion(estimatedTime);
		cooldownActual -= estimatedTime;
		
		Entidad e = Juego.getJuego().getEntidad(x/Gui.spriteSize, y/Gui.spriteSize);
		if (e!=null) {
			e.accept(miVisitor);
		}
	}

	public void atacar(Enemigo entidad) {
		if (cooldownActual<=0) {
			entidad.recibirDa�o(da�o);		
			cooldownActual = cooldownAtaque;			
		}
	}

}
