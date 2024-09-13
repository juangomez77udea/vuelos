package com.udea.consulta.service;

import com.udea.consulta.model.Reserva;
import com.udea.consulta.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    // Metodo para buscar reservas aplicando los filtros
    public List<Reserva> buscarReservas(String tipoEquipaje, String tipoClase, Integer numPasajeroMax) {
        return reservaRepository.findByFilters(tipoEquipaje, tipoClase, numPasajeroMax);
    }
}
