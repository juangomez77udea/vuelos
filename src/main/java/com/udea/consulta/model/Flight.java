package com.udea.consulta.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String origin;
    private String destination;
    private LocalDate date;
    private double price;
    private String tipoEquipaje;
    private String tipoClase;
    private Integer numPasajeroMax;


    public Flight() {
    }

    public Flight(Long id, String origin, String destination, LocalDate date, double price, String tipoEquipaje, String tipoClase, Integer numPasajeroMax) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.price = price;
        this.tipoEquipaje = tipoEquipaje;
        this.tipoClase = tipoClase;
        this.numPasajeroMax = numPasajeroMax;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(id, flight.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
