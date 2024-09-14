package com.udea.consulta.service;

import com.udea.consulta.model.Flight;
import com.udea.consulta.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> searchFlights(LocalDate date, String origin, Double price,String destination, String tipoEquipaje, String tipoClase, Integer numPasajeroMax) {
        return flightRepository.findFlightsByCriteria(date, origin, price,destination, tipoEquipaje, tipoClase, numPasajeroMax);
    }
}