package com.example.Parcial.Service;

import com.example.Parcial.Model.Jugador;
import com.example.Parcial.Repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JugadorService {

    @Autowired
    private JugadorRepository jugadorRepository;

    public List<Jugador> obtenerTodos() {
        return jugadorRepository.findAll();
    }

    public Optional<Jugador> buscarPorId(Integer id) {
        return jugadorRepository.findById(id);
    }

    public Jugador guardar(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    public void eliminar(Integer id) {
        jugadorRepository.deleteById(id);
    }
    public List<Jugador> obtenerJugadoresPorEquipo(int idEquipo) {
        System.out.println("Buscando jugadores para el equipo con ID: " + idEquipo);
        List<Jugador> jugadores = jugadorRepository.findByEquipo(idEquipo);
        System.out.println("Jugadores encontrados: " + jugadores.size());
        return jugadores;
    }
}
