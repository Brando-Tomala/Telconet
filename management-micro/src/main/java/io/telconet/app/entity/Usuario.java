package io.telconet.app.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Brando Tomala
 * @version 1.0
 * @since 12/10/2021
 */
@ApiModel(description = "Modelo Usuario")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class Usuario {

    @ApiModelProperty(hidden = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Email
    @Column(nullable = false, unique = true)
    private String correo;

    @Size(min = 10, max = 10)
    private String celular;
    private String direccionDomicilio;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;
    private String nombreUsuario;

    @ManyToMany(targetEntity = Rol.class)
    @ToString.Exclude
    private List<Rol> roles;

}
