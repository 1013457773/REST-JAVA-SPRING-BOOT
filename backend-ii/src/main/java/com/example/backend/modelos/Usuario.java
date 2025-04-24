package com.example.backend.modelos;

import com.example.backend.PALABRAS.TipoUsuario;
import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer IdUsuario;

    @Column(name="nombre", nullable = false, length = 100, unique = false)
    private String Nombre;
    @Column (name= "correo_electronico", unique = true, nullable = false, length = 150)
    private String CorreoElectronico;
    @Column(name = "contrasena", nullable = false, length = 255)
    private String Contraseña;
    @Column (name ="telefono",nullable = false, length = 20 )
    private Integer Telefono;
    @Column (name = "tipo_usuario", nullable = false)
    private TipoUsuario tipoUsuario;


    public Usuario() {
    }

    public Usuario(Integer idUsuario, String nombre, String contraseña, String correoElectronico, Integer telefono, TipoUsuario tipoUsuario) {
        IdUsuario = idUsuario;
        Nombre = nombre;
        Contraseña = contraseña;
        CorreoElectronico = correoElectronico;
        Telefono = telefono;
        this.tipoUsuario = tipoUsuario;
    }

    public Integer getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        IdUsuario = idUsuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String contraseña) {
        Contraseña = contraseña;
    }

    public String getCorreoElectronico() {
        return CorreoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        CorreoElectronico = correoElectronico;
    }

    public Integer getTelefono() {
        return Telefono;
    }

    public void setTelefono(Integer telefono) {
        Telefono = telefono;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}

