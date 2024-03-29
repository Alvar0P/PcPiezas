package com.AlvaroyRaul.PcPiezas.servicies;

import com.AlvaroyRaul.PcPiezas.database.entity.Item;
import com.AlvaroyRaul.PcPiezas.database.entity.Usuario;
import com.AlvaroyRaul.PcPiezas.database.entity.Venta;
import com.AlvaroyRaul.PcPiezas.database.repository.ItemRepo;
import com.AlvaroyRaul.PcPiezas.database.repository.VentaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service

public class ServicioVenta {
    @Autowired
    private VentaRepo ventaRepo;

    @Autowired
    private ItemRepo itemRepo;


    /*
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;
    @Value(value = "${kafka.topic.name}")
    private String topic;*/
    public Venta nuevaVenta(List<Item> items, Usuario user){
        Venta v = new Venta();
        v.setComprador(user);
        v.setListaItems(items);
        float total = 0;
        for (Item i:items) {
           total+= i.getProducto().getPrecio();
           i.setVenta(v);
        }
        v.setDirEnvio(user.getDireccion());
        v.setTotal(total);
        LocalDate hoy = LocalDate.now();
        v.setFechaCompra(hoy);
        ventaRepo.save(v);

        return v;

    }
    public List<Item> getProductosForVenta(Venta venta) {
        List<Item> productosComprados = itemRepo.findByVenta(venta).stream().toList();
        return productosComprados;
    }
    public List<Venta> getAllVentas() {
        return ventaRepo.findAll();
    }
    public List<Venta> getVentasForBuyers(Usuario u){

        List<Venta> listaVTemp = ventaRepo.findAll();
        List<Venta> listaVenta = new ArrayList<>();

        for (Venta venta : listaVTemp) {
            if (venta.getComprador().equals(u)){
                listaVenta.add(venta);
            }

        }

        return listaVenta;
    }
    public List<Venta> getVentasForSellers(Usuario u){

        List<Venta> listaVTemp = ventaRepo.findAll();
        List<Venta> listaVenta = new ArrayList<>();


        for (Venta venta : listaVTemp) {
            List<Item> listaI = venta.getListaItems();
            for (Item item:listaI) {
                if (item.getProducto().getVendedor().equals(u)){
                    listaVenta.add(venta);
                }
            }


        }

        return listaVenta;
    }
}
