package com.AlvaroyRaul.PcPiezas.database.repository;
import com.AlvaroyRaul.PcPiezas.database.entity.Producto;
import com.AlvaroyRaul.PcPiezas.database.entity.Usuario;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@CacheConfig(cacheNames = "productos")
@Repository
@Transactional
public interface ProductoRepo extends JpaRepository<Producto, Long> {

    @Cacheable
    public List<Producto> findAll();
    @Cacheable
    public List<Producto> findByCategoria(String categoria);
    @Cacheable
    @Query("SELECT i FROM Producto i WHERE i.Vendedor = ?1")
    public List<Producto> findByVendedor(Usuario Venededor);


}