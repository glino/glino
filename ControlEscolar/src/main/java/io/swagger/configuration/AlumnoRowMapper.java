package io.swagger.configuration;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import io.swagger.modelo.Alumno;

public class AlumnoRowMapper implements RowMapper<Alumno> {

	@Override
	public Alumno mapRow(ResultSet rs, int rowNum) throws SQLException {

		Alumno alumno = new Alumno();

		alumno.setId(rs.getInt("al.id_t_alumnos"));
		alumno.setNombre(rs.getString("al.nombre"));
		alumno.setApellidoPaterno(rs.getString("al.ap_materno"));
		alumno.setApellidoMaterno(rs.getString("al.ap_paterno"));


		return alumno;
	}

}
