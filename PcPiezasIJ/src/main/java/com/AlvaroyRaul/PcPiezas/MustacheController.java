package com.AlvaroyRaul.PcPiezas;

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


        return "inicio";
    }
    @GetMapping("/ordenadores")
    public String pcs(Model model) {


        return "ordenadores";
    }
    @GetMapping("/componentes")
    public String componentes(Model model) {


        return "componentes";
    }
    @GetMapping("/moviles")
    public String moviles(Model model) {


        return "moviles";
    }
    @GetMapping("/perifericos")
    public String perifericos(Model model) {


        return "perifericos";
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

