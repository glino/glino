package io.swagger.repositorio;

import java.util.List;

import io.swagger.modelo.Calificacion;

public interface CalificacionesRepositorio {

	public void altaCalificacion (Calificacion calificacion);
	
	public void bajaCalificacion (int id);
	
	public void cambioCalificacion (Calificacion calificacion);
	
	public List<Calificacion> obtenerCalificacionesAlumno (int intIdAlumno);
	
	public List<Calificacion> obtenerCalificaciones (int intIdCalificacion);
}
