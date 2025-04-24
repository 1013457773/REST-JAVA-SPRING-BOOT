package com.example.backend.Servicios;


import com.example.backend.modelos.Estudiante;
import com.example.backend.repositorio.IEstudianteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudianteServicio {
    @Autowired
    IEstudianteRepositorio repositorio;

    public Estudiante guardarEstuduante(Estudiante DatosEstudiante)throws  Exception{
        try {
            return this.repositorio.save(DatosEstudiante);
        }catch (Exception error){
            throw new Exception();
        }
    }
}
