package com.example.Parcial.Controller;

import com.example.Parcial.Model.Partido;
import com.example.Parcial.Service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/partidos")
public class PartidoController {

    @Autowired
    private PartidoService partidoService;

    @GetMapping
    public List<Partido> obtenerTodos() {
        return partidoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Partido> obtenerPorId(@PathVariable Integer id) {
        return partidoService.buscarPorId(id);
    }

    @PostMapping
    public Partido crear(@RequestBody Partido partido) {
        return partidoService.guardar(partido);
    }

    @PutMapping("/{id}")
    public Partido actualizar(@PathVariable Integer id, @RequestBody Partido partido) {
        partido.setIdPartido(id);
        return partidoService.guardar(partido);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        partidoService.eliminar(id);
    }
}
