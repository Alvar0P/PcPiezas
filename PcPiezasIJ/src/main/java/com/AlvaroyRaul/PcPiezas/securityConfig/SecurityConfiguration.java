package com.AlvaroyRaul.PcPiezas.securityConfig;

import com.AlvaroyRaul.PcPiezas.servicies.RepositoryUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.SecureRandom;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    public RepositoryUserDetailsService userDetailService;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10, new SecureRandom());
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("resources/**", "static/**","templates/**","css/**", "js/**", "fonts/**","images/**","vendor/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {

        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());

    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.cors().and().csrf().disable();
        http.requiresChannel().anyRequest().requiresSecure();
        http.authorizeRequests().antMatchers("/inicio").permitAll();
        http.authorizeRequests().antMatchers("/perifericos").permitAll();
        http.authorizeRequests().antMatchers("/componentes").permitAll();
        http.authorizeRequests().antMatchers("/ordenadores").permitAll();
        http.authorizeRequests().antMatchers("/moviles").permitAll();
        http.authorizeRequests().antMatchers("/login").permitAll().and().formLogin();
        http.authorizeRequests().antMatchers("/register").permitAll();
        http.authorizeRequests().antMatchers("/registerVendedor").permitAll();
        http.authorizeRequests().antMatchers("/addU").permitAll();
        http.authorizeRequests().antMatchers("/addUV").permitAll();
        http.authorizeRequests().antMatchers("/admin/listaVentas").hasAnyAuthority("ROLE_ADMINISTRADOR", "ROLE_VENDEDOR","ROLE_COMPRADOR");
        http.authorizeRequests().antMatchers("/admin/usuarios/**").hasAuthority("ROLE_ADMINISTRADOR");
        http.authorizeRequests().antMatchers("/admin/**").hasAnyAuthority("ROLE_ADMINISTRADOR", "ROLE_VENDEDOR");
        http.authorizeRequests().antMatchers("/user/**").hasAuthority("ROLE_COMPRADOR");
        http.authorizeRequests().requestMatchers(request -> request.getServletPath().endsWith(".css") || request.getServletPath().endsWith(".js") || request.getServletPath().endsWith(".jpg") || request.getServletPath().endsWith(".png")|| request.getServletPath().endsWith(".html")).permitAll();


        //http.authorizeRequests().anyRequest().authenticated();

        //http.formLogin().loginPage("/login");
        http.formLogin().usernameParameter("username");
        http.formLogin().passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/inicio");


    }

}