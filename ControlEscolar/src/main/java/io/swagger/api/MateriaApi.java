package io.swagger.api;

import io.swagger.annotations.*;
import io.swagger.modelo.Materia;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Api(value = "materia")
public interface MateriaApi {

   
    
    @ApiOperation(value = "", nickname = "obtenerMaterias", notes = "", response = Materia.class, responseContainer = "List", tags={ "materias", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Materia.class, responseContainer = "List") })
    @RequestMapping(value = "/materias",
        method = RequestMethod.GET)
    ResponseEntity<List<Materia>> obtenerCalificacionesPorMateria();

}
