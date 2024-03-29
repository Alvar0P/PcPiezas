package com.AlvaroyRaul.PcPiezas.database.repository;
import com.AlvaroyRaul.PcPiezas.database.entity.Carrito;
import com.AlvaroyRaul.PcPiezas.database.entity.Usuario;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Collection;
import java.util.List;
import java.util.Optional;
public interface UsuarioRepo extends JpaRepository<Usuario, Long> {

    Usuario findByUsername(String username);
    //@Cacheable
    List<Usuario> findAll();

    //@Cacheable
    Usuario findByCarrito(Carrito carrito);
    //@Cacheable
    Collection<Usuario> findByRol(String rol);
    //@Cacheable
    Optional<Boolean> existsByRol(String rol);
    //@Cacheable
    Optional<Usuario> findByIdUsuario(long IdUsuario);
    //@CacheEvict
    void deleteByIdUsuario(long IdUsuario);
    Usuario save(Usuario usuario);
}
