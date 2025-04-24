package com.example.backend.Servicios;


import com.example.backend.modelos.Docente;
import com.example.backend.PALABRAS.MensajesAPI;
import com.example.backend.repositorio.IDocenteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocenteServicio {

    @Autowired
    IDocenteRepositorio repositorio;

    //METODO PARA GUARDAR
    public Docente guardarDocente(Docente DatosDocente)throws  Exception{
        try {
            return this.repositorio.save(DatosDocente);
        }catch (Exception error){
            throw new Exception();
        }
    }

    //METODO PARA BUSCARTODOS
    public List<Docente> ListarDocente()throws Exception{
        try {
            return  this.repositorio.findAll();
        }catch (Exception error){
            throw  new Exception();
        }
    }

    //METODO PARA BUSCARUNOPORID

    public Docente buscarDocentePorid(Integer id)throws Exception{
        try {
            Optional<Docente> DocenteQueEstoyBuscando =this.repositorio.findById(id);
            if (DocenteQueEstoyBuscando.isPresent()){
                return DocenteQueEstoyBuscando.get();
            }else {
                throw new Exception(MensajesAPI.ERROR_DOCENTE_NO_ENCONTRADO_.getMensaje());
            }
        }catch (Exception error){
            throw  new Exception(error.getMessage());
        }
    }

    //METODO PARA MODIGICAR
    public Docente ModificarDocente(Integer id, Docente DatosNuevosDocente)throws Exception{
        try {
            Optional<Docente>DocenteQueEStoyBuscandoParaEditar=this.repositorio.findById(id);
            if (DocenteQueEStoyBuscandoParaEditar.isPresent()){
                //modifica ese Asistencia
                DocenteQueEStoyBuscandoParaEditar.get().setEspecialidad(DatosNuevosDocente.getEspecialidad());
                //Guardo Las Modificaciones En BD
                return this.repositorio.save(DocenteQueEStoyBuscandoParaEditar.get());
            }else {
                throw new Exception(MensajesAPI.ERROR_DOCENTE_NO_ENCONTRADO_.getMensaje());
            }
        }catch (Exception erro){
            throw new Exception(erro.getMessage());
        }

    }

    //METODO PARA ELIMINAR
    public boolean EliminarDocente(Integer id)throws Exception{
        try {
            Optional<Docente>DocenteQueBusco=this.repositorio.findById(id);
            if (DocenteQueBusco.isPresent()){

                this.repositorio.deleteById(id);
                return true;
            }else {
                throw new Exception(MensajesAPI.ERROR_DOCENTE_NO_ENCONTRADO_.getMensaje());
            }

        }catch(Exception erro){
            throw new Exception(erro.getMessage());
        }
    }

}
