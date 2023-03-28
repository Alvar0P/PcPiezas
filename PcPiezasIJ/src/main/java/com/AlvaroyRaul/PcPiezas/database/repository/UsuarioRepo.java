package com.AlvaroyRaul.PcPiezas.database.repository;
import com.AlvaroyRaul.PcPiezas.database.entity.Carrito;
import com.AlvaroyRaul.PcPiezas.database.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Collection;
import java.util.Optional;

public interface UsuarioRepo extends JpaRepository<Usuario, Long> {
    public Usuario findByUsername(String username);
    public Usuario findByCarrito(Carrito carrito);
    Collection<Usuario> findByRol(String rol);
    Optional<Boolean> existsByRol(String rol);

    Optional<Usuario> findByIdUsuario(long IdUsuario);
    void deleteByIdUsuario(long IdUsuario);
}
