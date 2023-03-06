package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.modelo.Alumno;
import io.swagger.servicio.AlumnosServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AlumnoApiController implements AlumnoApi {


	@Autowired
	AlumnosServicio alumnosServicio;

	@org.springframework.beans.factory.annotation.Autowired
	public AlumnoApiController(ObjectMapper objectMapper, HttpServletRequest request) {

	}

	

	@CrossOrigin
	@Override
	public ResponseEntity<List<Alumno>> obtenerCalificacionesPorAlumno() {
		try {
			List<Alumno> listAlumnos = alumnosServicio.obtenerAlumnos();
			return new ResponseEntity<List<Alumno>>(listAlumnos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Alumno>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
