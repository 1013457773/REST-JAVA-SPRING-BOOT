package com.example.backend.Servicios;

import com.example.backend.modelos.Usuario;
import com.example.backend.repositorio.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicio {

    @Autowired
    IUsuarioRepositorio repositorio;

    public Usuario guardarUsuario(Usuario DatosUsuario)throws  Exception{
        try {
            return this.repositorio.save(DatosUsuario);
        }catch (Exception error){
            throw new Exception();
        }
    }


}
