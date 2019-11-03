package juego;

import entidades.abstractas.Entidad;

/**
 * Clase que representa una división del mapa.
 * Cada celda puede contener una entidad.
 *
 */
public class Celda {
	
	protected Entidad entidad;
	
	/**
	 * Crea una celda vacía.
	 */
	public Celda() {
		entidad = null;
	}
	
	/**
	 * Retorna la entidad que está ocupando esta celda.
	 * @return La entidad ocupando esta celda
	 */
	public Entidad getEntidad() {
		return entidad;
	}

	/**
	 * Inserta una entidad en esta celda. Si la celda ya contenía una entidad, esta es reemplazada por la nueva entidad.
	 * @param e - Entidad que ocupará esta celda
	 */
	public void setEntidad(Entidad e) {
		entidad = e;		
	}
}	
