package com.example.backend.repositorio;

import com.example.backend.modelos.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IDocenteRepositorio extends JpaRepository <Docente,Integer> {
}
