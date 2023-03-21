package com.AlvaroyRaul.PcPiezas.servicies;

import com.AlvaroyRaul.PcPiezas.database.entity.Producto;
import com.AlvaroyRaul.PcPiezas.database.entity.Usuario;
import com.AlvaroyRaul.PcPiezas.database.repository.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


@Component
public class ServicioUsuario {
    @Autowired
    private UsuarioRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;



    public void saveClientToDB(String nombre, String email, String password){//La idea aquí es pillar el nombre del vendedor logeado y que se autorellen, de momento lo hacemos manualmente

        Usuario u = new Usuario();
        u.setUsername(nombre);
        u.setEmail(email);
        u.setPassword(passwordEncoder.encode(password));
        List<String> rol = new ArrayList<>();
        rol.add("COMPRADOR");
        u.setRoles(rol);

        userRepo.save(u);


    }


}
