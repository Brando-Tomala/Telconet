package io.telconet.app.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.telconet.app.entity.Aplicacion;
import io.telconet.app.entity.Usuario;
import io.telconet.app.model.Response;
import io.telconet.app.service.IAplicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Brando Tomala
 * @version 1.0
 * @since 14/10/2021
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/app")
@Api(tags = "Interfaz para administrar las aplicaciones", produces = "application/json", consumes = "application/json")
public class AplicacionController {

    @Autowired
    IAplicacionService aplicacionService;

    @ApiOperation("API para obetener todos las aplicaciones")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Lista de aplicaciones", response = Response.class),
            @ApiResponse(code = 400, message = "Error of Exception", response = Response.class),
    })
    @GetMapping
    public ResponseEntity<Response> getAll() {

        return aplicacionService.listar();
    }

    @ApiOperation("API para registrar las aplicaciones")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Registro de aplicacion exitoso", response = Response.class),
            @ApiResponse(code = 400, message = "Error of Exception", response = Response.class),
    })
    @PostMapping
    public ResponseEntity<Response> register(@Valid @RequestBody Aplicacion request) {
        return aplicacionService.guardar(request);
    }

    @ApiOperation("API para editar aplicacion")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Actualizacion de aplicacion {id} exitoso", response = Response.class),
            @ApiResponse(code = 400, message = "Error of Exception", response = Response.class),
    })
    @PutMapping("/{id}")
    public ResponseEntity<Response> edit(@PathVariable("id") Long id, @RequestParam String aplicacion) {

        return aplicacionService.editar(id, aplicacion);
    }

    @ApiOperation("API para eliminar aplicaciones")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Aplicacion {id} eliminado con exito", response = Response.class),
            @ApiResponse(code = 400, message = "Error of Exception", response = Response.class),
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable("id") Long id) {

        return aplicacionService.eliminar(id);
    }
}
