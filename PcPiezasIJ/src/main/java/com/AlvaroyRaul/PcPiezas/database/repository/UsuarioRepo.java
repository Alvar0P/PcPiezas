package com.AlvaroyRaul.PcPiezas.database.repository;
import com.AlvaroyRaul.PcPiezas.database.entity.Carrito;
import com.AlvaroyRaul.PcPiezas.database.entity.Usuario;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Collection;
import java.util.Optional;
@CacheConfig(cacheNames = "usuarios")
public interface UsuarioRepo extends JpaRepository<Usuario, Long> {
    @Cacheable
    public Usuario findByUsername(String username);
    @Cacheable
    public Usuario findByCarrito(Carrito carrito);
    @Cacheable
    Collection<Usuario> findByRol(String rol);
    @Cacheable
    Optional<Boolean> existsByRol(String rol);
    @Cacheable
    Optional<Usuario> findByIdUsuario(long IdUsuario);
    @CacheEvict
    void deleteByIdUsuario(long IdUsuario);
}
