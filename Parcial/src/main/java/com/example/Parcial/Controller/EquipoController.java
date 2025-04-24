package com.example.Parcial.Controller;

import com.example.Parcial.Model.Equipo;
import com.example.Parcial.Service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/equipos")
public class EquipoController {

    @Autowired
    private EquipoService equipoService;

    @GetMapping
    public List<Equipo> obtenerTodos() {
        return equipoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Equipo> obtenerPorId(@PathVariable Integer id) {
        return equipoService.buscarPorId(id);
    }

    @PostMapping
    public Equipo crear(@RequestBody Equipo equipo) {
        return equipoService.guardar(equipo);
    }

    @PutMapping("/{id}")
    public Equipo actualizar(@PathVariable Integer id, @RequestBody Equipo equipo) {
        equipo.setIdEquipo(id);
        return equipoService.guardar(equipo);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        equipoService.eliminar(id);
    }
}
