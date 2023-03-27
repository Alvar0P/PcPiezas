package com.AlvaroyRaul.PcPiezas.servicies;

import com.AlvaroyRaul.PcPiezas.database.entity.Carrito;
import com.AlvaroyRaul.PcPiezas.database.entity.Producto;
import com.AlvaroyRaul.PcPiezas.database.entity.Usuario;
import com.AlvaroyRaul.PcPiezas.database.repository.CarritoRepo;
import com.AlvaroyRaul.PcPiezas.database.repository.ProductoRepo;
import com.AlvaroyRaul.PcPiezas.database.repository.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
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

    public void saveCarritoToDB(Usuario u){//La idea aquí es pillar el nombre del vendedor logeado y que se autorellen, de momento lo hacemos manualmente



        Carrito c = new Carrito();
        //c.setUsuario(u);
        List<Producto> productos = new ArrayList<>();
        c.setProductos(productos);
        carritRepo.save(c);


        u.setCarrito(c);

        userRepo.save(u);

    }
    public void saveProductoEnCarrito(Long idProducto, HttpServletRequest request){

        Producto p = new Producto();
        p = productRepo.findById(idProducto).get();


        Usuario u = new Usuario();//Prueba
        u = userRepo.findByUsername(request.getUserPrincipal().getName());

        Carrito c = new Carrito();
        c = u.getCarrito();

        if (c==null){
            saveCarritoToDB(u);
            c = u.getCarrito();
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

    public List<Producto> getAllProductInCarrito(Usuario u)
    {
        //Aquí luego habrá que buscar por usuario su carrito con la lista de productos
        Carrito c= new Carrito();//Prueba
        c = u.getCarrito();//Probamos con el carrito de juan
        return c.getProductos();
    }
    public void deleteCarritoByUsuario(Usuario u) {//Borra el carrito



        Carrito c = u.getCarrito();
        vaciarCarritoByUsuario(u);//Se pasaria el ID de usuario
        u.setCarrito(null);

        carritRepo.deleteById(c.getIdCarrito());
    }
    public void vaciarCarritoByUsuario(Usuario u){
        //Usuario  u = userRepo.findById((long)2).get();//Prueba
        List<Producto> productos = u.getCarrito().getProductos();

        for (Producto p:productos) {
            p.getCarritos().remove(u.getCarrito());
            productRepo.save(p);
        }

        u.getCarrito().getProductos().removeAll(productos);
        userRepo.save(u);
        carritRepo.save(u.getCarrito());


    }
    public void deleteProductoInCarritoById(long idProducto,HttpServletRequest request){
        Usuario u = new Usuario();
        u = userRepo.findByUsername(request.getUserPrincipal().getName());//Prueba
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
