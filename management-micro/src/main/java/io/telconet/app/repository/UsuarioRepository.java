package io.telconet.app.repository;

import io.telconet.app.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Modifying
    @Query("UPDATE Usuario em SET em.nombre=?1, em.apellido=?2, em.celular=?3, em.direccionDomicilio=?4 WHERE em.id=?5")
    void updateUsuario( String nombre, String apellido, String celular, String direccionDomicilio, Long id);


}