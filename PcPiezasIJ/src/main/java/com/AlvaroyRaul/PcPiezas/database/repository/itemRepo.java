package com.AlvaroyRaul.PcPiezas.database.repository;

import com.AlvaroyRaul.PcPiezas.database.entity.item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface itemRepo extends JpaRepository<item,Long> {
}
