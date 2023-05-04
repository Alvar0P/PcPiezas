package com.AlvaroyRaul.PcPiezas.servicies;


import com.AlvaroyRaul.PcPiezas.database.entity.Usuario;
import com.AlvaroyRaul.PcPiezas.database.repository.UsuarioRepo;
import com.AlvaroyRaul.PcPiezas.database.repository.VentaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
@CacheConfig(cacheNames = "usuarios")
public class ServicioUsuario  {
    @Autowired
    private UsuarioRepo userRepo;
    @Autowired
    private VentaRepo vRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @CacheEvict(allEntries = true)
    public void saveClientToDB(String username,String email,String password) {//La idea aquÃ­ es pillar el nombre del vendedor logeado y que se autorellen, de momento lo hacemos manualmente



        Usuario u = new Usuario();
        u.setUsername(username);
        u.setEmail(email);
        u.setPassword(passwordEncoder.encode(password));
        List<String> rol = new ArrayList<>();
        u.setDireccion("");
        u.setCuentaBancaria("");
        u.setVenta("");
        u.setRol("COMPRADOR");
        rol.add("COMPRADOR");
        u.setRoles(rol);

        userRepo.save(u);


    }
    @CacheEvict(allEntries = true)
    public void saveVendedorToDB(String username,String email,String password, String dir, String cuentaBancaria, long tlf){
        Usuario u = new Usuario();
        u.setUsername(username);
        u.setEmail(email);
        u.setPassword(passwordEncoder.encode(password));
        List<String> rol = new ArrayList<>();
        u.setDireccion(dir);
        u.setCuentaBancaria(cuentaBancaria);
        u.setTlf(tlf);
        u.setVenta("");
        u.setRol("VENDEDOR");
        rol.add("VENDEDOR");
        u.setRoles(rol);

        userRepo.save(u);
    }
    @CacheEvict(allEntries = true)
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
    @CacheEvict(allEntries = true)
    public void deleteUsuarioById(long id) {
        Usuario u = userRepo.findByIdUsuario(id).get();

        u.setCarrito(null);
        vRepo.deleteByComprador(u);

        userRepo.deleteByIdUsuario(id);
    }
    public Usuario getUserObject(String uName) {
        return userRepo.findByUsername(uName);
    }


}