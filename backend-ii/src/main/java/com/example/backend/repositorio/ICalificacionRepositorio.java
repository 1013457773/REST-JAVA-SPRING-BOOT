package com.example.backend.repositorio;


import com.example.backend.modelos.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICalificacionRepositorio extends JpaRepository <Calificacion, Integer> {
}
