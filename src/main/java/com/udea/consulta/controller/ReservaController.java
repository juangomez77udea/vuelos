package com.udea.consulta.controller;

import com.udea.consulta.model.Reserva;
import com.udea.consulta.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reserva")
@CrossOrigin(origins = "http://localhost:3000")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    // Endpoint para buscar reservas aplicando filtros
    @GetMapping("/search")
    public List<Reserva> searchReserva(
            @RequestParam(required = false) String tipoEquipaje, 
            @RequestParam(required = false) String tipoClase,
            @RequestParam(required = false) Integer numPasajeroMax) {

        // Llamada al servicio con los parámetros recibidos
        return reservaService.buscarReservas(tipoEquipaje, tipoClase, numPasajeroMax);
    }
}
