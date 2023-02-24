package com.AlvaroyRaul.PcPiezas.database.repository;

import com.AlvaroyRaul.PcPiezas.database.entity.venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ventaRepo extends JpaRepository<venta,Long> {
}
