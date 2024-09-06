package com.udea.consulta.repository;

import com.udea.consulta.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    // Metodo para buscar vuelos entre dos fechas, con origen y destino espcíficos

    List<Flight>
    findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCase
            (
                    LocalDate startDate, LocalDate endDate, String origin, String destination
            );

    // Metodo para buscar vuelos entre dos fechas, con origen específico y precio máximo
    List<Flight>
    findByDateBetweenAndOriginContainingIgnoreCaseAndPriceLessThanEqual
    (
            LocalDate startDate, LocalDate endDate, String origin, double maxPrice
    );

    // Metodo para buscar vuelos entre dos fechas, con destino específico y precio máximo
    List<Flight>
    findByDateBetweenAndDestinationContainingIgnoreCaseAndPriceLessThanEqual
    (
            LocalDate startDate, LocalDate endDate, String destination, double maxPrice
    );

    // Otros métodos necesarios para soportar las combinaciones de filtros
    List<Flight> findByDateBetween(LocalDate startDate, LocalDate endDate);

    List<Flight> findByDateBetweenAndOriginContainingIgnoreCase(LocalDate startDate, LocalDate endDate, String origin);

    List<Flight> findByDateBetweenAndDestinationContainingIgnoreCase(LocalDate startDate, LocalDate endDate, String destination);

    List<Flight> findByDateBetweenAndPriceLessThanEqual(LocalDate startDate, LocalDate endDate, double maxPrice);

    List<Flight>
    findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceLessThanEqual
            (
                    LocalDate startDate, LocalDate endDate, String origin, String destination, double maxPrice
            );
}
