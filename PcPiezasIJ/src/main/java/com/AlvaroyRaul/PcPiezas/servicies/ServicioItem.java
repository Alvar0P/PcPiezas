package com.AlvaroyRaul.PcPiezas.servicies;

import com.AlvaroyRaul.PcPiezas.database.entity.Item;
import com.AlvaroyRaul.PcPiezas.database.entity.Producto;
import com.AlvaroyRaul.PcPiezas.database.entity.Usuario;
import com.AlvaroyRaul.PcPiezas.database.repository.ItemRepo;

import com.AlvaroyRaul.PcPiezas.database.repository.ProductoRepo;
import com.AlvaroyRaul.PcPiezas.database.repository.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioItem {
    @Autowired
    private ItemRepo iRepo;
    @Autowired
    private ProductoRepo pRepo;
    @Autowired
    private UsuarioRepo userRepo;

    public void addItemToDB(String nSerie, long idProducto){
        Producto productoItem = pRepo.findById(idProducto).get();
        Item item = new Item(nSerie, productoItem);

    }


    public List<Item> getAllItems()
    {
        return iRepo.findAll();
    }
    public List<Item> getItemsSellers(Usuario u){

        List<Item> listItems = getAllItemsInStock();
        List<Item> listaItems = new ArrayList<>();

        for (Item i:listItems) {
            Usuario user = i.getProducto().getVendedor();

            if (user == u){
                listaItems.add(i);
            }

        }
        return listaItems;


    }
    public List<Item> getAllItemsInStock()
    {
        return iRepo.findByVenta(null);
    }
    public List<Item> getAllItemsForProduct(long idProducto)
    {
        Producto productoItem = pRepo.findById(idProducto).get();

        return iRepo.findByProducto(productoItem).stream().toList();

    }

    public List<Item> getAllItemsInStockForProduct(long idProducto)
    {
        Producto productoItem = pRepo.findById(idProducto).get();

        return iRepo.findByProducto(productoItem).stream().filter(i -> i.getVenta() == null).toList();

    }

    public long getItemCountForProduct(long idProducto)
    {
        Producto productoItem = pRepo.findById(idProducto).get();

        return iRepo.findByProducto(productoItem).stream().count();

    }
    public void deleteItemBynSerie(String nSerie) {iRepo.findById(nSerie);}
}
