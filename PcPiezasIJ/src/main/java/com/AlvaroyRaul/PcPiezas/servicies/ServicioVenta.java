package com.AlvaroyRaul.PcPiezas.servicies;

import com.AlvaroyRaul.PcPiezas.database.entity.Item;
import com.AlvaroyRaul.PcPiezas.database.entity.Producto;
import com.AlvaroyRaul.PcPiezas.database.entity.Usuario;
import com.AlvaroyRaul.PcPiezas.database.entity.Venta;
import com.AlvaroyRaul.PcPiezas.database.repository.VentaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Service
public class ServicioVenta {
    @Autowired
    private VentaRepo ventaRepo;
    public Venta nuevaVenta(List<Item> items, Usuario user){
        Venta v = new Venta();
        v.setComprador(user);
        v.setListaItems(items);
        float total = 0;
        for (Item i:items) {
           total+= i.getProducto().getPrecio();
        }
        v.setTotal(total);
        LocalDate hoy = LocalDate.now();
        v.setFechaCompra(hoy);
        ventaRepo.save(v);

        return v;

    }
}
