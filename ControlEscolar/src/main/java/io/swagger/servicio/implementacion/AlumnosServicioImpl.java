package io.swagger.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.swagger.modelo.Alumno;
import io.swagger.repositorio.AlumnosRepositorio;
import io.swagger.servicio.AlumnosServicio;

@Service
public class AlumnosServicioImpl implements AlumnosServicio {

	@Autowired
	AlumnosRepositorio alumnosRepositorio;


	@Override
	public List<Alumno> obtenerAlumnos() {
		List<Alumno> listAlumnos = alumnosRepositorio.obtenerAlumnos();

		return listAlumnos;
	}


}
