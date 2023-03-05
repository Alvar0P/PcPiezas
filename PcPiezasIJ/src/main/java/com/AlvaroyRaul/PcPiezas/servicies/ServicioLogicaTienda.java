package com.AlvaroyRaul.PcPiezas.servicies;

import com.AlvaroyRaul.PcPiezas.database.entity.Item;
import com.AlvaroyRaul.PcPiezas.database.entity.Producto;
import com.AlvaroyRaul.PcPiezas.database.entity.Usuario;
import com.AlvaroyRaul.PcPiezas.database.entity.Venta;
import org.springframework.stereotype.Service;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Service
public class ServicioLogicaTienda {


    public void generaFactura(Venta venta) throws IOException {

        LocalDate hoy=venta.getFechaCompra();
        DateTimeFormatter formatoCorto = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fn = hoy.format(formatoCorto);

        String rutaFicheroFactura = "./Ventas/venta "+venta.getId()+"(" + fn.replace('/', '_') + ").txt";
        double importe =  venta.getTotal();
        try {
            //Si no existe el directorio Facturas, lo creamos
            File dirFacturas = new File("./Ventas");

            if (!dirFacturas.exists()) {
                dirFacturas.mkdir();
            }

            FileWriter fw = new FileWriter(rutaFicheroFactura);
            try (PrintWriter salida = new PrintWriter(new BufferedWriter(fw))) {
                salida.println("-------------------------------- Venta Producto --------------------------------");
                salida.println("\n");
                salida.println("-------------------------------- Fecha: " + fn + " -------------------------------");
                salida.println("\n");
                salida.println("\n");
                salida.println("Comprador: "+venta.getComprador().getUsername());
                for (Item i: venta.getListaItems()) {
                    salida.println("Nombre: " + i.getProducto().getNombre());
                    salida.println("Nserie: " + i.getnSerie());
                    salida.println("Vendedor: " + i.getProducto().getVendedor().getUsername());
                    salida.println("Precio: " + i.getProducto().getPrecio());
                    salida.println("\n");

                }

                salida.println("---------------------------------------------------------------------------------");
                salida.println("IMPORTE: " + venta.getTotal());
                salida.println("\n");
                salida.println("-------------------------------------------------------------------------------");
            }
        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        }
    }
}
