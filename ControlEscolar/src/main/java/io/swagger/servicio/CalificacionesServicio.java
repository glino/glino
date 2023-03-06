package io.swagger.servicio;

import io.swagger.modelo.Calificacion;
import io.swagger.modelo.CalificacionesConPromedio;

public interface CalificacionesServicio {

	public void altaCalificacion(Calificacion calificacion);

	public void bajaCalificacion(int id) throws Exception;

	public void cambioCalificacion(Calificacion calificacion) throws Exception;

	public CalificacionesConPromedio obtenerCalificaciones(int idAlumno);

}
