package com.AlvaroyRaul.PcPiezas.servicies;

import com.AlvaroyRaul.PcPiezas.database.entity.Producto;
import com.AlvaroyRaul.PcPiezas.database.entity.Usuario;
import com.AlvaroyRaul.PcPiezas.database.repository.UsuarioRepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


@Service
@Transactional
public class ServicioUsuario  {
    @Autowired
    private UsuarioRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;



    public void saveClientToDB(String username,String email,String password) {//La idea aquí es pillar el nombre del vendedor logeado y que se autorellen, de momento lo hacemos manualmente



        Usuario u = new Usuario();
        u.setUsername(username);
        u.setEmail(email);
        u.setPassword(passwordEncoder.encode(password));
        List<String> rol = new ArrayList<>();
        u.setDireccion("");
        u.setCuentaBancaria("");
        u.setRol("COMPRADOR");
        rol.add("COMPRADOR");
        u.setRoles(rol);

         userRepo.save(u);


    }
    public void saveVendedorToDB(String username,String email,String password, String dir, String cuentaBancaria, long tlf){
        Usuario u = new Usuario();
        u.setUsername(username);
        u.setEmail(email);
        u.setPassword(passwordEncoder.encode(password));
        List<String> rol = new ArrayList<>();
        u.setDireccion(dir);
        u.setCuentaBancaria(cuentaBancaria);
        u.setTlf(tlf);
        u.setRol("VENDEDOR");
        rol.add("VENDEDOR");
        u.setRoles(rol);

        userRepo.save(u);
    }
    public void guardarDatosAdicionales(HttpServletRequest request, String dir, long tarj, long tlf, boolean vip){

        Usuario u = userRepo.findByUsername(request.getUserPrincipal().getName());
        u.setDireccion(dir);
        u.setTarjeta(tarj);
        u.setTlf(tlf);
        u.setVIP(vip);
        userRepo.save(u);


    }

    public List<Usuario> getAllUsers()
    {
        return userRepo.findAll();
    }
    public void deleteUsuarioById(long id) {
        Usuario u = userRepo.findById(id).get();

        u.setCarrito(null);
        userRepo.save(u);

        userRepo.deleteById(id);
    }
    public Usuario getUserObject(String uName) {
        return userRepo.findByUsername(uName);
    }


}
