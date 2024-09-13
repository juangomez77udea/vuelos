package com.udea.consulta.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipoEquipaje;
    private String tipoClase;
    private Integer numPasajeroMax;

    // Relación muchos-a-uno con Flight
    @ManyToOne
    private Flight idFlight;

    public Reserva() {
    }

    public Reserva(Long id, String tipoEquipaje, String tipoClase, Integer numPasajeroMax, Flight idFlight) {
        this.id = id;
        this.tipoEquipaje = tipoEquipaje;
        this.tipoClase = tipoClase;
        this.numPasajeroMax = numPasajeroMax;
        this.idFlight = idFlight;
    }

    // Getters y setters para todos los atributos

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoEquipaje() {
        return tipoEquipaje;
    }

    public void setTipoEquipaje(String tipoEquipaje) {
        this.tipoEquipaje = tipoEquipaje;
    }

    public String getTipoClase() {
        return tipoClase;
    }

    public void setTipoClase(String tipoClase) {
        this.tipoClase = tipoClase;
    }

    public Integer getNumPasajeroMax() {
        return numPasajeroMax;
    }

    public void setNumPasajeroMax(Integer numPasajeroMax) {
        this.numPasajeroMax = numPasajeroMax;
    }

    public Flight getIdFlight() {
        return idFlight;
    }

    public void setIdFlight(Flight idFlight) {
        this.idFlight = idFlight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reserva reserva = (Reserva) o;
        return Objects.equals(id, reserva.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", tipoEquipaje='" + tipoEquipaje + '\'' +
                ", tipoClase='" + tipoClase + '\'' +
                ", numPasajeroMax=" + numPasajeroMax +
                ", idFlight=" + idFlight +
                '}';
    }
}
