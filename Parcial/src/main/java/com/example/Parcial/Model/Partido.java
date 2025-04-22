package com.example.Parcial.Model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPartido;

    private LocalDate fecha;
    private String estadio;

    @ManyToOne
    @JoinColumn(name = "equipo_local")
    private Equipo equipoLocal;

    @ManyToOne
    @JoinColumn(name = "equipo_visita")
    private Equipo equipoVisita;

    private Integer golesLocal;
    private Integer golesVisita;

    @OneToMany(mappedBy = "partido", cascade = CascadeType.ALL)
    private List<EstadisticaJugador> estadisticas;

    public Integer getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(Integer idPartido) {
        this.idPartido = idPartido;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public Equipo getEquipoVisita() {
        return equipoVisita;
    }

    public void setEquipoVisita(Equipo equipoVisita) {
        this.equipoVisita = equipoVisita;
    }

    public Integer getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(Integer golesLocal) {
        this.golesLocal = golesLocal;
    }

    public Integer getGolesVisita() {
        return golesVisita;
    }

    public void setGolesVisita(Integer golesVisita) {
        this.golesVisita = golesVisita;
    }

    public List<EstadisticaJugador> getEstadisticas() {
        return estadisticas;
    }

    public void setEstadisticas(List<EstadisticaJugador> estadisticas) {
        this.estadisticas = estadisticas;
    }
}
