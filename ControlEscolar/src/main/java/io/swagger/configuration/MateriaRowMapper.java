package io.swagger.configuration;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import io.swagger.modelo.Materia;

public class MateriaRowMapper implements RowMapper<Materia> {

	@Override
	public Materia mapRow(ResultSet rs, int rowNum) throws SQLException {

		Materia materia = new Materia();

		materia.setId(rs.getInt("mat.id_t_materias"));
		materia.setNombre(rs.getString("mat.nombre"));

		return materia;
	}

}
