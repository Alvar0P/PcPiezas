package com.AlvaroyRaul.PcPiezas.servicies;

import com.AlvaroyRaul.PcPiezas.database.entity.carrito;
import com.AlvaroyRaul.PcPiezas.database.entity.producto;
import com.AlvaroyRaul.PcPiezas.database.entity.usuario;
import com.AlvaroyRaul.PcPiezas.database.repository.carritoRepo;
import com.AlvaroyRaul.PcPiezas.database.repository.productoRepo;
import com.AlvaroyRaul.PcPiezas.database.repository.usuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
public class servicioCarrito {
    @Autowired
    private productoRepo productRepo;
    @Autowired
    private carritoRepo carritRepo;
    @Autowired
    private usuarioRepo userRepo;

    public void saveCarritoToDB(){//La idea aquí es pillar el nombre del vendedor logeado y que se autorellen, de momento lo hacemos manualmente
        usuario u = new usuario();//Prueba
        u = userRepo.findById((long)2).get();


        carrito c = new carrito();
        c.setUsuario(u);
        List<producto> productos = new ArrayList<>();
        c.setProductos(productos);
        carritRepo.save(c);


        u.setCarrito(c);

        userRepo.save(u);

    }
    public void saveProductoEnCarrito(Long idProducto){

        producto p = new producto();
        p = productRepo.findById(idProducto).get();


        usuario u = new usuario();//Prueba
        u = userRepo.findById((long)2).get();

        carrito c = new carrito();
        c =u.getCarrito();

        if (c==null){
            saveCarritoToDB();
            c =u.getCarrito();
        }
        c.getProductos().add(p);
        c.setIdProducto(p);
        if(p.getCarritos().equals(null)){
            List<carrito> carr = new ArrayList<>();
            p.setCarritos(carr);
        }
        p.getCarritos().add(c);

        carritRepo.save(c);
        productRepo.save(p);
    }

    public List<producto> getAllProductInCarrito()
    {
        //Aquí luego habrá que buscar por usuario su carrito con la lista de productos
        carrito c= new carrito();//Prueba
        c = userRepo.findById((long)2).get().getCarrito();//Probamos con el carrito de juan
        return c.getProductos();
    }
    public void deleteCarritoById(long id) {//Borra el carrito

        carritRepo.deleteById(id);
    }
    public void deleteProductoInCarritoById(long idProducto){

        carrito c = new carrito();
        c = carritRepo.findById((long)7).get();//Prueba
        producto p = new producto();
        p = productRepo.findById(idProducto).get();
        c.getProductos().remove(p);
        carritRepo.save(c);


    }
}
