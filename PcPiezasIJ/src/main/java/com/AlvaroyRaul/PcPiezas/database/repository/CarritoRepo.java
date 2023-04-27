package com.AlvaroyRaul.PcPiezas.database.repository;

import com.AlvaroyRaul.PcPiezas.database.entity.Carrito;
import com.AlvaroyRaul.PcPiezas.database.entity.Usuario;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.servlet.http.HttpServletRequest;


public interface CarritoRepo extends JpaRepository<Carrito,Long> {





}
