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
    public List<Flight> findFlights(LocalDate startDate, LocalDate endDate, String origin  , String destination, Double maxPrice) {
        //Generar una clave de una combinacion de parametros para usar en el switch
        String key = (origin != null ? "1" : "0") +
                (destination != null ? "1" : "0") +
                (maxPrice != null ? "1" : "0" );

        return switch (key) {
            case "111" -> // origin, destination, maxPrice no son nulos
                    flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceLessThanEqual
                            (
                                    startDate, endDate, origin, destination, maxPrice
                            );
            case "110" -> // origin, destination no son nulos, maxPrice es nulo
                    flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCase(
                            startDate, endDate, origin, destination);
            case "101" -> // origin y maxPrice no son nulos, destination es nulo
                    flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndPriceLessThanEqual(
                            startDate, endDate, origin, maxPrice);
            case "011" -> // destination y maxPrice no son nulos, origin es nulo
                    flightRepository.findByDateBetweenAndDestinationContainingIgnoreCaseAndPriceLessThanEqual(
                            startDate, endDate, destination, maxPrice);
            case "100" -> // solo origin no es nulo
                    flightRepository.findByDateBetweenAndOriginContainingIgnoreCase(startDate,
                            endDate, origin);
            case "010" -> // solo destination no es nulo
                    flightRepository.findByDateBetweenAndDestinationContainingIgnoreCase(startDate, endDate,
                            destination);
            case "001" -> // solo maxPrice no es nulo
                    flightRepository.findByDateBetweenAndPriceLessThanEqual(startDate, endDate,
                            maxPrice); // todos son nulos
            default -> flightRepository.findByDateBetween(startDate, endDate);
        };
    }
}
