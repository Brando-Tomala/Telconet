package io.telconet.app;

import io.telconet.app.entity.Aplicacion;
import io.telconet.app.entity.Rol;
import io.telconet.app.entity.Usuario;
import io.telconet.app.repository.AplicacionRepository;
import io.telconet.app.repository.RolRepository;
import io.telconet.app.repository.UsuarioRepository;
import io.telconet.app.service.AplicacionServiceImpl;
import io.telconet.app.service.RolServiceImpl;
import io.telconet.app.service.UsuarioServiceImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ManagementMicroApplication {
    @Autowired
    RolRepository rolDAO;

    @Autowired
    UsuarioRepository userDAO;

    @Autowired
    AplicacionRepository appDAO;

    public static void main(String[] args) {
        SpringApplication.run(ManagementMicroApplication.class, args);
    }

    @Bean
    InitializingBean insertAdmin() {
        return () -> {
            List<Rol> roles = new ArrayList<>();
            rolDAO.saveAll(List.of(new Rol(null, "USER"), new Rol(null, "ADMIN"), new Rol(null, "SELLER")));
            Rol adminRol = rolDAO.findByRol("ADMIN");
            Rol userRol = rolDAO.findByRol("USER");
            Rol sellerRol = rolDAO.findByRol("SELLER");

            userDAO.saveAll(List.of(
                    new Usuario(null, "Jhon", "Ramos", "jramos@gmail.com", "0987456123",
                            "Guayaquil, Guayacanes", LocalDate.of(1999, Month.FEBRUARY, 20)
                            , "jramos", List.of(adminRol, userRol, sellerRol)),
                    new Usuario(null, "Wendy", "Corral", "wcorral@gmail.com", "0987455249",
                            "Guayaquil, Guasmo Norte", LocalDate.of(2000, Month.APRIL, 6)
                            , "wcorral", List.of(userRol)),
                    new Usuario(null, "Marcos", "Solis", "msolis@gmail.com", "0987453481",
                            "Guayaquil, Barrio Centenario", LocalDate.of(2001, Month.JULY, 15)
                            , "msolis", List.of(sellerRol))));
            appDAO.saveAll(List.of(
                    new Aplicacion(null, "Editar", List.of(adminRol, userRol)),
                    new Aplicacion(null, "Ventas", List.of(adminRol, sellerRol)),
                    new Aplicacion(null, "Productos", List.of(adminRol, userRol))
            ));


        };
    }


}
