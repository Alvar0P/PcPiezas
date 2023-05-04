package com.AlvaroyRaul.PcPiezas.database.repository;

import com.AlvaroyRaul.PcPiezas.database.entity.Carrito;
import com.AlvaroyRaul.PcPiezas.database.entity.Producto;
import com.AlvaroyRaul.PcPiezas.database.entity.Usuario;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;

@CacheConfig(cacheNames = "usuarios")
@Repository
public interface CarritoRepo extends JpaRepository<Carrito,Long> {


    @CacheEvict (allEntries = true)
    Carrito save(Carrito carrito);
    @CacheEvict (allEntries = true)
    Carrito deleteById(long id);


}