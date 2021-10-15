package io.telconet.app.service;

import io.telconet.app.entity.Usuario;
import io.telconet.app.entity.Rol;
import io.telconet.app.model.Response;
import io.telconet.app.model.UsuarioEditReq;
import io.telconet.app.repository.UsuarioRepository;
import io.telconet.app.repository.RolRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

/**
 * @author Brando Tomala
 * @version 1.0
 * @since 12/10/2021
 */
@Service
@Log4j2
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    UsuarioRepository usuarioRepo;
    @Autowired
    RolRepository rolRepo;

    @Override
    public ResponseEntity<Response> listar() {
        Response response = new Response();
        try {
            response.setResponse(usuarioRepo.findAll());
            response.setCode(200);
            response.setMessage("Lista de empleado");

            return ResponseEntity.status(OK).body(response);
        } catch (Exception e) {
            log.error(e.getMessage());
            response.setCode(400);
            response.setMessage(e.getMessage());
            response.setResponse(null);
            return ResponseEntity.status(BAD_REQUEST).body(response);
        }
    }

    @Override
    public ResponseEntity<Response> guardar(Usuario request) {

        Response response = new Response();
        try {
            usuarioRepo.save(request);

            response.setCode(200);
            response.setMessage("Registro de usuario exitoso");
            return ResponseEntity.status(CREATED).body(response);
        } catch (Exception e) {
            log.error(e.getMessage());
            response.setCode(400);
            response.setMessage(e.getMessage());
            return ResponseEntity.status(BAD_REQUEST).body(response);
        }
    }

    @Override
    public ResponseEntity<Response> editar(Long id, UsuarioEditReq request) {
        Response response = new Response();
        try {

            usuarioRepo.updateUsuario(request.getNombre(), request.getApellido(),
                    request.getCelular(), request.getDireccionDomicilio(), id);
            response.setCode(200);
            response.setMessage("Actualizacion de usuario " + id + " exitoso");
            return ResponseEntity.status(OK).body(response);
        } catch (Exception e) {
            log.error(e.getMessage());
            response.setCode(400);
            response.setMessage(e.getMessage());
            response.setResponse(null);
            return ResponseEntity.status(BAD_REQUEST).body(response);
        }
    }

    @Override
    public ResponseEntity<Response> eliminar(Long id) {
        Response response = new Response();
        try {
            usuarioRepo.findById(id).ifPresentOrElse(usuario -> {
                usuarioRepo.delete(usuario);
                response.setCode(200);
                response.setMessage("Usuario " + id + " eliminado con exito");
            }, () -> {
                log.info("Usuario no existe");
                response.setCode(400);
                response.setMessage("Usuario no existe");
            });
            return ResponseEntity.status(OK).body(response);
        } catch (Exception e) {
            log.error(e.getMessage());
            response.setCode(400);
            response.setMessage(e.getMessage());
            response.setResponse(null);
            return ResponseEntity.status(BAD_REQUEST).body(response);
        }
    }
}
