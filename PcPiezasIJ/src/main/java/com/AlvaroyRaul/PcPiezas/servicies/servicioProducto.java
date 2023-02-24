package com.AlvaroyRaul.PcPiezas.servicies;


import com.AlvaroyRaul.PcPiezas.database.entity.rol;
import com.AlvaroyRaul.PcPiezas.database.entity.producto;
import com.AlvaroyRaul.PcPiezas.database.entity.usuario;
import com.AlvaroyRaul.PcPiezas.database.repository.productoRepo;
import com.AlvaroyRaul.PcPiezas.database.repository.usuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;
import java.io.IOException;
import java.util.Base64;
import java.util.List;


@Service
public class servicioProducto {
    @Autowired
    private productoRepo productRepo;
    @Autowired
    private usuarioRepo userRepo;

    public void saveProductToDBDNoPicture(String nombre, String descripcion,String fabricant,usuario vendedor,int precio){

        producto p = new producto();
        p.setNombre(nombre);
        p.setDescripcion(descripcion);
        p.setFabricante(fabricant);
        p.setVendedor(vendedor);
        p.setPrecio(precio);
        productRepo.save(p);

    }

    public void saveProductToDB(MultipartFile file,String nombre, String descripcion,String fabricant,String vendedor,int precio){//La idea aquí es pillar el nombre del vendedor logeado y que se autorellen, de momento lo hacemos manualmente
        //Todo cambiar por "usuario vendedor" al final
        producto p = new producto();
        p.setNombre(nombre);
        p.setDescripcion(descripcion);
        p.setFabricante(fabricant);
        usuario u = new usuario();
        u = userRepo.findByUsername(vendedor);
        p.setVendedor(u);
        p.setPrecio(precio);

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
    public List<producto> getAllProduct()
    {
        return productRepo.findAll();
    }
    public void deleteProductById(long id) {
        productRepo.deleteById(id);
    }
    public void changeProductName(long id ,String name)
    {
        producto p = new producto();
        p = productRepo.findById(id).get();
        p.setNombre(name);
        productRepo.save(p);
    }
    public void changeProductDescription(long id , String description)
    {
        producto p = new producto();
        p = productRepo.findById(id).get();
        p.setDescripcion(description);
        productRepo.save(p);
    }
    public void changeProductFabricante(long id, String fabricante){
        producto p = new producto();
        p= productRepo.findById(id).get();
        p.setFabricante(fabricante);
        productRepo.save(p);
    }
    public void changeProductPrice(long id,int price)
    {
        producto p = new producto();
        p = productRepo.findById(id).get();
        p.setPrecio(price);
        productRepo.save(p);
    }


}
