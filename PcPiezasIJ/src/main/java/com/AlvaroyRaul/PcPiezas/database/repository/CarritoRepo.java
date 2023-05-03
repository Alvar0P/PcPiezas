package com.AlvaroyRaul.PcPiezas.database.repository;

import com.AlvaroyRaul.PcPiezas.database.entity.Carrito;
import com.AlvaroyRaul.PcPiezas.database.entity.Producto;
import com.AlvaroyRaul.PcPiezas.database.entity.Usuario;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.servlet.http.HttpServletRequest;

@CacheConfig(cacheNames = "usuarios")
public interface CarritoRepo extends JpaRepository<Carrito,Long> {


    @CacheEvict
    Carrito save(Carrito carrito);
    @CacheEvict
    Carrito deleteById(long id);


}