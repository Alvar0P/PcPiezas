package com.AlvaroyRaul.PcPiezas;
/*
@Controller
@RequestMapping(path="/usuarios") // This means URL's start with /demo (after Application path)
public class pruebaControladorUsuarios {
    @Autowired
    private usuarioRepo usuarioRepo;

    @PostMapping(path = "/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser(@RequestParam String name
            , @RequestParam String email, @RequestParam String password) {


        usuario n = new usuario(name,email, password);
        usuarioRepo.save(n);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<usuario> getAllUsers() {
        // This returns a JSON or XML with the users
        return usuarioRepo.findAll();
    }
}*/