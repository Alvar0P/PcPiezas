package com.AlvaroyRaul.PcPiezas.database.repository;

import com.AlvaroyRaul.PcPiezas.database.entity.Usuario;
import com.AlvaroyRaul.PcPiezas.database.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepo extends JpaRepository<Venta,Long> {

    void deleteByComprador(Usuario comprador);
}
