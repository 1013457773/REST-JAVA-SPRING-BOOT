package com.example.backend.Servicios;

import com.example.backend.modelos.Calificacion;
import com.example.backend.PALABRAS.MensajesAPI;
import com.example.backend.repositorio.ICalificacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalificacionServio {

    @Autowired
    ICalificacionRepositorio repositorio;

    //METODO PARA GUARDAR
    public Calificacion guardarCalificacion(Calificacion DatosCalificacion)throws  Exception{
        try {
            return this.repositorio.save(DatosCalificacion);
        }catch (Exception error){
            throw new Exception();
        }
    }

    //METODO PARA BUSCARTODOS

    public List<Calificacion> ListarCalificacion()throws Exception{
        try {
            return  this.repositorio.findAll();
        }catch (Exception error){
            throw  new Exception();
        }
    }

    //METODO PARA BUSCARUNOPORID

    public Calificacion buscarCalificacionPorid(Integer id)throws Exception{
        try {
            Optional<Calificacion> CalificacionQueEstoyBuscando =this.repositorio.findById(id);
            if (CalificacionQueEstoyBuscando.isPresent()){
                return CalificacionQueEstoyBuscando.get();
            }else {
                throw new Exception(MensajesAPI.ERROR_CALIFICACION_NO_ENCONTRADO_.getMensaje());
            }
        }catch (Exception error){
            throw  new Exception(error.getMessage());
        }
    }

    //METODO PARA MODIGICAR
    public Calificacion ModificarCalificacion(Integer id, Calificacion DatosNuevosCalificacion)throws Exception{
        try {
            Optional<Calificacion>CalificacionQueEStoyBuscandoParaEditar=this.repositorio.findById(id);
            if (CalificacionQueEStoyBuscandoParaEditar.isPresent()){
                //modifica ese Asistencia
               CalificacionQueEStoyBuscandoParaEditar.get().setNota(DatosNuevosCalificacion.getNota());
                //Guardo Las Modificaciones En BD
                return this.repositorio.save(CalificacionQueEStoyBuscandoParaEditar.get());
            }else {
                throw new Exception(MensajesAPI.ERROR_CALIFICACION_NO_ENCONTRADO_.getMensaje());
            }
        }catch (Exception erro){
            throw new Exception(erro.getMessage());
        }
    }


    //METODO PARA ELIMINAR
    public boolean EliminarCalificacion(Integer id)throws Exception{
        try {
            Optional<Calificacion>CalificacionQueBusco=this.repositorio.findById(id);
            if (CalificacionQueBusco.isPresent()){
                //lo
                this.repositorio.deleteById(id);
                return true;
            }else {
                throw new Exception(MensajesAPI.ERROR_CALIFICACION_NO_ENCONTRADO_.getMensaje());
            }

        }catch(Exception erro){
            throw new Exception(erro.getMessage());
        }
    }

}
