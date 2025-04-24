package com.example.backend.Servicios;


import com.example.backend.modelos.Usuario;
import com.example.backend.PALABRAS.MensajesAPI;
import com.example.backend.repositorio.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio {

    @Autowired
    IUsuarioRepositorio repositorio;

    //METODO PARA GUARDAR
    public Usuario guardarUsuario(Usuario DatosUsuario)throws  Exception{
        try {
            return this.repositorio.save(DatosUsuario);
        }catch (Exception error){
            throw new Exception();
        }
    }

    //METODO PARA BUSCARTODOS
    public List<Usuario> ListarUsuario()throws Exception{
        try {
            return  this.repositorio.findAll();
        }catch (Exception error){
            throw  new Exception();
        }
    }

    //METODO PARA BUSCARUNOPORID
    public Usuario buscarUsuarioPorid(Integer id)throws Exception{
        try {
            Optional<Usuario> UsuarioQueEstoyBuscando =this.repositorio.findById(id);
            if (UsuarioQueEstoyBuscando.isPresent()){
                return UsuarioQueEstoyBuscando.get();
            }else {
                throw new Exception(MensajesAPI.ERROR_USUARIO_NO_ENCONTRADO_.getMensaje());
            }
        }catch (Exception error){
            throw  new Exception(error.getMessage());
        }
    }

    //METODO PARA MODIGICAR
    public Usuario ModificarUsuario(Integer id, Usuario DatosNuevosUsuario)throws Exception{
        try {
            Optional<Usuario>UsuarioQueEStoyBuscandoParaEditar=this.repositorio.findById(id);
            if (UsuarioQueEStoyBuscandoParaEditar.isPresent()){
                //modifica ese Asistencia
                UsuarioQueEStoyBuscandoParaEditar.get().setNombre(DatosNuevosUsuario.getNombre());
                return this.repositorio.save(UsuarioQueEStoyBuscandoParaEditar.get());
            }else {
                throw new Exception(MensajesAPI.ERROR_USUARIO_NO_ENCONTRADO_.getMensaje());
            }
        }catch (Exception erro){
            throw new Exception(erro.getMessage());
        }
    }

    //METODO PARA ELIMINAR
    public boolean EliminarUsuario(Integer id)throws Exception{
        try {
            Optional<Usuario>UsuarioQueBusco=this.repositorio.findById(id);
            if (UsuarioQueBusco.isPresent()){

                this.repositorio.deleteById(id);
                return true;
            }else {
                throw new Exception(MensajesAPI.ERROR_USUARIO_NO_ENCONTRADO_.getMensaje());
            }

        }catch(Exception erro){
            throw new Exception(erro.getMessage());
        }
    }


}
