package com.codellege.hotel.service;

import com.codellege.hotel.model.Reserva;
import com.codellege.hotel.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;

    //Mostrar reserva
    public List<Reserva> getAllReservas(){
        return reservaRepository.findAll();
    }

    //Crear reserva
    public Reserva createReserva(Reserva reserva){
        return reservaRepository.save(reserva);
    }

    //Editar reserva
    public Reserva updateReserva(Reserva reserva){
        //La reserva ya viene con el idReserva insertada desde el controlador.
        return reservaRepository.save(reserva);
    }

    //Eliminar reserva
    public void deleteReservaById(Long id){
        reservaRepository.deleteById(id);
    }
}