package com.example.Parcial.Service;

import com.example.Parcial.Model.EstadisticaJugador;
import com.example.Parcial.Repository.EstadisticaJugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadisticaJugadorService {

    @Autowired
    private EstadisticaJugadorRepository estadisticaJugadorRepository;

    public List<EstadisticaJugador> obtenerTodas() {
        return estadisticaJugadorRepository.findAll();
    }

    public Optional<EstadisticaJugador> buscarPorId(Integer id) {
        return estadisticaJugadorRepository.findById(id);
    }

    public EstadisticaJugador guardar(EstadisticaJugador estadistica) {
        return estadisticaJugadorRepository.save(estadistica);
    }

    public void eliminar(Integer id) {
        estadisticaJugadorRepository.deleteById(id);
    }
}