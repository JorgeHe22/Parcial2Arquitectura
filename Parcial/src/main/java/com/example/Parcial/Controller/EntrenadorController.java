package com.example.Parcial.Controller;

import com.example.Parcial.Model.Entrenador;
import com.example.Parcial.Service.EntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/entrenadores")
public class EntrenadorController {

    @Autowired
    private EntrenadorService entrenadorService;

    @GetMapping
    public List<Entrenador> obtenerTodos() {
        return entrenadorService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Entrenador> obtenerPorId(@PathVariable Integer id) {
        return entrenadorService.buscarPorId(id);
    }

    @PostMapping
    public Entrenador crear(@RequestBody Entrenador entrenador) {
        return entrenadorService.guardar(entrenador);
    }

    @PutMapping("/{id}")
    public Entrenador actualizar(@PathVariable Integer id, @RequestBody Entrenador entrenador) {
        entrenador.setIdEntrenador(id);
        return entrenadorService.guardar(entrenador);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        entrenadorService.eliminar(id);
    }
}
