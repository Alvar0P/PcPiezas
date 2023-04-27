package com.AlvaroyRaul.PcPiezas.database.repository;

import com.AlvaroyRaul.PcPiezas.database.entity.Usuario;
import com.AlvaroyRaul.PcPiezas.database.entity.Venta;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

@CacheConfig(cacheNames = "ventas")
public interface VentaRepo extends JpaRepository<Venta,Long> {
    @CacheEvict
    void deleteByComprador(Usuario comprador);
}
