package com.AlvaroyRaul.PcPiezas.servicies;

import com.AlvaroyRaul.PcPiezas.database.entity.Item;
import com.AlvaroyRaul.PcPiezas.database.entity.Producto;
import com.AlvaroyRaul.PcPiezas.database.entity.Usuario;
import com.AlvaroyRaul.PcPiezas.database.entity.Venta;
import com.AlvaroyRaul.PcPiezas.database.repository.ItemRepo;
import com.AlvaroyRaul.PcPiezas.database.repository.VentaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
@Service
public class ServicioVenta {
    @Autowired
    private VentaRepo ventaRepo;

    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;
    public Venta nuevaVenta(List<Item> items, Usuario user){
        Venta v = new Venta();
        v.setComprador(user);
        v.setListaItems(items);
        float total = 0;
        for (Item i:items) {
           total+= i.getProducto().getPrecio();
           i.setVenta(v);
        }
        v.setTotal(total);
        LocalDate hoy = LocalDate.now();
        v.setFechaCompra(hoy);
        ventaRepo.save(v);
        //Usamos un microservicio para mandar los datos de la venta al cliente
        kafkaTemplate.send(topicVenta, v);

        return v;

    }

    public List<Item> getProductosForVenta(Venta venta) {
        List<Item> productosComprados = itemRepo.findByVenta(venta).stream().toList();
        return productosComprados;
    }

    public List<Venta> getAllVentas() {
        return ventaRepo.findAll();
    }
}
