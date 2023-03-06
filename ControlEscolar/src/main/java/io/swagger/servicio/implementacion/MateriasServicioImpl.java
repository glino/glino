package io.swagger.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.swagger.modelo.Materia;
import io.swagger.repositorio.MateriasRepositorio;
import io.swagger.servicio.MateriasServicio;

@Service
public class MateriasServicioImpl implements MateriasServicio {

	@Autowired
	MateriasRepositorio materiasRepositorio;


	@Override
	public List<Materia> obtenerMaterias() {
		List<Materia> listMaterias = materiasRepositorio.obtenerMaterias();

		return listMaterias;
	}


}
