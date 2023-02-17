package com.AlvaroyRaul.PcPiezas.Database.Repository;

import com.AlvaroyRaul.PcPiezas.Database.Entity.item;
import org.springframework.data.repository.CrudRepository;

public interface itemRepo extends CrudRepository<item,Long> {
}
