package com.example.backend.repositorio;

import com.example.backend.modelos.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAsistenciaRepositorio extends JpaRepository <Asistencia,Integer> {

}
