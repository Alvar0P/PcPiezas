package com.AlvaroyRaul.PcPiezas.servicies;

import com.AlvaroyRaul.PcPiezas.database.entity.item;
import com.AlvaroyRaul.PcPiezas.database.entity.producto;
import com.AlvaroyRaul.PcPiezas.database.entity.usuario;
import com.AlvaroyRaul.PcPiezas.database.repository.itemRepo;

import com.AlvaroyRaul.PcPiezas.database.repository.productoRepo;
import com.AlvaroyRaul.PcPiezas.database.repository.usuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
public class servicioItem {
    @Autowired
    private itemRepo iRepo;
    @Autowired
    private productoRepo pRepo;
    @Autowired
    private usuarioRepo userRepo;

    public void addItemToDB(String nSerie, long idProducto){
        producto productoItem = pRepo.findById(idProducto).get();
        item item = new item(nSerie, productoItem);

    }


    public List<item> getAllItems()
    {
        return iRepo.findAll();
    }
    public List<item> getAllItemsForProduct(long idProducto)
    {
        producto productoItem = pRepo.findById(idProducto).get();

        //return iRepo.findByIdproducto(productoItem).stream().toList();
        return null;
    }
    public void deleteItemBynSerie(String nSerie) {iRepo.findById(nSerie);}
}
