package io.swagger.configuration;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import io.swagger.modelo.Calificacion;

public class CalificacionesRowMapper implements RowMapper<Calificacion> {

	@Override
	public Calificacion mapRow(ResultSet rs, int rowNum) throws SQLException {

		Calificacion calificacion = new Calificacion();
		calificacion.setId(rs.getInt("cal.id_t_calificaciones"));
		calificacion.setIdAlumno(rs.getInt("cal.id_t_alumnos"));
		calificacion.setIdMateria(rs.getInt("cal.id_t_materias"));
		calificacion.setCalificacion(rs.getDouble("cal.calificacion"));
		calificacion.setFechaRegistro(rs.getDate("cal.fecha_registro"));

		try {
			calificacion.setNombreAlumno(rs.getString("al.nombre"));
			calificacion.setApellidoPaternoAlumno(rs.getString("al.ap_materno"));
			calificacion.setApellidoMaternoAlumno(rs.getString("al.ap_paterno"));


			calificacion.setMateria(rs.getString("mat.nombre"));
		} catch (Exception e) {
			return calificacion;
		}

		return calificacion;
	}

}
