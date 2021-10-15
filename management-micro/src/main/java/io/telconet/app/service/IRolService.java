package io.telconet.app.service;

import io.telconet.app.entity.Rol;
import io.telconet.app.model.Response;
import org.springframework.http.ResponseEntity;

/**
 * @author Brando Tomala
 * @version 1.0
 * @since 14/10/2021
 */
public interface IRolService {

    ResponseEntity<Response> listar();

    ResponseEntity<Response> guardar(Rol request);

    ResponseEntity<Response> eliminar(Long id);

    ResponseEntity<Response> editar(Long id, String rol);
}
