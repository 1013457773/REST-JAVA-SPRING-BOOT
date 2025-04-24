package com.example.backend.Servicios;

import com.example.backend.modelos.Inscripcion;
import com.example.backend.repositorio.IInscripcionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InscripcionServicio {
    @Autowired
    IInscripcionRepositorio repositorio;

    public Inscripcion guardarInscripcion(Inscripcion DatosInscripcion)throws  Exception{
        try {
            return this.repositorio.save(DatosInscripcion);
        }catch (Exception error){
            throw new Exception();
        }
    }

}
