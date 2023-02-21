package com.AlvaroyRaul.PcPiezas.database.repository;
import com.AlvaroyRaul.PcPiezas.database.entity.producto;
import org.springframework.data.repository.CrudRepository;
public interface productoRepo extends CrudRepository<producto, Long> {
}