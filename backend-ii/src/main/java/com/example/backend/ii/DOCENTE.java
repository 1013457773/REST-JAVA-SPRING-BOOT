package com.example.backend.ii;

import jakarta.persistence.*;

@Entity
@Table(name = "DOCENTE")
public class DOCENTE {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DOCENTE")
    private Integer IdDocente;

    @Column(name = "ID_USUARIO")
    private Integer IdUsuario;

    @Column(name = "ESPECIALIDAD", nullable = false, length = 100)
    private String Especialidad;

    public DOCENTE() {
    }

    public DOCENTE(Integer IdDocente, Integer IdUsuario, String Especialidad) {
        this.IdDocente = IdDocente;
        this.IdUsuario = IdUsuario;
        this.Especialidad = Especialidad;
    }

    public Integer getIdDocente() {
        return IdDocente;
    }

    public void setIdDocente(Integer IdDocente) {
        this.IdDocente = IdDocente;
    }

    public Integer getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(Integer IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String Especialidad) {
        this.Especialidad = Especialidad;
    }
}
