package com.example.backend.Servicios;


import com.example.backend.modelos.Materia;
import com.example.backend.PALABRAS.MensajesAPI;
import com.example.backend.repositorio.IMateriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MateriaServicio {

    @Autowired
    IMateriaRepositorio repositorio;

    //METODO PARA GUARDAR
    public Materia guardarMateria(Materia DatosMateria)throws  Exception{
        try {
            return this.repositorio.save(DatosMateria);

        }catch (Exception error){
            throw new Exception();
        }
    }

    //METODO PARA BUSCARTODOS
    public List<Materia> ListarMateria()throws Exception{
        try {
            return  this.repositorio.findAll();
        }catch (Exception error){
            throw  new Exception();
        }
    }

    //METODO PARA BUSCARUNOPORID
    public Materia buscarMateriaPorid(Integer id)throws Exception{
        try {
            Optional<Materia> MateriaQueEstoyBuscando =this.repositorio.findById(id);
            if (MateriaQueEstoyBuscando.isPresent()){
                return MateriaQueEstoyBuscando.get();
            }else {
                throw new Exception(MensajesAPI.ERROR_MATERIA_NO_ENCONTRADO_.getMensaje());
            }
        }catch (Exception error){
            throw  new Exception(error.getMessage());
        }
    }

    //METODO PARA MODIGICAR
    public Materia ModificarMateria(Integer id, Materia DatosNuevosMateria)throws Exception{
        try {
            Optional<Materia>MateriaQueEStoyBuscandoParaEditar=this.repositorio.findById(id);
            if (MateriaQueEStoyBuscandoParaEditar.isPresent()){
                //modifica ese Asistencia
                MateriaQueEStoyBuscandoParaEditar.get().setNombre(DatosNuevosMateria.getNombre());
                return this.repositorio.save(MateriaQueEStoyBuscandoParaEditar.get());
            }else {
                throw new Exception(MensajesAPI.ERROR_MATERIA_NO_ENCONTRADO_.getMensaje());
            }
        }catch (Exception erro){
            throw new Exception(erro.getMessage());
        }
    }

    //METODO PARA ELIMINAR
    public boolean EliminarMateria(Integer id)throws Exception{
        try {
            Optional<Materia>MateriaQueBusco=this.repositorio.findById(id);
            if (MateriaQueBusco.isPresent()){

                this.repositorio.deleteById(id);
                return true;
            }else {
                throw new Exception(MensajesAPI.ERROR_MATERIA_NO_ENCONTRADO_.getMensaje());
            }

        }catch(Exception erro){
            throw new Exception(erro.getMessage());
        }
    }

}
