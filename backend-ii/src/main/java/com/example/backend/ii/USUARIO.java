package com.example.backend.ii;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "USUARIO")
public class USUARIO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO")
    private Integer IdUsuario;

    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String Nombre;

    @Column(name = "CORREO_ELECTRONICO", unique = true, nullable = false, length = 200)
    private String CorreoElectronico;

    @Column(name = "CONTRASENA", nullable = false, length = 200)
    private String Contrasena;

    @Column(name = "TELEFONO", nullable = false, length = 20)
    private String Telefono;

    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_USUARIO", nullable = false)
    private TipoUsuario TipoUsuario;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Estudiamte estudiamte;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    @JsonManagedReference
    private DOCENTE docente;

    public USUARIO() {
    }

    public USUARIO(Integer IdUsuario, String Nombre, String Contrasena, String CorreoElectronico, String Telefono, TipoUsuario TipoUsuario) {
        this.IdUsuario = IdUsuario;
        this.Nombre = Nombre;
        this.Contrasena = Contrasena;
        this.CorreoElectronico = CorreoElectronico;
        this.Telefono = Telefono;
        this.TipoUsuario = TipoUsuario;
    }

    public Integer getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(Integer IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    public String getCorreoElectronico() {
        return CorreoElectronico;
    }

    public void setCorreoElectronico(String CorreoElectronico) {
        this.CorreoElectronico = CorreoElectronico;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public TipoUsuario getTipoUsuario() {
        return TipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario TipoUsuario) {
        this.TipoUsuario = TipoUsuario;
    }

    private class TipoUsuario {
    }
}
