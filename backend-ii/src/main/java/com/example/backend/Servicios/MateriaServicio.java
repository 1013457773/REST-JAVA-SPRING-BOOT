package com.example.backend.Servicios;

import com.example.backend.modelos.Materia;
import com.example.backend.repositorio.IMateriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MateriaServicio {

    @Autowired
    IMateriaRepositorio repositorio;

    public Materia guardarMateria(Materia DatosMateria)throws  Exception{
        try {
            return this.repositorio.save(DatosMateria);

        }catch (Exception error){
            throw new Exception();
        }
    }
}
