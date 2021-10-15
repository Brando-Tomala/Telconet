package io.telconet.app.service;

import io.telconet.app.entity.Rol;
import io.telconet.app.model.Response;
import io.telconet.app.repository.RolRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static org.springframework.http.HttpStatus.*;

/**
 * @author Brando Tomala
 * @version 1.0
 * @since 14/10/2021
 */
@Log4j2
@Service
public class RolServiceImpl implements IRolService {
    @Autowired
    RolRepository rolRepo;

    @Override
    public ResponseEntity<Response> listar() {
        Response response = new Response();
        try {
            response.setResponse(rolRepo.findAll());
            response.setCode(200);
            response.setMessage("Lista de roles");
            return ResponseEntity.status(CREATED).body(response);
        } catch (Exception e) {
            log.error(e.getMessage());
            response.setCode(400);
            response.setMessage(e.getMessage());
            return ResponseEntity.status(BAD_REQUEST).body(response);
        }
    }

    @Override
    public ResponseEntity<Response> guardar(Rol request) {
        Response response = new Response();
        try {
            rolRepo.save(request);
            response.setCode(200);
            response.setMessage("Registro de rol exitoso");
            return ResponseEntity.status(CREATED).body(response);
        } catch (Exception e) {
            log.error(e.getMessage());
            response.setCode(400);
            response.setMessage(e.getMessage());
            return ResponseEntity.status(BAD_REQUEST).body(response);
        }
    }

    @Override
    public ResponseEntity<Response> eliminar(Long id) {
        Response response = new Response();
        try {
            rolRepo.findById(id).ifPresentOrElse(usuario -> {
                rolRepo.delete(usuario);
                response.setCode(200);
                response.setMessage("Rol " + id + " eliminado con exito");
            }, () -> {
                log.info("Rol no existe");
                response.setCode(400);
                response.setMessage("Rol no existe");
            });
            return ResponseEntity.status(OK).body(response);
        } catch (Exception e) {
            log.error(e.getMessage());
            response.setCode(400);
            response.setMessage(e.getMessage());
            return ResponseEntity.status(BAD_REQUEST).body(response);
        }
    }

    @Override
    public ResponseEntity<Response> editar(Long id, String rol) {
        Response response = new Response();
        try {
            rolRepo.findById(id).ifPresentOrElse(usuario -> {
                rolRepo.updateRol(rol, id);
                response.setCode(200);
                response.setMessage("Rol " + id + " eliminado con exito");
            }, () -> {
                log.info("Rol no existe");
                response.setCode(400);
                response.setMessage("Rol no existe");
            });
            return ResponseEntity.status(OK).body(response);
        } catch (Exception e) {
            log.error(e.getMessage());
            response.setCode(400);
            response.setMessage(e.getMessage());
            return ResponseEntity.status(BAD_REQUEST).body(response);
        }
    }
}
