package com.example.backend.repositorio;

import com.example.backend.modelos.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMateriaRepositorio extends JpaRepository <Materia, Integer> {
}
