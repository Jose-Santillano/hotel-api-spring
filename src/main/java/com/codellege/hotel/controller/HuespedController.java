package com.codellege.hotel.controller;

import com.codellege.hotel.model.Huesped;
import com.codellege.hotel.service.HuespedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/huespedes")
public class HuespedController {

    @Autowired
    private HuespedService serviceH;

    //GET
    @GetMapping
    public List<Huesped> listarTodo(){
        return serviceH.getAllHuespedes();
    }

    //POST
    @PostMapping
    public Huesped crear(@RequestBody Huesped huesped){

        return serviceH.createHuesped(huesped);
    }

    //PUT
    @PostMapping("editar/{id}")
    public Huesped actualizar(@RequestBody Huesped huesped, @PathVariable Long id){
        huesped.setIdHuesped(id);
        return serviceH.updateHuesped(huesped);
    }

    //DELETE
    @DeleteMapping("eliminar/{id}")
    public void eliminar(@PathVariable Long id){
        serviceH.deleteHuespedById(id);
    }
}

