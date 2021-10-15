package io.telconet.app.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.telconet.app.entity.Rol;
import io.telconet.app.model.Response;
import io.telconet.app.service.IRolService;
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
@RequestMapping("/role")
@Api(tags = "Interfaz para administrar los roles", produces = "application/json", consumes = "application/json")
public class RolController {
    @Autowired
    IRolService rolService;

    @ApiOperation("API para obetener todos los roles")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Lista de roles", response = Response.class),
            @ApiResponse(code = 400, message = "Error of Exception", response = Response.class),
    })
    @GetMapping
    public ResponseEntity<Response> getAll() {
        return rolService.listar();
    }

    @ApiOperation("API para registrar un rol")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Registro de rol exitoso", response = Response.class),
            @ApiResponse(code = 400, message = "Error of Exception", response = Response.class),
    })
    @PostMapping
    public ResponseEntity<Response> register(@Valid @RequestBody Rol request) {
        return rolService.guardar(request);
    }

    @ApiOperation("API para editar rol")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Actualizacion de rol {id} exitoso", response = Response.class),
            @ApiResponse(code = 400, message = "Error of Exception", response = Response.class),
    })
    @PutMapping("/{id}")
    public ResponseEntity<Response> edit(@PathVariable("id") Long id, @RequestParam String rol) {
        return rolService.editar(id, rol);
    }


    @ApiOperation("API para eliminar rol")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Rol {id} eliminado con exito", response = Response.class),
            @ApiResponse(code = 400, message = "Error of Exception", response = Response.class),
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable("id") Long id) {
        return rolService.eliminar(id);
    }
}
