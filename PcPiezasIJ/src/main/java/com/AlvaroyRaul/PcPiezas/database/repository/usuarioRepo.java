package com.AlvaroyRaul.PcPiezas.database.repository;
import com.AlvaroyRaul.PcPiezas.database.entity.rol;
import com.AlvaroyRaul.PcPiezas.database.entity.usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Optional;

public interface usuarioRepo extends CrudRepository<usuario, Long> {
    Collection<usuario> findByRol(rol rol);
    Optional<Boolean> existsByRol(rol rol);
}
