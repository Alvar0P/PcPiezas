package com.AlvaroyRaul.PcPiezas.servicies;

import com.AlvaroyRaul.PcPiezas.database.entity.Carrito;
import com.AlvaroyRaul.PcPiezas.database.entity.Producto;
import com.AlvaroyRaul.PcPiezas.database.entity.Usuario;
import com.AlvaroyRaul.PcPiezas.database.repository.CarritoRepo;
import com.AlvaroyRaul.PcPiezas.database.repository.ProductoRepo;
import com.AlvaroyRaul.PcPiezas.database.repository.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
public class ServicioCarrito {
    @Autowired
    private ProductoRepo productRepo;
    @Autowired
    private CarritoRepo carritRepo;
    @Autowired
    private UsuarioRepo userRepo;

    public void saveCarritoToDB(){//La idea aquí es pillar el nombre del vendedor logeado y que se autorellen, de momento lo hacemos manualmente
        Usuario u = new Usuario();//Prueba
        u = userRepo.findById((long)2).get();


        Carrito c = new Carrito();
        c.setUsuario(u);
        List<Producto> productos = new ArrayList<>();
        c.setProductos(productos);
        carritRepo.save(c);


        u.setCarrito(c);

        userRepo.save(u);

    }
    public void saveProductoEnCarrito(Long idProducto){

        Producto p = new Producto();
        p = productRepo.findById(idProducto).get();


        Usuario u = new Usuario();//Prueba
        u = userRepo.findById((long)2).get();

        Carrito c = new Carrito();
        c =u.getCarrito();

        if (c==null){
            saveCarritoToDB();
            c =u.getCarrito();
        }
        c.getProductos().add(p);

        if(p.getCarritos().equals(null)){
            List<Carrito> carr = new ArrayList<>();
            p.setCarritos(carr);
        }
        p.getCarritos().add(c);

        carritRepo.save(c);
        productRepo.save(p);
    }

    public List<Producto> getAllProductInCarrito()
    {
        //Aquí luego habrá que buscar por usuario su carrito con la lista de productos
        Carrito c= new Carrito();//Prueba
        c = userRepo.findById((long)2).get().getCarrito();//Probamos con el carrito de juan
        return c.getProductos();
    }
    public void deleteCarritoById(long id) {//Borra el carrito

        carritRepo.deleteById(id);
    }
    public void deleteProductoInCarritoById(long idProducto){
        Usuario u = new Usuario();
        u = userRepo.findById((long)2).get();//Prueba
        Carrito c = new Carrito();
        c = u.getCarrito();
        Producto p = new Producto();
        p = productRepo.findById(idProducto).get();
        p.getCarritos().remove(c);
        c.getProductos().remove(p);
        u.getCarrito().getProductos().remove(p);
        userRepo.save(u);
        productRepo.save(p);
        carritRepo.save(c);


    }
}
