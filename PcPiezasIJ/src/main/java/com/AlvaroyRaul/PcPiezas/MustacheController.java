package com.AlvaroyRaul.PcPiezas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MustacheController {


    @GetMapping("/login")
    public String login(Model model) {


        return "login";
    }

    @GetMapping("/inicio")
    public String inicio(Model model) {


        return "index";
    }
    @GetMapping("/pcs")
    public String pcs(Model model) {


        return "computers";
    }
    @GetMapping("/carrito")
    public String carrito(Model model) {


        return "shopping_cart";
    }
    @GetMapping("/contacto")
    public String contacto(Model model) {


        return "contact";
    }

}

