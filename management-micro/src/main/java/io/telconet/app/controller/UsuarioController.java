package io.telconet.app.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.telconet.app.entity.Usuario;
import io.telconet.app.model.Response;
import io.telconet.app.model.UsuarioEditReq;
import io.telconet.app.service.IUsuarioService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Brando Tomala
 * @version 1.0
 * @since 12/10/2021
 */
@Log4j2
@RestController
@CrossOrigin("*")
@RequestMapping("/user")
@Api(tags = "Interfaz para administrar los usuarios", produces = "application/json", consumes = "application/json")
public class UsuarioController {

    @Autowired
    IUsuarioService usuarioService;

    @ApiOperation("API para obetener todos los usuarios")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Lista de usuarios", response = Response.class),
            @ApiResponse(code = 400, message = "Error of Exception", response = Response.class),
    })
    @GetMapping
    public ResponseEntity<Response> getAll() {

        return usuarioService.listar();
    }

    @ApiOperation("API para registrar los usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Registro de usuario exitoso", response = Response.class),
            @ApiResponse(code = 400, message = "Error of Exception", response = Response.class),
    })
    @PostMapping
    public ResponseEntity<Response> register(@Valid @RequestBody Usuario request) {
        return usuarioService.guardar(request);
    }

    @ApiOperation("API para editar usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Actualizacion de usuario {id} exitoso", response = Response.class),
            @ApiResponse(code = 400, message = "Error of Exception", response = Response.class),
    })
    @PutMapping("/{id}")
    public ResponseEntity<Response> edit(@PathVariable("id") Long id, @Valid @RequestBody UsuarioEditReq request) {

        return usuarioService.editar(id, request);
    }

    @ApiOperation("API para eliminar usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuario {id} eliminado con exito", response = Response.class),
            @ApiResponse(code = 400, message = "Error of Exception", response = Response.class),
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable("id") Long id) {

        return usuarioService.eliminar(id);
    }

}
