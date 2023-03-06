package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.modelo.Materia;
import io.swagger.servicio.MateriasServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MateriaApiController implements MateriaApi {


	@Autowired
	MateriasServicio materiasServicio;

	@org.springframework.beans.factory.annotation.Autowired
	public MateriaApiController(ObjectMapper objectMapper, HttpServletRequest request) {

	}

	

	@CrossOrigin
	@Override
	public ResponseEntity<List<Materia>> obtenerCalificacionesPorMateria() {
		try {
			List<Materia> listMaterias = materiasServicio.obtenerMaterias();
			return new ResponseEntity<List<Materia>>(listMaterias, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Materia>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
