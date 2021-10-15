package io.telconet.app.service;

import io.telconet.app.entity.Usuario;
import io.telconet.app.model.Response;
import io.telconet.app.model.UsuarioEditReq;
import org.springframework.http.ResponseEntity;

/**
 * @author Brando Tomala
 * @version 1.0
 * @since 12/10/2021
 */
public interface IUsuarioService {

    ResponseEntity<Response> listar();

    ResponseEntity<Response> guardar(Usuario request);

    ResponseEntity<Response> editar(Long id, UsuarioEditReq request);

    ResponseEntity<Response> eliminar(Long id);
}
