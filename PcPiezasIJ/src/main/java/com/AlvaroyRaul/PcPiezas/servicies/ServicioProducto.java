package com.AlvaroyRaul.PcPiezas.servicies;


import com.AlvaroyRaul.PcPiezas.database.entity.Carrito;
import com.AlvaroyRaul.PcPiezas.database.entity.Producto;
import com.AlvaroyRaul.PcPiezas.database.entity.Usuario;
import com.AlvaroyRaul.PcPiezas.database.repository.ProductoRepo;
import com.AlvaroyRaul.PcPiezas.database.repository.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;


@Service
public class ServicioProducto {
    @Autowired
    private ProductoRepo productRepo;
    @Autowired
    private UsuarioRepo userRepo;

    public void saveProductToDBDNoPicture(String nombre, String descripcion, String fabricant, Usuario vendedor, int precio){

        Producto p = new Producto();
        p.setNombre(nombre);
        p.setDescripcion(descripcion);
        p.setFabricante(fabricant);
        p.setVendedor(vendedor);
        p.setPrecio(precio);
        productRepo.save(p);

    }

    public void saveProductToDB(MultipartFile file,String nombre, String descripcion,String fabricant,String vendedor,String categoria,int precio){//La idea aquí es pillar el nombre del vendedor logeado y que se autorellen, de momento lo hacemos manualmente
        //Todo cambiar por "usuario vendedor" al final
        Producto p = new Producto();
        p.setNombre(nombre);
        p.setDescripcion(descripcion);
        p.setFabricante(fabricant);
        Usuario u = new Usuario();
        u = userRepo.findByUsername(vendedor);
        p.setVendedor(u);
        p.setPrecio(precio);
        p.setCategoria(categoria);

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        if(fileName.contains("..")){
            System.out.println("No es un archivo válido");
        }

        try {
            p.setImagen(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        productRepo.save(p);

    }
    public List<Producto> getAllProduct()
    {
        return productRepo.findAll();
    }
    public List<Producto> getProductoPorCategoria(String categoria)
    {
        return productRepo.findByCategoria(categoria);
    }
    public void deleteProductById(long id) {
        Producto p = productRepo.findById(id).get();

        p.setCarritos(null);
        productRepo.save(p);

        productRepo.deleteById(id);
    }
    public void changeProductName(long id ,String name)
    {
        Producto p = new Producto();
        p = productRepo.findById(id).get();
        p.setNombre(name);
        productRepo.save(p);
    }
    public void changeProductDescription(long id , String description)
    {
        Producto p = new Producto();
        p = productRepo.findById(id).get();
        p.setDescripcion(description);
        productRepo.save(p);
    }
    public void changeProductFabricante(long id, String fabricante){
        Producto p = new Producto();
        p= productRepo.findById(id).get();
        p.setFabricante(fabricante);
        productRepo.save(p);
    }
    public void changeProductPrice(long id,int price)
    {
        Producto p = new Producto();
        p = productRepo.findById(id).get();
        p.setPrecio(price);
        productRepo.save(p);
    }

    public void changeProductCategoria(long id, String categoria){
        Producto p = new Producto();
        p = productRepo.findById(id).get();
        p.setCategoria(categoria);
        productRepo.save(p);
    }


}
