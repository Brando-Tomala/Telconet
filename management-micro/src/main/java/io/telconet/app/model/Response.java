package io.telconet.app.model;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Brando Tomala
 * @version 1.0
 * @since 12/10/2021
 */
@ApiModel(description = "Modelo generico de respuesta", value = "Response")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private Integer code;
    private String message;
    private Object response;
}
