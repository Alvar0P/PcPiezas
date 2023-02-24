package com.AlvaroyRaul.PcPiezas.database.repository;
import com.AlvaroyRaul.PcPiezas.database.entity.rol;
import com.AlvaroyRaul.PcPiezas.database.entity.usuario;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Collection;
import java.util.Optional;

public interface usuarioRepo extends JpaRepository<usuario, Long> {
    public usuario findByUsername(String username);
    Collection<usuario> findByRol(rol rol);
    Optional<Boolean> existsByRol(rol rol);
}
