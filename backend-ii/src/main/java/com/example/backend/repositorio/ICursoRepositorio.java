package com.example.backend.repositorio;

import com.example.backend.modelos.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICursoRepositorio extends JpaRepository <Curso,Integer> {
}
