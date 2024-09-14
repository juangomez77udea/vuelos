package com.udea.consulta.controller;

import com.udea.consulta.model.Flight;
import com.udea.consulta.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/flights")
@CrossOrigin(origins = "http://localhost:3000")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/search")
    public List<Flight> getFlights(
            @RequestParam(required = false) LocalDate date,
            @RequestParam(required = false) String origin,
            @RequestParam(required = false) Double price,
            @RequestParam(required = false) String destination,
            @RequestParam(required = false) String tipoEquipaje,
            @RequestParam(required = false) String tipoClase,
            @RequestParam(required = false) Integer numPasajeroMax) {
        return flightService.searchFlights(date, origin, price,destination, tipoEquipaje, tipoClase, numPasajeroMax);
    }
}