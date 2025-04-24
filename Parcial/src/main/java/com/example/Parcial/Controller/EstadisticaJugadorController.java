package com.example.Parcial.Controller;

import com.example.Parcial.Model.EstadisticaJugador;
import com.example.Parcial.Service.EstadisticaJugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estadisticas")
public class EstadisticaJugadorController {

    @Autowired
    private EstadisticaJugadorService estadisticaJugadorService;

    @GetMapping
    public List<EstadisticaJugador> obtenerTodas() {
        return estadisticaJugadorService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public Optional<EstadisticaJugador> obtenerPorId(@PathVariable Integer id) {
        return estadisticaJugadorService.buscarPorId(id);
    }

    @PostMapping
    public EstadisticaJugador crear(@RequestBody EstadisticaJugador estadistica) {
        return estadisticaJugadorService.guardar(estadistica);
    }

    @PutMapping("/{id}")
    public EstadisticaJugador actualizar(@PathVariable Integer id, @RequestBody EstadisticaJugador estadistica) {
        estadistica.setIdEstadistica(id);
        return estadisticaJugadorService.guardar(estadistica);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        estadisticaJugadorService.eliminar(id);
    }
}
