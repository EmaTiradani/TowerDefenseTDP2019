package juego;

import java.util.Collection;
import java.util.LinkedList;

import entidades.Entidad;

public class Celda {
	
	protected Collection<Entidad> entidades;
	
	public Celda() {
		entidades = new LinkedList<Entidad>();
	}
	
	public Iterable<Entidad> getEntidad() {
		return entidades;
	}

	public void setEntidad(Entidad e) {
		entidades.add(e);		
	}
}	
