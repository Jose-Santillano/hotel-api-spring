package com.codellege.hotel.service;

import com.codellege.hotel.model.Huesped;
import com.codellege.hotel.repository.HuespedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HuespedService {
    @Autowired
    private HuespedRepository huespedRepository;

    //Mostrar huespedes
    public List<Huesped> getAllHuespedes(){
        return huespedRepository.findAll();
    }

    //Crear huesped
    public Huesped createHuesped(Huesped huesped){
        return huespedRepository.save(huesped);
    }

    //Editar huesped
    public Huesped updateHuesped(Huesped huesped){
        //El huesped ya viene con el idHuesped insertado desde el controlador.
        return huespedRepository.save(huesped);
    }

    //Eliminar huesped
    public void deleteHuespedById(Long id){
        huespedRepository.deleteById(id);
    }
}
