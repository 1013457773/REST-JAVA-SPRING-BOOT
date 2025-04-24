package com.example.backend.Servicios;


import com.example.backend.modelos.Curso;
import com.example.backend.PALABRAS.MensajesAPI;
import com.example.backend.repositorio.ICursoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServicio {

    @Autowired
    ICursoRepositorio repositorio;

    //METODO PARA GUARDAR
    public Curso guardarCusrso(Curso DatosCurso)throws  Exception{
        try {
            return this.repositorio.save(DatosCurso);
        }catch (Exception error){
            throw new Exception();
        }
    }

    //METODO PARA BUSCARTODOS

    public List<Curso> ListarCurso()throws Exception{
        try {
            return  this.repositorio.findAll();
        }catch (Exception error){
            throw  new Exception();
        }
    }

    //METODO PARA BUSCARUNOPORID

    public Curso buscarCursoPorid(Integer id)throws Exception{
        try {
            Optional<Curso> CursoQueEstoyBuscando =this.repositorio.findById(id);
            if (CursoQueEstoyBuscando.isPresent()){
                return CursoQueEstoyBuscando.get();
            }else {
                throw new Exception(MensajesAPI.ERROR_CURSO_NO_ENCONTRADO_.getMensaje());
            }
        }catch (Exception error){
            throw  new Exception(error.getMessage());
        }
    }

    //METODO PARA MODIGICAR
    public Curso ModificarCurso(Integer id, Curso DatosNuevosCurso)throws Exception{
        try {
            Optional<Curso>CursoQueEStoyBuscandoParaEditar=this.repositorio.findById(id);
            if (CursoQueEStoyBuscandoParaEditar.isPresent()){
                //modifica ese Asistencia
                CursoQueEStoyBuscandoParaEditar.get().setNombre(DatosNuevosCurso.getNombre());
                //Guardo Las Modificaciones En BD
                return this.repositorio.save(CursoQueEStoyBuscandoParaEditar.get());
            }else {
                throw new Exception(MensajesAPI.ERROR_CURSO_NO_ENCONTRADO_.getMensaje());
            }
        }catch (Exception erro){
            throw new Exception(erro.getMessage());
        }
    }

    //METODO PARA ELIMINAR
    public boolean EliminarCurso(Integer id)throws Exception{
        try {
            Optional<Curso>CursoQueBusco=this.repositorio.findById(id);
            if (CursoQueBusco.isPresent()){

                this.repositorio.deleteById(id);
                return true;
            }else {
                throw new Exception(MensajesAPI.ERROR_CURSO_NO_ENCONTRADO_.getMensaje());
            }

        }catch(Exception erro){
            throw new Exception(erro.getMessage());
        }
    }

}
