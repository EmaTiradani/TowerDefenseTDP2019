package personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.Gui;
import entidades.DisparoAliado;
import state.Estado;

public class DisparoBasico extends DisparoAliado {

	public DisparoBasico(int x, int y, int alcance, Estado estado) {
		super(x, y, 5, 15, alcance, estado);
	}



}
