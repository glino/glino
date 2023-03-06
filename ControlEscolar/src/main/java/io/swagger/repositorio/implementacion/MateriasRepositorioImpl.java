package io.swagger.repositorio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import io.swagger.configuration.MateriaRowMapper;
import io.swagger.modelo.Materia;
import io.swagger.repositorio.MateriasRepositorio;

@Repository
public class MateriasRepositorioImpl implements MateriasRepositorio {

	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;

	
	@Override
	public List<Materia> obtenerMaterias() {
		
		String strConsulta = "SELECT *  from t_materias MAT ";

		List<Materia> listMaterias = jdbcTemplate.query(strConsulta,
				new MateriaRowMapper());

		return listMaterias;

	}

}
