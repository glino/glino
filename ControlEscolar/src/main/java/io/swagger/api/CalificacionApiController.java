package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.*;
import io.swagger.modelo.Calificacion;
import io.swagger.modelo.CalificacionesConPromedio;
import io.swagger.modelo.Respuesta;
import io.swagger.servicio.CalificacionesServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CalificacionApiController implements CalificacionApi {

//	private final ObjectMapper objectMapper;
//
//	private final HttpServletRequest request;

	@Autowired
	CalificacionesServicio calificacionesServicio;

	@org.springframework.beans.factory.annotation.Autowired
	public CalificacionApiController(ObjectMapper objectMapper, HttpServletRequest request) {
//		this.objectMapper = objectMapper;
//		this.request = request;
	}

	@CrossOrigin
	public ResponseEntity<Respuesta> altaCalificacion(
			@ApiParam(value = "", required = true) @RequestBody Calificacion calificacion) {
		try {
			calificacionesServicio.altaCalificacion(calificacion);

			Respuesta respuesta = new Respuesta("ok", "calificacion registrada");
			return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			Respuesta respuesta = new Respuesta("error", "error al registrar la calificacion");
			return new ResponseEntity<Respuesta>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin
	public ResponseEntity<Respuesta> bajaCalificacion(
			@ApiParam(value = "", required = true) @PathVariable("idCalificacion") Integer idCalificacion) {

		try {
			calificacionesServicio.bajaCalificacion(idCalificacion);
			Respuesta respuesta = new Respuesta("ok", "calificacion eliminada");
			return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			Respuesta respuesta = new Respuesta("error", "error al eliminar la calificacion");
			return new ResponseEntity<Respuesta>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@CrossOrigin
	public ResponseEntity<Respuesta> cambioCalificacion(
			@ApiParam(value = "", required = true) @RequestBody Calificacion calificacion) {
		try {
			calificacionesServicio.cambioCalificacion(calificacion);

			Respuesta respuesta = new Respuesta("ok", "calificacion actualizada");
			return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			Respuesta respuesta = new Respuesta("error", "error al actualizar la calificacion");
			return new ResponseEntity<Respuesta>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin
	public ResponseEntity<CalificacionesConPromedio> obtenerCalificacionesPorAlumno(
			@ApiParam(value = "", required = true) @PathVariable("idAlumno") Integer idAlumno) {
		try {
			CalificacionesConPromedio calificacionesConPromedio = calificacionesServicio
					.obtenerCalificaciones(idAlumno);
			return new ResponseEntity<CalificacionesConPromedio>(calificacionesConPromedio, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<CalificacionesConPromedio>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
