package com.example.backend.Servicios;


import com.example.backend.modelos.Inscripcion;
import com.example.backend.PALABRAS.MensajesAPI;
import com.example.backend.repositorio.IInscripcionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InscripcionServicio {
    @Autowired
    IInscripcionRepositorio repositorio;

    //METODO PARA GUARDAR
    public Inscripcion guardarInscripcion(Inscripcion DatosInscripcion)throws  Exception{
        try {
            return this.repositorio.save(DatosInscripcion);
        }catch (Exception error){
            throw new Exception();
        }
    }

    //METODO PARA BUSCARTODOS
    public List<Inscripcion> ListarIncripcion()throws Exception{
        try {
            return  this.repositorio.findAll();
        }catch (Exception error){
            throw  new Exception();
        }
    }

    //METODO PARA BUSCARUNOPORID
    public Inscripcion buscarInscripcionPorid(Integer id)throws Exception{
        try {
            Optional<Inscripcion> InscripcionQueEstoyBuscando =this.repositorio.findById(id);
            if (InscripcionQueEstoyBuscando.isPresent()){
                return InscripcionQueEstoyBuscando.get();
            }else {
                throw new Exception(MensajesAPI.ERROR_INSCRIPCION_NO_ENCONTRADO_.getMensaje());
            }
        }catch (Exception error){
            throw  new Exception(error.getMessage());
        }
    }

    //METODO PARA MODIGICAR
    public Inscripcion ModificarInscripcion(Integer id, Inscripcion DatosNuevosInscripcion)throws Exception{
        try {
            Optional<Inscripcion>InscripcionQueEStoyBuscandoParaEditar=this.repositorio.findById(id);
            if (InscripcionQueEStoyBuscandoParaEditar.isPresent()){
                //modifica ese Asistencia
                InscripcionQueEStoyBuscandoParaEditar.get().setFechaInscripcion(DatosNuevosInscripcion.getFechaInscripcion());
                return this.repositorio.save(InscripcionQueEStoyBuscandoParaEditar.get());
            }else {
                throw new Exception(MensajesAPI.ERROR_INSCRIPCION_NO_ENCONTRADO_.getMensaje());
            }
        }catch (Exception erro){
            throw new Exception(erro.getMessage());
        }

    }

    //METODO PARA ELIMINAR
    public boolean EliminarIncripcion(Integer id)throws Exception{
        try {
            Optional<Inscripcion>InscripcionQueBusco=this.repositorio.findById(id);
            if (InscripcionQueBusco.isPresent()){

                this.repositorio.deleteById(id);
                return true;
            }else {
                throw new Exception(MensajesAPI.ERROR_INSCRIPCION_NO_ENCONTRADO_.getMensaje());
            }

        }catch(Exception erro){
            throw new Exception(erro.getMessage());
        }
    }

}
