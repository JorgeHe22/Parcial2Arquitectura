package com.example.Parcial.Controller;

import com.example.Parcial.Model.Jugador;
import com.example.Parcial.Service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jugadores")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    @GetMapping
    public List<Jugador> obtenerTodos() {
        return jugadorService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Jugador> obtenerPorId(@PathVariable Integer id) {
        return jugadorService.buscarPorId(id);
    }

    @PostMapping
    public Jugador crear(@RequestBody Jugador jugador) {
        return jugadorService.guardar(jugador);
    }

    @PutMapping("/{id}")
    public Jugador actualizar(@PathVariable Integer id, @RequestBody Jugador jugador) {
        jugador.setIdJugador(id);
        return jugadorService.guardar(jugador);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        jugadorService.eliminar(id);
    }

    @GetMapping("/por-equipo/{id}")
    public ResponseEntity<?> getJugadoresPorEquipo(@PathVariable("id") int idEquipo) {
        try {
            List<Jugador> jugadores = jugadorService.obtenerJugadoresPorEquipo(idEquipo);
            if (jugadores.isEmpty()) {
                return ResponseEntity.ok(new ArrayList<>()); // Devuelve lista vacía, no 404
            }
            return ResponseEntity.ok(jugadores);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al obtener jugadores: " + e.getMessage());
        }
    }
}