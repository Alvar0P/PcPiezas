package com.AlvaroyRaul.PcPiezas.database.repository;
import com.AlvaroyRaul.PcPiezas.database.entity.Rol;
import com.AlvaroyRaul.PcPiezas.database.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Collection;
import java.util.Optional;

public interface UsuarioRepo extends JpaRepository<Usuario, Long> {
    public Usuario findByUsername(String username);
    Collection<Usuario> findByRol(Rol rol);
    Optional<Boolean> existsByRol(Rol rol);
}
