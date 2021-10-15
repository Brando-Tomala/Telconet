package io.telconet.app.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Brando Tomala
 * @version 1.0
 * @since 12/10/2021
 */

@ApiModel(description = "Modelo Rol")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String rol;

    public Rol(String rol) {
        this.rol = rol;
    }
}
