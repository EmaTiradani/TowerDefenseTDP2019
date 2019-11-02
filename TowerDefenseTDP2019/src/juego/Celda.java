package juego;

import entidades.abstractas.Entidad;

/**
 * Clase que representa una divisi�n del mapa.
 * Cada celda puede contener una entidad.
 *
 */
public class Celda {
	
	protected Entidad entidad;
	
	/**
	 * Crea una celda vac�a.
	 */
	public Celda() {
		entidad = null;
	}
	
	/**
	 * Retorna la entidad que est� ocupando esta celda.
	 * @return La entidad ocupando esta celda
	 */
	public Entidad getEntidad() {
		return entidad;
	}

	/**
	 * Inserta una entidad en esta celda. Si la celda ya conten�a una entidad, esta es reemplazada por la nueva entidad.
	 * @param e - Entidad que ocupar� esta celda
	 */
	public void setEntidad(Entidad e) {
		entidad = e;		
	}
}	
