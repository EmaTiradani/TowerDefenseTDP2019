package visitor;

import GUI.Gui;
import entidades.abstractas.Aliado;
import entidades.abstractas.Enemigo;
import entidades.abstractas.EnemigoDistancia;
import entidades.abstractas.ObjetoVida;

public class VisitorEnemigoDistancia extends Visitor {
	
	protected EnemigoDistancia enemigo;
	
	public VisitorEnemigoDistancia(EnemigoDistancia e) {
		enemigo = e;
	}

	public void visit(Aliado entidad) {
		int x = enemigo.getX();
		int targetX = entidad.getX();
		/*
		 * Si el enemigo tiene un alcance de n celdas, si la torre esta en la celda 0,
		 * en el instante que el enemigo entre a la celda n, empieza a dispara, pero desde el punto de vista del usuario,
		 * la distancia parece de n+1 celdas. 
		 * Con esta condicion de de que la distancia debe ser exactamente n celdas, previene que el enemigo se frene practicamente en la celda anterior
		 * Al alcance se le suma 0.1 para asegurar que empieza a disparar antes de que la distancia sea de exactamante n celdas, si el alcance tuviera que ser 
		 * estrictamente menor a las n celdas, existe la posibilidad de que el enemigo se pase de largo y termina en la siguiente celda, es decir la celda n-1.
		 */
		float alcance = enemigo.getAlcance() + 0.1f;
		float distancia = (float)Math.abs(x - targetX)/Gui.spriteSize;
		if (distancia <= alcance) {
			enemigo.atacar(entidad);
		}
	}

	public void visit(Enemigo entidad) {
	}

	public void visit(ObjetoVida entidad) {
		int x = enemigo.getX();
		int targetX = entidad.getX();
		float alcance = enemigo.getAlcance() + 0.1f;
		float distancia = (float)Math.abs(x - targetX)/Gui.spriteSize;
		if (distancia <= alcance) {
			enemigo.atacar(entidad);
		}
	}

}
