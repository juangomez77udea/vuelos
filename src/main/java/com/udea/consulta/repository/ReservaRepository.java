package com.udea.consulta.repository;

import com.udea.consulta.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    //Método para buscar por tipo equipaje, tipo clase, o número pasajero máximo
    @Query("SELECT r FROM Reserva r WHERE (:tipoEquipaje IS NULL OR r.tipoEquipaje = :tipoEquipaje) " +
            "AND (:tipoClase IS NULL OR r.tipoClase = :tipoClase) " +
            "AND (:numPasajeroMax IS NULL OR r.numPasajeroMax = :numPasajeroMax)")
    List<Reserva> findByFilters(@Param("tipoEquipaje") String tipoEquipaje,
            @Param("tipoClase") String tipoClase,
            @Param("numPasajeroMax") Integer numPasajeroMax);
}
