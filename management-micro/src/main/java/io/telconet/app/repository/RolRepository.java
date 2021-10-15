package io.telconet.app.repository;

import io.telconet.app.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RolRepository extends JpaRepository<Rol, Long> {

    Rol findByRol(String rol);

    @Modifying
    @Query("UPDATE Rol rol SET rol.rol=?1 WHERE rol.id=?2")
    void updateRol(String rol, Long id);
}