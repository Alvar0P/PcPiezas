package com.AlvaroyRaul.PcPiezas.controllers;

import com.AlvaroyRaul.PcPiezas.database.entity.producto;
import com.AlvaroyRaul.PcPiezas.database.entity.rol;
import com.AlvaroyRaul.PcPiezas.database.entity.usuario;
import com.AlvaroyRaul.PcPiezas.database.repository.productoRepo;
import com.AlvaroyRaul.PcPiezas.database.repository.usuarioRepo;
import com.AlvaroyRaul.PcPiezas.servicioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;


@Controller
public class productosController {
    public class datosTabla {
        private List<FilasTabla> filasTabla;

        public datosTabla() {
            this.filasTabla = new ArrayList<>();
        }
        public void nuevaFila(FilasTabla fila) {
            filasTabla.add(fila);
        }

        public List<FilasTabla> getFilasTabla() {
            return filasTabla;
        }
    }

    public class FilasTabla  {
        private long idProducto;
        private String fabricante;
        private String Nombre;
        private String vendedor;
        private long valoracion;
        private float precio;

        public FilasTabla(long idProducto, String fabricante, String nombre, String vendedor, long valoracion, float precio) {
            this.idProducto = idProducto;
            this.fabricante = fabricante;
            Nombre = nombre;
            this.vendedor = vendedor;
            this.valoracion = valoracion;
            this.precio = precio;
        }

        public long getIdProducto() {
            return idProducto;
        }

        public String getFabricante() {
            return fabricante;
        }

        public String getNombre() {
            return Nombre;
        }

        public String getVendedor() {
            return vendedor;
        }

        public long getValoracion() {
            return valoracion;
        }

        public float getPrecio() {
            return precio;
        }
    }
    @Autowired
    private productoRepo productoRepo;
    @Autowired
    private usuarioRepo usuarioRepo;
    @Autowired
    private servicioProducto servicioProduct;
    @GetMapping("/productos")
    public String productos(Model model) {
        List<usuario> ListaVendedores = new ArrayList<>();
        List<String> listaVendedoresMostrada = new ArrayList<>();
        //Solo mostramos los usuarios con Rol administrador o vendedor
        ListaVendedores.addAll(usuarioRepo.findByRol(rol.VENDEDOR));
        ListaVendedores.addAll(usuarioRepo.findByRol(rol.ADMINISTRADOR));
        for(int i = 0; i < ListaVendedores.size(); i++) {
            listaVendedoresMostrada.add(ListaVendedores.get(i).getIdUsuario() + " --- " + ListaVendedores.get(i).getUsername());
        }
        model.addAttribute("vendedores", listaVendedoresMostrada);
        datosTabla datosProductos = new datosTabla();
        for(int i = 0; i < productoRepo.count(); i++) {
            producto temp = productoRepo.findAll().get(i);
            datosProductos.nuevaFila(new FilasTabla(temp.getIdProducto(), temp.getFabricante(), temp.getNombre(), temp.getvendedor().getUsername(), 0, temp.getPrecio()));
        }

        model.addAttribute("productos", datosProductos);
        return "productos_prueba";
    }
    @PostMapping("/addP")
    public RedirectView guardarProducto(/*@RequestParam("file") MultipartFile file,*/ @RequestParam("nombre") String nombre,
                                        /*@RequestParam("desc") String descripcion,*/ @RequestParam("fabricante") String fabricante,
                                        @RequestParam("precio") int precio,
                                        @RequestParam("vendedor") String vendedor) {
        vendedor = vendedor.replaceAll("\\D+","");
        long idVendedor = Long.parseLong(vendedor);
        System.out.println("Id vendedor: " + vendedor + "--" + idVendedor);
        if(usuarioRepo.existsById(idVendedor)) {
            usuario vendedorProducto = usuarioRepo.findById(idVendedor).get();
            //if(vendedorProducto.getRol().equals(rol.VENDEDOR) || vendedorProducto.getRol().equals(rol.ADMINISTRADOR))
            servicioProduct.saveProductToDBDNoPicture(nombre,"descripcion",fabricante,precio, vendedorProducto);

        }
        return new RedirectView("/productos");

}}
