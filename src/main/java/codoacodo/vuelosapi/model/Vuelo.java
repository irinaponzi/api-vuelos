package codoacodo.vuelosapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


import java.time.LocalDateTime;

@Entity
public class Vuelo {

    public enum Frecuencia {
        MENSUAL,
        SEMANAL,
        DIARIO;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String origen;
    private String destino;
    private LocalDateTime fechaHoraSalida;
    private LocalDateTime fechaHoraLlegada;
    private double precio;
    private Frecuencia frecuencia;

    public Vuelo() {

    }

    public Vuelo(Long id, String origen, String destino, LocalDateTime fechaHoraSalida, LocalDateTime fechaHoraLlegada, double precio, Frecuencia frecuencia) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.fechaHoraSalida = fechaHoraSalida;
        this.fechaHoraLlegada = fechaHoraLlegada;
        this.precio = precio;
        this.frecuencia = frecuencia;
    }

    public Vuelo(String origen, String destino, LocalDateTime fechaHoraSalida, LocalDateTime fechaHoraLlegada, double precio, Frecuencia frecuencia) {
        this.origen = origen;
        this.destino = destino;
        this.fechaHoraSalida = fechaHoraSalida;
        this.fechaHoraLlegada = fechaHoraLlegada;
        this.precio = precio;
        this.frecuencia = frecuencia;
    }

    public Long getId() {
        return id;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public LocalDateTime getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public LocalDateTime getFechaHoraLlegada() {
        return fechaHoraLlegada;
    }

    public double getPrecio() {
        return precio;
    }

    public Frecuencia getFrecuencia() {
        return frecuencia;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setFechaHoraSalida(LocalDateTime fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }

    public void setFechaHoraLlegada(LocalDateTime fechaHoraLlegada) {
        this.fechaHoraLlegada = fechaHoraLlegada;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setFrecuencia(Frecuencia frecuencia) {
        this.frecuencia = frecuencia;
    }
}
