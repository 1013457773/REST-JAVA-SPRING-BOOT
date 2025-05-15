package com.example.backend.Servicios;

import com.example.backend.modelos.Asistencia;
import com.example.backend.PALABRAS.MensajesAPI;
import com.example.backend.repositorio.IAsistenciaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsistenciaServicio {

    @Autowired
    IAsistenciaRepositorio repositorio;

    //METODO PARA GUARDAR
    public Asistencia guardarAsistencia(Asistencia DatosAsistencia)throws  Exception{
        try {
            return  this.repositorio.save(DatosAsistencia);
        }catch (Exception error){
            throw  new Exception();
        }
    }

    //METODO PARA BUSCARTODOS
    public List<Asistencia> ListarAsistencia()throws Exception{
        try {
            return  this.repositorio.findAll();
        }catch (Exception error){
            throw  new Exception();
        }
    }

    //METODO PARA BUSCARUNOPORID
    public Asistencia buscarAsistenciaPorid(Integer id)throws Exception{
        try {
            Optional<Asistencia> AsistenciaQueEstoyBuscando=this.repositorio.findById(id);
            if (AsistenciaQueEstoyBuscando.isPresent()){
                return AsistenciaQueEstoyBuscando.get();
            }else {
                throw new Exception(MensajesAPI.ERROR_ASISTENCIA_NO_ENCONTRADO_.getMensaje());
            }
        }catch (Exception error){
            throw  new Exception(error.getMessage());
        }
    }

    //METODO PARA MODIGICAR
    public Asistencia ModificarAsistencia(Integer id, Asistencia DatosNuevosAsistencia)throws Exception{
        try {
            Optional<Asistencia>AsistenciaQueEStoyBuscandoParaEditar=this.repositorio.findById(id);
            if (AsistenciaQueEStoyBuscandoParaEditar.isPresent()){
                    //modifica ese Asistencia
                AsistenciaQueEStoyBuscandoParaEditar.get().setEstado(DatosNuevosAsistencia.getEstado());
                //Guardo Las Modificaciones En BD
                return this.repositorio.save(AsistenciaQueEStoyBuscandoParaEditar.get());
            }else {
                throw new Exception(MensajesAPI.ERROR_ASISTENCIA_NO_ENCONTRADO_.getMensaje());
            }
        }catch (Exception erro){
            throw new Exception(erro.getMessage());
        }
    }

    //METODO PARA ELIMINAR
    public boolean EliminarAsistencia(Integer id)throws Exception{
        try {
            Optional<Asistencia>AsistenciaQueBusco=this.repositorio.findById(id);
            if (AsistenciaQueBusco.isPresent()){
                //lo
                this.repositorio.deleteById(id);
                return true;
            }else {
                throw new Exception(MensajesAPI.ERROR_ASISTENCIA_NO_ENCONTRADO_.getMensaje());
            }

        }catch(Exception erro){
            throw new Exception(erro.getMessage());
        }
    }


}
