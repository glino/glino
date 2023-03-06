package io.swagger.api;

import io.swagger.annotations.*;
import io.swagger.modelo.Calificacion;
import io.swagger.modelo.CalificacionesConPromedio;
import io.swagger.modelo.Respuesta;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Api(value = "calificacion")
public interface CalificacionApi {

    @ApiOperation(value = "", nickname = "altaCalificacion", notes = "", response = Respuesta.class, tags={ "calificacion", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "OK", response = Respuesta.class) })
    @RequestMapping(value = "/calificacion",
        method = RequestMethod.POST)
    ResponseEntity<Respuesta> altaCalificacion(@ApiParam(value = "" ,required=true )   @RequestBody Calificacion calificacion);


    @ApiOperation(value = "", nickname = "bajaCalificacion", notes = "", response = Respuesta.class, tags={ "calificacion", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "OK", response = Respuesta.class) })
    @RequestMapping(value = "/calificacion/{idCalificacion}",
        method = RequestMethod.DELETE)
    ResponseEntity<Respuesta> bajaCalificacion(@ApiParam(value = "",required=true) @PathVariable("idCalificacion") Integer idCalificacion);


    @ApiOperation(value = "", nickname = "cambioCalificacion", notes = "", response = Respuesta.class, tags={ "calificacion", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "OK", response = Respuesta.class) })
    @RequestMapping(value = "/calificacion",
        method = RequestMethod.PUT)
    ResponseEntity<Respuesta> cambioCalificacion(@ApiParam(value = "" ,required=true ) @RequestBody Calificacion calificacion);

    
    @ApiOperation(value = "", nickname = "obtenerCalificacionesPorAlumno", notes = "", response = Calificacion.class, responseContainer = "List", tags={ "calificacion", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Calificacion.class, responseContainer = "List") })
    @RequestMapping(value = "/calificaciones/alumno/{idAlumno}",
        method = RequestMethod.GET)
    ResponseEntity<CalificacionesConPromedio> obtenerCalificacionesPorAlumno(@ApiParam(value = "",required=true) @PathVariable("idAlumno") Integer idAlumno);

}
