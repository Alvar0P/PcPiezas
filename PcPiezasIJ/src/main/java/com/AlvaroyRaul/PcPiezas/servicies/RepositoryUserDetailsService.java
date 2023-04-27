package com.AlvaroyRaul.PcPiezas.servicies;

import com.AlvaroyRaul.PcPiezas.database.entity.Usuario;
import com.AlvaroyRaul.PcPiezas.database.repository.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RepositoryUserDetailsService implements UserDetailsService {
    @Autowired
    private UsuarioRepo userRepository;
    @Override
    @Cacheable
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario user = userRepository.findByUsername(username);
        if(user==null){
           throw new UsernameNotFoundException("User not found");
        }
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ROLE_" + user.getRol()));

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), roles);
    }
}
