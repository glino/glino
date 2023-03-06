package io.swagger.repositorio.implementacion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import io.swagger.configuration.CalificacionesRowMapper;
import io.swagger.modelo.Calificacion;
import io.swagger.repositorio.CalificacionesRepositorio;

@Repository
public class CalificacionesRepositorioImpl implements CalificacionesRepositorio {

	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public void altaCalificacion(Calificacion calificacion) {
		String sql = "INSERT into t_calificaciones (id_t_materias, id_t_alumnos, " + "calificacion, fecha_registro) "
				+ "VALUES (:idMateria,:idAlumno,:calificacion,:fechaRegistro);";

		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("idMateria", calificacion.getIdMateria());
		parametros.put("idAlumno", calificacion.getIdAlumno());
		parametros.put("calificacion", calificacion.getCalificacion());
		parametros.put("fechaRegistro", calificacion.getFechaRegistro());

		jdbcTemplate.update(sql, parametros);

	}

	@Override
	public void bajaCalificacion(int id) {
		String sql = "DELETE FROM t_calificaciones WHERE id_t_calificaciones = :idCalificacion;";

		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("idCalificacion", id);

		jdbcTemplate.update(sql, parametros);

	}

	@Override
	public void cambioCalificacion(Calificacion calificacion) {
		String sql = "UPDATE t_calificaciones SET id_t_materias = :idMateria, id_t_alumnos= :idAlumno,"
				+ " calificacion=:calificacion, fecha_registro = :fechaRegistro "
				+ " WHERE id_t_calificaciones = :idCalificacion;";

		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("idCalificacion", calificacion.getId());
		parametros.put("idMateria", calificacion.getIdMateria());
		parametros.put("idAlumno", calificacion.getIdAlumno());
		parametros.put("calificacion", calificacion.getCalificacion());
		parametros.put("fechaRegistro", calificacion.getFechaRegistro());

		jdbcTemplate.update(sql, parametros);

	}

	@Override
	public List<Calificacion> obtenerCalificacionesAlumno(int idAlumno) {
		HashMap<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("idAlumno", idAlumno);

		String strConsulta = "SELECT * " + " from t_calificaciones CAL "
				+ " INNER JOIN t_alumnos AL ON CAL.id_t_alumnos = AL.id_t_alumnos"
				+ " INNER JOIN t_materias MAT ON CAL.id_t_materias = MAT.id_t_materias"
				+ " WHERE CAL.id_t_alumnos = :idAlumno;";

		List<Calificacion> calificaciones = jdbcTemplate.query(strConsulta, parametros, new CalificacionesRowMapper());

		return calificaciones;

	}

	@Override
	public List<Calificacion> obtenerCalificaciones(int intIdCalificacion) {
		HashMap<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("idCalificacion", intIdCalificacion);

		String strConsulta = "SELECT *  from t_calificaciones CAL "
				+ " WHERE CAL.id_t_calificaciones = :idCalificacion;";

		List<Calificacion> listCalificaciones = jdbcTemplate.query(strConsulta, parametros,
				new CalificacionesRowMapper());

		return listCalificaciones;

	}

}
