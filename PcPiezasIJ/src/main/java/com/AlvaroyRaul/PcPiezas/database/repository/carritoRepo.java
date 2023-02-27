package com.AlvaroyRaul.PcPiezas.database.repository;

import com.AlvaroyRaul.PcPiezas.database.entity.carrito;
import com.AlvaroyRaul.PcPiezas.database.entity.producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface carritoRepo extends JpaRepository<carrito,Long> {

    //public producto deleteProductoByIdInCarrito(long idProducto);



}
