package com.AlvaroyRaul.PcPiezasMailService;

import com.AlvaroyRaul.PcPiezasMailService.email.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    EmailService email;
    @GetMapping("/inicio")
    public void inicio() {
        System.out.println("Hola");

        email.sendSimpleMessage("noxoxiv174@djpich.com", "hola", "hola");
        System.out.println("Hola");
    }
}

