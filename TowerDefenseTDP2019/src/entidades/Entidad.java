package entidades;

import javax.swing.JLabel;

public abstract class Entidad {
	
	protected JLabel sprite;
	protected int x;
	protected int y;
	
	public JLabel getSprite() {
		return sprite;
	}
}