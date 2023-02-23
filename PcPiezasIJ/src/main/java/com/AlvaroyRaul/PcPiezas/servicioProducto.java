package com.AlvaroyRaul.PcPiezas;


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




@Service
public class servicioProducto {
    @Autowired
    private productoRepo repo;
    private usuarioRepo urepo;

    public void saveProductToDBDNoPicture(String nombre, String descripcion,String fabricant,int precio, usuario vendedor){

        producto p = new producto(nombre,descripcion,fabricant, vendedor,precio);
        repo.save(p);

    }

    public void saveProductToDB(MultipartFile file,String nombre, String descripcion,String fabricant,int precio, usuario vendedor){

        producto p = new producto(nombre,descripcion,fabricant, vendedor,precio);


        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        if(fileName.contains("..")){
            System.out.println("No es un archivo válido");
        }

        try {
            p.setImagen(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        repo.save(p);

    }


}
