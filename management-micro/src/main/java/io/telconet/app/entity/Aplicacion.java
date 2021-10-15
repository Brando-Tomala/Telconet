package io.telconet.app.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Brando Tomala
 * @version 1.0
 * @since 14/10/2021
 */
@ApiModel(description = "Modelo Aplicacion")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class Aplicacion {

    @ApiModelProperty(hidden = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotBlank
    private String aplicacion;

    @ManyToMany
    @ToString.Exclude
    private List<Rol> rol;

    public Aplicacion(String aplicacion) {
        this.aplicacion = aplicacion;
    }
}
