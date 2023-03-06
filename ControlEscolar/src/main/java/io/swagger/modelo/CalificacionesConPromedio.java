package io.swagger.modelo;

import java.util.List;

public class CalificacionesConPromedio {

	List<Calificacion> calificaciones;
	double promedio;
	
	public CalificacionesConPromedio() {		
	}
	
	public CalificacionesConPromedio(List<Calificacion> calificaciones, double promedio) {
		this.calificaciones = calificaciones;
		this.promedio = promedio;
	}

	public List<Calificacion> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(List<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
	}

	public double getPromedio() {
		return promedio;
	}

	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}
	
	
	
}
