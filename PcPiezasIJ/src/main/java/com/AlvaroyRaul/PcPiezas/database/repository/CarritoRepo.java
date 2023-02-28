package com.AlvaroyRaul.PcPiezas.database.repository;

import com.AlvaroyRaul.PcPiezas.database.entity.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarritoRepo extends JpaRepository<Carrito,Long> {

    //public producto deleteProductoByIdInCarrito(long idProducto);



}
