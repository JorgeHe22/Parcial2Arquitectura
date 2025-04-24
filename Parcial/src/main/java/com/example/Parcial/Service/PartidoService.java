package com.example.Parcial.Service;

import com.example.Parcial.Model.Partido;
import com.example.Parcial.Repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartidoService {

    @Autowired
    private PartidoRepository partidoRepository;

    public List<Partido> obtenerTodos() {
        return partidoRepository.findAll();
    }

    public Optional<Partido> buscarPorId(Integer id) {
        return partidoRepository.findById(id);
    }

    public Partido guardar(Partido partido) {
        return partidoRepository.save(partido);
    }

    public void eliminar(Integer id) {
        partidoRepository.deleteById(id);
    }
}