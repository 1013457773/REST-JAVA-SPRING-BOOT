package com.example.backend.Servicios;


import com.example.backend.modelos.Estudiante;
import com.example.backend.PALABRAS.MensajesAPI;
import com.example.backend.repositorio.IEstudianteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteServicio {
    @Autowired
    IEstudianteRepositorio repositorio;

    //METODO PARA GUARDAR
    public Estudiante guardarEstuduante(Estudiante DatosEstudiante)throws  Exception{
        try {
            return this.repositorio.save(DatosEstudiante);
        }catch (Exception error){
            throw new Exception();
        }
    }

    //METODO PARA BUSCARTODOS
    public List<Estudiante> ListarEstudiante()throws Exception{
        try {
            return  this.repositorio.findAll();
        }catch (Exception error){
            throw  new Exception();
        }
    }

    //METODO PARA BUSCARUNOPORID
    public Estudiante buscarEstudiantePorid(Integer id)throws Exception{
        try {
            Optional<Estudiante> EstudianteQueEstoyBuscando =this.repositorio.findById(id);
            if (EstudianteQueEstoyBuscando.isPresent()){
                return EstudianteQueEstoyBuscando.get();
            }else {
                throw new Exception(MensajesAPI.ERROR_ESTUDIANTE_NO_ENCONTRADO_.getMensaje());
            }
        }catch (Exception error){
            throw  new Exception(error.getMessage());
        }
    }

    //METODO PARA MODIGICAR
    public Estudiante ModificarEstudiante(Integer id, Estudiante DatosNuevosEstudiante)throws Exception{
        try {
            Optional<Estudiante>EstudianteQueEStoyBuscandoParaEditar=this.repositorio.findById(id);
            if (EstudianteQueEStoyBuscandoParaEditar.isPresent()){
                //modifica ese Asistencia
                EstudianteQueEStoyBuscandoParaEditar.get().setGrado(DatosNuevosEstudiante.getGrado());
                //Guardo Las Modificaciones En BD
                return this.repositorio.save(EstudianteQueEStoyBuscandoParaEditar.get());
            }else {
                throw new Exception(MensajesAPI.ERROR_ESTUDIANTE_NO_ENCONTRADO_.getMensaje());
            }
        }catch (Exception erro){
            throw new Exception(erro.getMessage());
        }

    }

    //METODO PARA ELIMINAR
    public boolean EliminarEstudiante(Integer id)throws Exception{
        try {
            Optional<Estudiante>EstudianteQueBusco=this.repositorio.findById(id);
            if (EstudianteQueBusco.isPresent()){

                this.repositorio.deleteById(id);
                return true;
            }else {
                throw new Exception(MensajesAPI.ERROR_ESTUDIANTE_NO_ENCONTRADO_.getMensaje());
            }

        }catch(Exception erro){
            throw new Exception(erro.getMessage());
        }
    }

}
