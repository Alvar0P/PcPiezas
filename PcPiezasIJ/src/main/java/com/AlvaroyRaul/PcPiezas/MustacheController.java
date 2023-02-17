package com.AlvaroyRaul.PcPiezas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MustacheController {


    @GetMapping("/basic")
    public String basic(Model model) {


        return "login";
    }



}

