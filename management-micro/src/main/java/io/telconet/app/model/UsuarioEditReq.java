package io.telconet.app.model;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Brando Tomala
 * @version 1.0
 * @since 13/10/2021
 */
@ApiModel(description = "Modelo Request para editar empleado")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEditReq {

    private String nombre;
    private String apellido;
    private String celular;
    private String direccionDomicilio;
    private List<String> roles;
}
