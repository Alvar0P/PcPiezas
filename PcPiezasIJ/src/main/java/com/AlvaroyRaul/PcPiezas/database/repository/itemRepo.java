package com.AlvaroyRaul.PcPiezas.database.repository;

import com.AlvaroyRaul.PcPiezas.database.entity.item;
import com.AlvaroyRaul.PcPiezas.database.entity.producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface itemRepo extends JpaRepository<item,String> {
   @Query("SELECT i FROM item i WHERE i.Producto = ?1")
   List<item> findByProducto(producto Producto);
}
