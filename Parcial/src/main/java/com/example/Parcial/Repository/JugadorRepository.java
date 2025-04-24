package com.example.Parcial.Repository;

import com.example.Parcial.Model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Integer> {
    @Query("SELECT j FROM Jugador j WHERE j.equipo.id = :idEquipo")
    List<Jugador> findByEquipo(@Param("idEquipo") int idEquipo);

}
