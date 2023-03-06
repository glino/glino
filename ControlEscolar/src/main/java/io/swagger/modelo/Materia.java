package io.swagger.modelo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Materia  {


	@JsonProperty("id_materia")
	int id;
	@JsonProperty("nombre")
	String nombre;


	public Materia() {
	}
	public Materia(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
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


	

}
