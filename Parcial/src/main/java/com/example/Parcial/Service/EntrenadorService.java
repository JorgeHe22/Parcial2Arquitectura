package com.example.Parcial.Service;

import com.example.Parcial.Model.Entrenador;
import com.example.Parcial.Repository.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntrenadorService {

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    public List<Entrenador> obtenerTodos() {
        return entrenadorRepository.findAll();
    }

    public Optional<Entrenador> buscarPorId(Integer id) {
        return entrenadorRepository.findById(id);
    }

    public Entrenador guardar(Entrenador entrenador) {
        return entrenadorRepository.save(entrenador);
    }

    public void eliminar(Integer id) {
        entrenadorRepository.deleteById(id);
    }
}