package com.AlvaroyRaul.PcPiezas.database.repository;

import com.AlvaroyRaul.PcPiezas.database.entity.Item;
import com.AlvaroyRaul.PcPiezas.database.entity.Producto;
import com.AlvaroyRaul.PcPiezas.database.entity.Venta;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


@CacheConfig(cacheNames = "items")
public interface ItemRepo extends JpaRepository<Item,String> {
    @Cacheable
    @Query("SELECT i FROM Item i WHERE i.Producto = ?1")
    List<Item> findByProducto(Producto Producto);
    @Cacheable
    List<Item> findByVenta(Venta venta);
}
