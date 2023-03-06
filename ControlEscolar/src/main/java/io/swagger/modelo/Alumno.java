package io.swagger.modelo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Alumno  {


	@JsonProperty("id_alumno")
	int id;
	@JsonProperty("nombre")
	String nombre;
	@JsonProperty("apellido_paterno")
	String apellidoPaterno;
	@JsonProperty("apellido_materno")
	String apellidoMaterno;
	public Alumno() {
	}
	public Alumno(int id, String nombre, String apellidoPaterno, String apellidoMaterno) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	

}
