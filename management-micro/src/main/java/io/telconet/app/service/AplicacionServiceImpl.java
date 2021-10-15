package io.telconet.app.service;

import io.telconet.app.entity.Aplicacion;
import io.telconet.app.entity.Rol;
import io.telconet.app.entity.Usuario;
import io.telconet.app.model.Response;
import io.telconet.app.repository.AplicacionRepository;
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
public class AplicacionServiceImpl implements IAplicacionService {
    @Autowired
    AplicacionRepository appRepo;

    @Override
    public ResponseEntity<Response> listar() {
        Response response = new Response();
        try {
            response.setResponse(appRepo.findAll());
            response.setCode(200);
            response.setMessage("Lista de aplicaciones");
            return ResponseEntity.status(OK).body(response);
        } catch (Exception e) {
            log.error(e.getMessage());
            response.setCode(400);
            response.setMessage(e.getMessage());
            return ResponseEntity.status(BAD_REQUEST).body(response);
        }
    }

    @Override
    public ResponseEntity<Response> guardar(Aplicacion request) {
        Response response = new Response();
        try {
            appRepo.save(request);
            response.setCode(200);
            response.setMessage("Registro de aplicacion exitoso");
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
            appRepo.findById(id).ifPresentOrElse(usuario -> {
                appRepo.delete(usuario);
                response.setCode(200);
                response.setMessage("Aplicacion " + id + " eliminada con exito");
            }, () -> {
                log.info("Aplicacion no existe");
                response.setCode(400);
                response.setMessage("Aplicacion no existe");
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
    public ResponseEntity<Response> editar(Long id, String aplicacion) {
        Response response = new Response();
        try {
            appRepo.findById(id).ifPresentOrElse(usuario -> {
                appRepo.updateAplicacion(aplicacion, id);
                response.setCode(200);
                response.setMessage("Aplicacion " + id + " actualizada con exito");
            }, () -> {
                log.info("Aplicacion no existe");
                response.setCode(400);
                response.setMessage("Aplicacion no existe");
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
