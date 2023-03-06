package io.swagger.api;

import io.swagger.annotations.*;
import io.swagger.modelo.Alumno;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Api(value = "alumno")
public interface AlumnoApi {

   
    
    @ApiOperation(value = "", nickname = "obtenerAlumnos", notes = "", response = Alumno.class, responseContainer = "List", tags={ "alumnos", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Alumno.class, responseContainer = "List") })
    @RequestMapping(value = "/alumnos",
        method = RequestMethod.GET)
    ResponseEntity<List<Alumno>> obtenerCalificacionesPorAlumno();

}
