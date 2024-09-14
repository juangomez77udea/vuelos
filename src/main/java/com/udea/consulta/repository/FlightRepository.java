package com.udea.consulta.repository;

import com.udea.consulta.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query("SELECT f FROM Flight f WHERE (:date IS NULL OR f.date = :date) " +
            "AND (:origin IS NULL OR f.origin = :origin) " +
            "AND (:price IS NULL OR f.price = :price)" +
            "AND (:destination IS NULL OR f.destination = :destination) " +
            "AND (:tipoEquipaje IS NULL OR f.tipoEquipaje = :tipoEquipaje) " +
            "AND (:tipoClase IS NULL OR f.tipoClase = :tipoClase) " +
            "AND (:numPasajeroMax IS NULL OR f.numPasajeroMax = :numPasajeroMax)")
    List<Flight> findFlightsByCriteria(
            @Param("date") LocalDate date,
            @Param("origin") String origin,
            @Param("price") Double price,
            @Param("destination") String destination,
            @Param("tipoEquipaje") String tipoEquipaje,
            @Param("tipoClase") String tipoClase,
            @Param("numPasajeroMax") Integer numPasajeroMax);
}