package com.AlvaroyRaul.PcPiezas.database.repository;
import com.AlvaroyRaul.PcPiezas.database.entity.producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface productoRepo extends JpaRepository<producto, Long> {

}