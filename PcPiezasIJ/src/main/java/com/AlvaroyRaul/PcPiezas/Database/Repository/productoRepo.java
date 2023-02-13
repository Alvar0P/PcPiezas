package com.AlvaroyRaul.PcPiezas.Database.Repository;
import com.AlvaroyRaul.PcPiezas.Database.Entity.producto;
import org.springframework.data.repository.CrudRepository;
public interface productoRepo extends CrudRepository<producto, Long> {
}