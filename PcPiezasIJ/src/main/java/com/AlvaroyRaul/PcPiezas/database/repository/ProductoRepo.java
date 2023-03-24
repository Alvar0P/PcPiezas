package com.AlvaroyRaul.PcPiezas.database.repository;
import com.AlvaroyRaul.PcPiezas.database.entity.Producto;
import com.AlvaroyRaul.PcPiezas.database.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



@Repository
@Transactional
public interface ProductoRepo extends JpaRepository<Producto, Long> {

    public List<Producto> findAll();
    public List<Producto> findByCategoria(String categoria);
    @Query("SELECT i FROM Producto i WHERE i.Vendedor = ?1")
    public List<Producto> findByVendedor(Usuario Venededor);


}