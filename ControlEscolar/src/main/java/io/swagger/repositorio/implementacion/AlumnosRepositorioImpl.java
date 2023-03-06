package io.swagger.repositorio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import io.swagger.configuration.AlumnoRowMapper;
import io.swagger.modelo.Alumno;
import io.swagger.repositorio.AlumnosRepositorio;

@Repository
public class AlumnosRepositorioImpl implements AlumnosRepositorio {

	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;

	
	@Override
	public List<Alumno> obtenerAlumnos() {
		
		String strConsulta = "SELECT *  from t_alumnos AL ";

		List<Alumno> listAlumnos = jdbcTemplate.query(strConsulta,
				new AlumnoRowMapper());

		return listAlumnos;

	}


	

}
