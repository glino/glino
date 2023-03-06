package io.swagger.modelo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Calificacion  {

	@JsonProperty("id_calificacion")
	int id;
	@JsonProperty("id_alumno")
	int idAlumno;
	@JsonProperty("nombre")
	String nombreAlumno;
	@JsonProperty("apellido_Paterno")
	String apellidoPaternoAlumno;
	@JsonProperty("apellido_materno")
	String apellidoMaternoAlumno;
	@JsonProperty("id_materia")
	int idMateria;
	@JsonProperty("materia")
	String materia;
	@JsonProperty("calificacion")
	double calificacion;
	@JsonProperty("fecha_registro")
	Date fechaRegistro;

	public Calificacion() {
	}

	public Calificacion(int id, String nombreAlumno, String apellidoMaternoAlumno, String apellidoPaternoAlumno,
			String materia, double calificacion, Date fechaRegistro) {

		this.id = id;
		this.nombreAlumno = nombreAlumno;
		this.apellidoMaternoAlumno = apellidoMaternoAlumno;
		this.apellidoPaternoAlumno = apellidoPaternoAlumno;
		this.materia = materia;
		this.calificacion = calificacion;
		this.fechaRegistro = fechaRegistro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getNombreAlumno() {
		return nombreAlumno;
	}

	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}

	public String getApellidoMaternoAlumno() {
		return apellidoMaternoAlumno;
	}

	public void setApellidoMaternoAlumno(String apellidoMaternoAlumno) {
		this.apellidoMaternoAlumno = apellidoMaternoAlumno;
	}

	public String getApellidoPaternoAlumno() {
		return apellidoPaternoAlumno;
	}

	public void setApellidoPaternoAlumno(String apellidoPaternoAlumno) {
		this.apellidoPaternoAlumno = apellidoPaternoAlumno;
	}

	public int getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

}
