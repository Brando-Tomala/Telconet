package io.telconet.app.repository;

import io.telconet.app.entity.Aplicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AplicacionRepository extends JpaRepository<Aplicacion, Long> {

    @Modifying
    @Query("UPDATE Aplicacion app SET app.aplicacion=?1 WHERE app.id=?2")
    void updateAplicacion(String aplicacion, Long id);
}