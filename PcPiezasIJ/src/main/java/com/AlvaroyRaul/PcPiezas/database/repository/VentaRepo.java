package com.AlvaroyRaul.PcPiezas.database.repository;

import com.AlvaroyRaul.PcPiezas.database.entity.Usuario;
import com.AlvaroyRaul.PcPiezas.database.entity.Venta;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

@CacheConfig(cacheNames = "productos")

public interface VentaRepo extends JpaRepository<Venta,Long> {

    @CacheEvict(allEntries = true)
    Venta save(Venta venta);
    @CacheEvict(allEntries = true)
    void deleteByComprador(Usuario comprador);
}
