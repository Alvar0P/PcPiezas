package com.AlvaroyRaul.PcPiezas.database.repository;
import com.AlvaroyRaul.PcPiezas.database.entity.Producto;
import com.AlvaroyRaul.PcPiezas.database.entity.Usuario;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



@Repository
@Transactional
@CacheConfig(cacheNames = "usuarios")
public interface ProductoRepo extends JpaRepository<Producto, Long> {

    @Cacheable
    List<Producto> findAll();
    @Cacheable
     List<Producto> findByCategoria(String categoria);
    @Cacheable
    @Query("SELECT i FROM Producto i WHERE i.Vendedor = ?1")
     List<Producto> findByVendedor(Usuario Venededor);

    @CacheEvict
    Producto save(Producto producto);
    @CacheEvict
    Producto deleteById(long id);

}