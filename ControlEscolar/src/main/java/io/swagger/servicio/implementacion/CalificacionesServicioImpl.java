package io.swagger.servicio.implementacion;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.swagger.modelo.Calificacion;
import io.swagger.modelo.CalificacionesConPromedio;
import io.swagger.repositorio.CalificacionesRepositorio;
import io.swagger.servicio.CalificacionesServicio;

@Service
public class CalificacionesServicioImpl implements CalificacionesServicio {

	@Autowired
	CalificacionesRepositorio calificacionesRepositorio;

	@Override
	public void altaCalificacion(Calificacion calificacion) {
		calificacion.setFechaRegistro(Date.from(Instant.now()) );  
		calificacionesRepositorio.altaCalificacion(calificacion);

	}

	@Override
	public void bajaCalificacion(int id) throws Exception {

		Calificacion calificacion = new Calificacion();
		calificacion.setId(id);
		validarExistenciaCalificacion(calificacion);

		calificacionesRepositorio.bajaCalificacion(id);

	}

	@Override
	public void cambioCalificacion(Calificacion calificacion) throws Exception {

		validarExistenciaCalificacion(calificacion);
		calificacion.setFechaRegistro(Date.from(Instant.now()));  
		calificacionesRepositorio.cambioCalificacion(calificacion);

	}

	@Override
	public CalificacionesConPromedio obtenerCalificaciones(int idAlumno) {

		CalificacionesConPromedio calificacionesConPromedio = new CalificacionesConPromedio();
		List<Calificacion> listCalificacion = calificacionesRepositorio.obtenerCalificacionesAlumno(idAlumno);
		calificacionesConPromedio.setCalificaciones(listCalificacion);
		calificacionesConPromedio.setPromedio(obtenerPromedio(listCalificacion));
		return calificacionesConPromedio;
	}

	private double obtenerPromedio(List<Calificacion> listCalificacion) {
		double promedio = 0;

		for (Calificacion calificacion : listCalificacion) {
			promedio += calificacion.getCalificacion();
		}
		promedio = promedio / listCalificacion.size();
		return promedio;
	}

	private void validarExistenciaCalificacion(Calificacion calificacion) throws Exception {
		List<Calificacion> listCalificacion = calificacionesRepositorio.obtenerCalificaciones(calificacion.getId());
		if (listCalificacion.size() < 1) {
			throw new Exception("calificación no existente");
		}
	}
}
