package com.example.backend.repositorio;

import com.example.backend.modelos.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstudianteRepositorio  extends JpaRepository <Estudiante,Integer> {
}
